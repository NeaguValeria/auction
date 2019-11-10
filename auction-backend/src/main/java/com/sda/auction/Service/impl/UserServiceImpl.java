package com.sda.auction.Service.impl;

import com.sda.auction.Service.UserService;
import com.sda.auction.dto.UserDto;
import com.sda.auction.mapper.UserMapper;
import com.sda.auction.model.User;
import com.sda.auction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncorder;


    @Autowired
    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository, BCryptPasswordEncoder passwordEncorder) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.passwordEncorder = passwordEncorder;
    }


    @Override
    public UserDto addUser(UserDto userDto) {
        //conert Dto in entitiy
        User user = userMapper.convert(userDto);

        encodePassword(user);

        //persisitam in BD
        User savedUser = userRepository.save(user);
        //convertim entitiatea persistata inapoi in DTO p/u a o intoarce catre requester
        return  userMapper.convert(savedUser);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    private void encodePassword(User user) {
        //encode user's password and put it in passwordEncoded varaibale
        String passwordEncoded = passwordEncorder.encode(user.getPassword());//o punem pe etitate
        //set encoreded passsword to user entity
        user.setPassword(passwordEncoded);
    }
}
