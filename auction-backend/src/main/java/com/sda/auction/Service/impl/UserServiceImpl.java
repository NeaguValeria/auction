package com.sda.auction.Service.impl;

import com.sda.auction.Service.UserService;
import com.sda.auction.dto.UserDto;
import com.sda.auction.mapper.UserMapper;
import com.sda.auction.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;


    @Override
    public UserDto addUser(UserDto userDto) {
        //conert Dto in entitiy
        User user = userMapper.convert(userDto);
        return null;
    }
}
