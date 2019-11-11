package com.sda.auction.validator;

import com.sda.auction.service.UserService;
import com.sda.auction.dto.UserDto;
import com.sda.auction.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDtoValidator {

    @Autowired
    private UserService userService;


    public boolean validate(UserDto userDto){
        if (passwordDontMatch(userDto)) {
            throw new  RuntimeException("Password do not match!");
        }
        if (emailAlreadyRegistered(userDto.getEmail())) {
            throw  new RuntimeException("Email already registered!");
            /*return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);*/
        }
        return  true;
    }

    private boolean passwordDontMatch(UserDto userDto) {
        return userDto.getPassword().compareTo(userDto.getConfirmPassword()) != 0;
    }

    private boolean emailAlreadyRegistered(String email) {
        User user = userService.findByEmail(email);
        return user != null;
    }
}
