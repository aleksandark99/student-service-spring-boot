package com.ftn.studentservice.service;

import com.ftn.student_service.api.model.RegisterRequest;
import com.ftn.studentservice.model.Role;
import com.ftn.studentservice.model.User;
import com.ftn.studentservice.repository.RoleRepository;
import com.ftn.studentservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserService  {

    @Autowired
    private UserRepository userDao;



    @Autowired
    private RoleRepository roleRepository;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.findByEmail(email).get();
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
            //authorities.add(new SimpleGrantedAuthority(role.getName()));
            authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getName()));
        return authorities;
        //return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public User findById(Long id) {
        return userDao.findById(id).get();
    }

    public void register(RegisterRequest registerRequest) {
        BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();
        User user=new User();
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        user.setEmail(registerRequest.getEmail());
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        Role role = roleRepository.findByName(registerRequest.getRole().toString()).get();
        user.setRole(role);
        userDao.save(user);
    }

}