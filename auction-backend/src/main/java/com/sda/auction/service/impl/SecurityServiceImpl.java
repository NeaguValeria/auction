package com.sda.auction.service.impl;
import com.sda.auction.dto.LoginDto;
import com.sda.auction.jwt.TokenProvider;
import com.sda.auction.model.User;
import com.sda.auction.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

@Service
public class SecurityServiceImpl implements SecurityService {

    public static final String AUTHORIZATION_HEADER = "Authorization";

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private TokenProvider tokenProvider;

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
        // ne interesaza aici jwt si npointu unde vrea s mearga

        String requestURL = httpServletRequest.getRequestURI();
        //ia tokenu depe request (jwt), extrag de pe request
        String jwt = resolveToken(httpServletRequest);
        //ii dau jwt si adresa unde vrea s mearga request url

        boolean result = tokenProvider.validate(jwt, requestURL);
        if (jwt != null && result) {
            String ownerEmail = tokenProvider.getEmailFrom(jwt);
            httpServletRequest.setAttribute("ownerEmail", ownerEmail);
        }
        return result;
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
