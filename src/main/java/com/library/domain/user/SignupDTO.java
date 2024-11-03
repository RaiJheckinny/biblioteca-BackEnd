package com.library.domain.user;

public record SignupDTO(String name, String email,String password, UserRole role) {
}
