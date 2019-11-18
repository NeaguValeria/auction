package com.sda.auction.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sda.auction.dto.ErrorResponseDto;
import java.io.IOException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component
public class AccessDeniedHandler {

    public void reply(ServletResponse servletResponse) throws IOException {
        ErrorResponseDto responseDto = new ErrorResponseDto(401, "Unauthorized access");
        byte[] response = responseDto.getBytes();
        servletResponse.getOutputStream().write(response);

        ((HttpServletResponse) servletResponse).setHeader("Content-Type", "application/json");
        ((HttpServletResponse) servletResponse).setStatus(401);
    }
}
