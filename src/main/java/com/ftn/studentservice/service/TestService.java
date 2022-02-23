package com.ftn.studentservice.service;

import com.ftn.student_service.api.model.TestInstance;
import com.ftn.student_service.api.model.TestInstanceRequest;
import com.ftn.studentservice.model.*;
import com.ftn.studentservice.repository.*;
import com.ftn.studentservice.service.exceptions.CustomException;
import com.ftn.studentservice.service.exceptions.InvalidBalanceException;
import com.ftn.studentservice.utills.TimeUtills;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestService {

    @Autowired
    private TestStudentInstanceRepository testStudentInstanceRepository;

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ExamPeriodRepository examPeriodRepository;

    @Autowired
    private CourseInstanceRepository courseInstanceRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public void registerForTest(Long testId) throws InvalidBalanceException, CustomException {
        Student student = studentService.getLoggedInStudent();
        if(student.getAccount().getBalance()>200) {
            Test test = testRepository.findById(testId).orElseThrow();
            if(test.getTestStudentInstances().stream().anyMatch(testStudentInstance ->
                    testStudentInstance.getStudent().getId().equals(student.getId()) && testStudentInstance.getTest().getId().equals(testId)))
                throw new CustomException("You have already registered for this test");

            TestStudentInstance testStudentInstance = new TestStudentInstance();
            testStudentInstance.setTest(test);
            testStudentInstance.setStudent(student);
            testStudentInstance.setGraded(false);
            testStudentInstance.setPoints(0);
            testStudentInstanceRepository.save(testStudentInstance);
            Payment payment = new Payment();
            payment.setDate(LocalDateTime.now());
            payment.setAmount(-200.00);
            payment.setAccount(student.getAccount());
            paymentRepository.save(payment);

            student.getAccount().setBalance(student.getAccount().getBalance()-200.00);
            accountRepository.save(student.getAccount());

        }
        else{
            throw new InvalidBalanceException("You dont have enought money to register for exam! price 200.00");
        }


    }

    public List<TestStudentInstance> getMyTests() {
        return testStudentInstanceRepository.findAllByStudent_Id(studentService.getLoggedInStudent().getId());
    }

    public void createTest(TestInstanceRequest testInstanceRequest) throws CustomException {
        ExamPeriod examPeriod = examPeriodRepository.findById(testInstanceRequest.getExamPeriodId())
                .orElseThrow(() -> new CustomException("Exam Period not found"));
//        if(examPeriod.getTests().stream().anyMatch(test -> test.getCourseInstance().getId().equals(testInstanceRequest.getCourseInstanceId())))
//            throw new CustomException("There is already test for this subject in this exam period");
        CourseInstance courseInstance = courseInstanceRepository.findById(testInstanceRequest.getCourseInstanceId())
                .orElseThrow(() -> new CustomException("Course not found"));

        Test test = new Test();
        test.setDate(TimeUtills.jodaToJavaLocalDateTime(testInstanceRequest.getDate()));
        test.setDescription("null");
        test.setCourseInstance(courseInstance);
        test.setPeriod(examPeriod);
        test.setMaxPoints(testInstanceRequest.getMaxPoints());
        test.setPlace(testInstanceRequest.getPlace());
        test.setTitle(testInstanceRequest.getTitle());

        testRepository.save(test);


    }

    public void gradeTest(Long testInstanceId, Integer points) throws CustomException {
        TestStudentInstance testStudentInstance = testStudentInstanceRepository.findById(testInstanceId)
                .orElseThrow(() -> new CustomException("Test instance not found"));
        testStudentInstance.setPoints(points);
        testStudentInstance.setGraded(true);

        var studentsEnrollment=testStudentInstance.getStudent().getEnrollments().stream()
                .filter(enrollment ->enrollment.getCourseInstance().getId().equals(testStudentInstance.getTest().getCourseInstance().getId()))
                .collect(Collectors.toList()).stream().findFirst();

        //add points to enrollment
        studentsEnrollment.get().setPoints(studentsEnrollment.get().getPoints()+points);
        if(studentsEnrollment.get().getPoints()>100)
            studentsEnrollment.get().setPassed(true);

        enrollmentRepository.save(studentsEnrollment.get());
        testStudentInstanceRepository.save(testStudentInstance);

    }
}
