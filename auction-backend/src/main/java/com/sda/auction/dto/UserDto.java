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

    @NotEmpty(message = "{error.user.lastName.notEmpty}")
    @Pattern(regexp = "[A-Za-z]+", message = "{error.user.lastName.pattern}")
    private String lastName;

    @NotEmpty(message = "{error.user.email.notEmpty}")
    @Email(message = "{error.user.email.regex}")//acelasi ca si in message.properties
    private String email;

    @NotEmpty(message = "{error.user.password.notEmpty}")
    @Pattern(regexp = "((.*)[A-Z]+(.*))",message = "{error.user.password.pattern}")
    @Size(min = 6, message = "{error.user.password.size}")
    private String password;


    @NotEmpty(message = "{error.user.confirmPassword.notEmpty}")
    @Pattern(regexp = "((.*)[A-Z]+(.*))",message = "{error.user.confirmPassword.pattern}")
    @Size(min = 6, message = "error.user.confirmPassword.size")
    private String confirmPassword;

}
