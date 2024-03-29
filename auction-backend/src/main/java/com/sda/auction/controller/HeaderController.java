package com.sda.auction.controller;

import com.sda.auction.dto.HeaderDto;
import com.sda.auction.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/authenticated/details")
public class HeaderController {

    @Autowired
    private SecurityService securityService;


    @GetMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<HeaderDto> get(HttpServletRequest request) {

        HeaderDto headerDto = securityService.getHeaderDtoFrom(request);

        return new ResponseEntity<>(headerDto, HttpStatus.OK);
    }


}