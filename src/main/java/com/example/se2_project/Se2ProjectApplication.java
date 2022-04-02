package com.example.se2_project;

import com.example.se2_project.auth.PasswordEncoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Se2ProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(Se2ProjectApplication.class, args);
        // get password for database test
        System.out.println(PasswordEncoder.encodePassword("adminpw"));
        System.out.println(PasswordEncoder.encodePassword("userpw"));
    }

}
