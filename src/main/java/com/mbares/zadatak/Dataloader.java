package com.mbares.zadatak;

import com.mbares.zadatak.entity.User;
import com.mbares.zadatak.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Dataloader implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    public Dataloader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args) {
        if (userRepository.findByUsername("user") == null) {
            userRepository.save(new User("pero", "peric", "user", "user123"));
        }
        if (userRepository.findByUsername("test") == null) {
            userRepository.save(new User("ivo", "ivic", "test", "test123"));
        }
    }
}
