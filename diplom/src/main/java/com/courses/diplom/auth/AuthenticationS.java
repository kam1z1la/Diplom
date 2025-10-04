package com.courses.diplom.auth;


import com.courses.diplom.db.account.user.dto.SignIn;
import com.courses.diplom.db.account.user.dto.SignUp;
import com.courses.diplom.exiption.UserExistException;

public interface AuthenticationS {
    JwtAuthenticationResponse signup(SignUp request) throws UserExistException;

    JwtAuthenticationResponse signin(SignIn request) throws UserExistException;
}
