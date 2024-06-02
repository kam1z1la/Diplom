package com.courses.diplom.db.account.user;

import com.courses.diplom.db.DetailsServiceConfig;
import com.courses.diplom.db.account.user.dto.SignIn;
import com.courses.diplom.db.account.user.dto.SignUp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
//    private final DetailsServiceConfig detailsServiceConfig;
//
//    public UserDetails loadUserByUsername(String email)  {
//        return detailsServiceConfig.userDetailsService().loadUserByUsername(email);
//    }

    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User signUpToEntity(SignUp request) {
        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .mail(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
    }

    public User signInToEntity(SignIn request) {
        return User.builder()
                .mail(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
    }
}
