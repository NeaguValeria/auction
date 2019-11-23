package com.sda.auction.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
public class UserDto {

    private Integer id;

    @NotEmpty(message = "Please insert your first name")
    @Pattern(regexp = "[A-Za-z]+", message = "Letters only!")
    private String firstName;

    @NotEmpty(message = "Please insert your last name")
    @Pattern(regexp = "[A-Za-z]+", message = "Letters only!")
    private String lastName;

    @NotEmpty
    @Email(message = "{error.user.email.regex}")
    private String email;

    @NotEmpty
    @Pattern(regexp = "((.*)[A-Z]+(.*))", message = "Password should contain at least one capital letter")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @NotEmpty
    @Pattern(regexp = "((.*)[A-Z]+(.*))", message = "Confirm password should contain at least one capital letter")
    @Size(min = 6, message = "Confirm password must be at least 6 characters long")
    private String confirmPassword;


}
