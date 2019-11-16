package com.sda.auction.service;

import com.sda.auction.dto.LoginDto;
import com.sda.auction.dto.UserDto;
import com.sda.auction.model.User;

public interface SecurityService {


    boolean passwordMatch(LoginDto userDto, User user);

    LoginDto createDtoWithJwt(User user);
}

