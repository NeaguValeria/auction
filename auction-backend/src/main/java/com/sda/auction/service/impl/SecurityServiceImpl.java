package com.sda.auction.service.impl;

import com.sda.auction.dto.HeaderDto;
import com.sda.auction.dto.LoginDto;
import com.sda.auction.jwt.TokenProvider;
import com.sda.auction.model.User;
import com.sda.auction.service.SecurityService;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SecurityServiceImpl implements SecurityService {

    public static final String AUTHORIZATION_HEADER = "Authorization";

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private TokenProvider tokenProvider;

    @Value("${jwt.role.public}")
    private String publicPaths;

    @Override
    public boolean passwordMatch(LoginDto userDto, User user) {
        String plaintextPassword = userDto.getPassword();
        String hashedPassword = user.getPassword();

        return passwordEncoder.matches(plaintextPassword, hashedPassword);
    }

    @Override
    public LoginDto createDtoWithJwt(User user) {

        LoginDto result = new LoginDto();
        result.setEmail(user.getEmail());
        result.setPassword(user.getPassword());

        String jwt = tokenProvider.createJwt(user);
        result.setJwt(jwt);

        return result;
    }

    @Override
    public boolean isValid(ServletRequest servletRequest) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String requestURL = httpServletRequest.getRequestURI();
        if (isPublicPath(requestURL)) {
            return true;
        }
        String jwt = resolveToken(httpServletRequest);
        return tokenProvider.validate(jwt, requestURL);
    }


    private boolean isPublicPath(String requestURL) {
        String[] publicPathsArray = publicPaths.split(",");
        for (String path : publicPathsArray) {
            if (requestURL.compareTo(path) == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void setEmailOn(ServletRequest servletRequest) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String jwt = resolveToken(httpServletRequest);

        String userEmail = tokenProvider.getEmailFrom(jwt);
        httpServletRequest.setAttribute("userEmail", userEmail);
    }

    @Override
    public HeaderDto getHeaderDtoFrom(HttpServletRequest request) {
        String jwt = resolveToken(request);
        return tokenProvider.getHeaderDtoFrom(jwt);
    }

    //	"Bearer adsadsafisafsakjskjdsa.sadjsaksaksajk.sakjddsakdsakdsa"
    private String resolveToken(HttpServletRequest httpServletRequest) {
        String bearerToken = httpServletRequest.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;

    }
}
