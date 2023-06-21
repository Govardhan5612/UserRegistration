package com.bridgeLabz.userRegistration.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserDto {
    @Pattern(regexp = "[A-Z]{1}[a-z]{2,}", message = "Invalid First name")
    @NotBlank(message = "Not take Blank values")
    private String name;
    @NotBlank(message = "Not take Blank values")
    @Pattern(regexp = "[9876]{1}[0-9]{9}",message = "Invalid phone number")
    private String phoneNumber;
    @NotBlank(message = "Not take Blank values")
    @Email(regexp = "[a-zA-Z0-9]{6,25}@gmail.com",message = "Invalid email address" )
    private String email;
    @NotBlank(message = "Not take Blank values")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%&*]).{8,20}$",message = "Enter Strong password")
    private String password;
}
