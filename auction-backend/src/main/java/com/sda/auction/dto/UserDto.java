package com.sda.auction.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode
//@AllArgsConstructor
public class UserDto {

    @NotEmpty(message = "Please insert your first name")
    @Pattern(regexp = "[A-Za-z]+", message = "Letters only!")
    private String firstName;

    @NotEmpty(message = "Please insert your last name")
    @Pattern(regexp = "[A-Za-z]+", message = "Letters only!")
    private String lastName;

    @Email(message = "{error.user.email.pattern}")
    private String email;

    @Pattern(regexp = "((.*)[A-Z]+(.*))",message = "Password should contain at least one capital letter!")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;
}
