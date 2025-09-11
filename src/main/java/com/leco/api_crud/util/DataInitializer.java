package com.leco.api_crud.util;

import com.leco.api_crud.model.UserJwt;
import com.leco.api_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByUsername("admin") == null) {
            UserJwt user = new UserJwt();
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("admin123"));
            userRepository.save(user);
        }
    }
}