package com.sda.auction.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
public class LoginDto {

    private String jwt;

    @NotEmpty
    @Email(message = "{error.user.email.regex}")
    private String email;

    @NotEmpty
    @Pattern(regexp = "((.*)[A-Z]+(.*))", message = "Password should contain at least one capital letter")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

}
