package com.ftn.studentservice.service;

import com.ftn.studentservice.model.Account;
import com.ftn.studentservice.model.Payment;
import com.ftn.studentservice.model.Student;
import com.ftn.studentservice.repository.AccountRepository;
import com.ftn.studentservice.repository.PaymentRepository;
import com.ftn.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private StudentService studentService;

    public Account getAccount(){
        Student student = studentService.getLoggedInStudent();
        return student.getAccount();
    }

    public List<Payment> getPayments() {
        Student student = studentService.getLoggedInStudent();
        return student.getAccount().getPayments();
    }

    public void makePayment(double amount) {
        Student student = studentService.getLoggedInStudent();
        Payment payment = new Payment();
        payment.setAccount(student.getAccount());
        payment.setAmount(amount);
        payment.setDate(LocalDateTime.now());
        paymentRepository.save(payment);
    }
}
