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


    private Integer id;

    @NotEmpty(message = "{error.user.firstName.notEmpty}")
    @Pattern(regexp = "[A-Za-z]+", message = "{error.user.firstName.pattern}")
    private String firstName;

    @NotEmpty(message = "Please insert your last name")
    @Pattern(regexp = "[A-Za-z]+", message = "Letters only!")
    private String lastName;

    @NotEmpty(message = "{error.user.email.notEmpty}")
    @Email(message = "{error.user.email.regex}")//acelasi ca si in message.properties
    private String email;

    @NotEmpty(message = "Please insert your password")
    @Pattern(regexp = "((.*)[A-Z]+(.*))",message = "Password should contain at least one capital letter!")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;


    @NotEmpty(message = "PLease insert your confirm password")
    @Pattern(regexp = "((.*)[A-Z]+(.*))",message = "Password should contain at least one capital letter!")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String confirmPassword;

}
