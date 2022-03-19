package com.example.se2_project;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncryptor {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "matkhau";
        String encodedPassword = encoder.encode(rawPassword);

        System.out.printf(encodedPassword);
    }
}
