package com.courses.diplom.auth;

import com.courses.diplom.db.account.token.TokenService;
import com.courses.diplom.db.account.user.DetailsService;
import com.courses.diplom.db.account.user.UserService;
import com.courses.diplom.db.account.user.dto.SignIn;
import com.courses.diplom.db.account.user.dto.SignUp;
import com.courses.diplom.exiption.UserExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationSService implements AuthenticationS {
    private final UserService userService;
    private final DetailsService detailsService;
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponse signup(SignUp request) throws UserExistException {
        var user = userService.signUpToEntity(request);
        if (userService.isUserExist(user.getMail())) {
            throw new UserExistException("User exist");
        }
        userService.saveUser(user);

        String token = tokenService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(token).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SignIn request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()));

        var user = detailsService.userDetailsService().loadUserByUsername(request.getEmail());
        String token = tokenService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(token).build();
    }
}
