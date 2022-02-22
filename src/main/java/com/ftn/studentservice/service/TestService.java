package com.ftn.studentservice.service;

import com.ftn.student_service.api.model.TestInstance;
import com.ftn.student_service.api.model.TestInstanceRequest;
import com.ftn.studentservice.model.*;
import com.ftn.studentservice.repository.CourseInstanceRepository;
import com.ftn.studentservice.repository.ExamPeriodRepository;
import com.ftn.studentservice.repository.TestRepository;
import com.ftn.studentservice.repository.TestStudentInstanceRepository;
import com.ftn.studentservice.service.exceptions.CustomException;
import com.ftn.studentservice.service.exceptions.InvalidBalanceException;
import com.ftn.studentservice.utills.TimeUtills;
import net.bytebuddy.implementation.bytecode.Throw;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void registerForTest(Long testId) throws InvalidBalanceException {
        Student student = studentService.getLoggedInStudent();
        if(student.getAccount().getBalance()>200) {
            Test test = testRepository.findById(testId).orElseThrow();

            TestStudentInstance testStudentInstance = new TestStudentInstance();
            testStudentInstance.setTest(test);
            testStudentInstance.setStudent(student);
            testStudentInstance.setGraded(false);
            testStudentInstance.setPoints(0);
            testStudentInstanceRepository.save(testStudentInstance);
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
        if(examPeriod.getTests().stream().anyMatch(test -> test.getCourseInstance().getId().equals(testInstanceRequest.getCourseInstanceId())))
            throw new CustomException("There is already test for this subject in this exam period");
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
        
    }
}
