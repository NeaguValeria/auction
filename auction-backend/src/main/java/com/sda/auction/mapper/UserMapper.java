package com.sda.auction.mapper;

import com.sda.auction.dto.UserDto;
import com.sda.auction.model.User;

public class UserMapper {

    public User convert(UserDto userDto){
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        return  user;
    }

    public UserDto convert (User user){
        return null;
    }
}
