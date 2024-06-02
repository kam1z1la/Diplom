package com.courses.diplom.db.account.token;

import org.springframework.security.core.userdetails.UserDetails;

public interface Jwt {
    String extractUserName(String token);

    String generateToken(UserDetails userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);
}
