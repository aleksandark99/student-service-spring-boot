package com.ftn.studentservice.controller;

import com.ftn.student_service.api.model.AccountResponse;
import com.ftn.student_service.api.model.PaymentResponse;
import com.ftn.student_service.api.spec.v1.AccountApi;
import com.ftn.studentservice.model.Account;
import com.ftn.studentservice.model.Payment;
import com.ftn.studentservice.service.AccountService;
import com.ftn.studentservice.utills.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class AccountController implements AccountApi {

    @Autowired
    private AccountService accountService;

    private ObjectMapperUtils mapper;

    @Override
    public ResponseEntity<AccountResponse> getMyAccount() {
        Account account = accountService.getAccount();
        return ResponseEntity.ok(mapper.map(account, AccountResponse.class));
    }

    @Override
    public ResponseEntity<List<PaymentResponse>> getMyAccount_0() {
        List<Payment> payments = accountService.getPayments();
        return  ResponseEntity.ok(mapper.mapAll(payments, PaymentResponse.class));
    }

    @Override
    public ResponseEntity<Void> makePayment(BigDecimal amount) {
        accountService.makePayment(amount.doubleValue());
        return ResponseEntity.ok().build();
    }
}
