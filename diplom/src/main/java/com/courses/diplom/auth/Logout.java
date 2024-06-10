package com.courses.diplom.auth;

import com.courses.diplom.db.account.token.TokenService;
import com.courses.diplom.db.account.user.DetailsService;
import com.courses.diplom.db.account.user.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class Logout implements LogoutSuccessHandler {
    private final TokenService tokenService;
    private final DetailsService detailsService;

    @Override
    public void onLogoutSuccess(HttpServletRequest request,
                                HttpServletResponse response,
                                Authentication authentication
    ) throws IOException {
        final String authHeader = request.getHeader("Authorization");
        final String jwt = authHeader.substring(7);
        final String userEmail = tokenService.extractUserName(jwt);
        var user = (User) detailsService.userDetailsService().loadUserByUsername(userEmail);
        var token = user.getToken();

        if (Objects.nonNull(token)) {
            tokenService.deleteToken(token);
        }
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().flush();
    }
}

