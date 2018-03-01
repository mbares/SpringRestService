package com.mbares.zadatak;

import com.mbares.zadatak.entity.User;
import com.mbares.zadatak.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZadatakApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZadatakApplication.class, args);
	}
}
