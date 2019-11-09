package com.sda.auction.controller;

import com.sda.auction.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/register")
public class Registration {

    @GetMapping
    public ResponseEntity<String> get(){
        return new ResponseEntity<>("ceva", HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> post(@Valid @RequestBody UserDto userDto){
        System.out.println("am primit" + userDto);

        return new ResponseEntity<>("post triggered", HttpStatus.OK);
    }
}

