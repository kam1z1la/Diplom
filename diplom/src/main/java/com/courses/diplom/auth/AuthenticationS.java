package com.courses.diplom.auth;


import com.courses.diplom.db.account.user.dto.SignIn;
import com.courses.diplom.db.account.user.dto.SignUp;

public interface AuthenticationS {
    JwtAuthenticationResponse signup(SignUp request);

    JwtAuthenticationResponse signin(SignIn request);
}
