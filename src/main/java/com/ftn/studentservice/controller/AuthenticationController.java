package com.ftn.studentservice.controller;
import com.ftn.student_service.api.model.LoginRequest;
import com.ftn.student_service.api.model.LoginResponse;
import com.ftn.student_service.api.model.RegisterRequest;
import com.ftn.student_service.api.spec.v1.UserApi;
import com.ftn.studentservice.security.jwt.JwtUtils;
import com.ftn.studentservice.security.services.UserDetailsImpl;
import com.ftn.studentservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AuthenticationController implements UserApi {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<LoginResponse> login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        LoginResponse loginResponse= new LoginResponse();
        loginResponse.setToken(jwt);
        loginResponse.setRole(roles.get(0));
        return ResponseEntity.ok(loginResponse);
    }

    @Override
    public ResponseEntity<Void> register(RegisterRequest registerRequest) {
        userService.register(registerRequest);
        return ResponseEntity.status(201).build();
    }


}