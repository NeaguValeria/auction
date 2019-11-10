package com.sda.auction.Service;

import com.sda.auction.dto.UserDto;
import com.sda.auction.model.User;

public interface UserService {

    UserDto addUser (UserDto userDto);

    User findByEmail(String email);
}
