package com.courses.diplom.db.account.user;

import com.courses.diplom.auth.AuthenticationSService;
import com.courses.diplom.auth.JwtAuthenticationResponse;
import com.courses.diplom.db.account.user.dto.SignIn;
import com.courses.diplom.db.account.user.dto.SignUp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationSService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUp request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/api/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignIn request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}