package com.sda.auction.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode
//@AllArgsConstructor
public class LoginDto {


    private String jwt;

    @NotEmpty(message = "{error.user.email.notEmpty}")
    @Email(message = "{error.user.email.regex}")
    private String email;

    @NotEmpty(message = "{error.user.password.notEmpty}")
    @Pattern(regexp = "((.*)[A-Z]+(.*))",message = "{error.user.password.pattern}")
    @Size(min = 6, message = "{error.user.password.size}")
    private String password;




}
