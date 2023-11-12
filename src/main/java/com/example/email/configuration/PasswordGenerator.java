package com.example.email.configuration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String userPassword = "userPwd";
        String encodedUserPassword = encoder.encode(userPassword);
        System.out.println("User password: " + encodedUserPassword);

        String adminPassword = "adminPwd";
        String encodedAdminPassword = encoder.encode(adminPassword);
        System.out.println("\nAdmin password: " + encodedAdminPassword);
    }
}
