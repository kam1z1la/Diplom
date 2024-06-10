package com.courses.diplom.db.account.user;

import com.courses.diplom.db.DetailsServiceConfig;
import com.courses.diplom.db.account.token.TokenService;
import com.courses.diplom.db.account.user.dto.SignIn;
import com.courses.diplom.db.account.user.dto.SignUp;
import com.courses.diplom.db.account.user.dto.TemporaryUser;
import com.courses.diplom.db.account.user.dto.UserDto;
import com.courses.diplom.db.course.Course;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final DetailsService detailsService;
    private final TokenService tokenService;

    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }

    public boolean isUserExist(String email) {
        return userRepository.existsByEmail(email);
    }

    public void changePassword(TemporaryUser temporaryUser) {
        User user = getUserByMail(temporaryUser.getEmail());
        String newPassword = temporaryUser.getPassword();

        userRepository.updatePassword(newPassword, user.getId());
    }

    public User getUserByRequest(HttpServletRequest request) {
        String email = tokenService.getMailFromHttpRequest(request);
        return getUserByMail(email);
    }

    public User getUserByMail(String mail) {
        return (User) detailsService.userDetailsService().loadUserByUsername(mail);
    }

    public User signUpToEntity(SignUp request) {
        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .mail(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
//                .password(passwordEncoder.encode(request.getPassword()))
                .password(request.getPassword())
                .build();
    }

    public User signInToEntity(SignIn request) {
        return User.builder()
                .mail(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
    }

    public void updateUser(UserDto dto) {
        User user = findUserById(dto.getId());
        userRepository.updateUser(user);
    }

    private User findUserById(Long id) {
       return userRepository.findById(id)
               .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}
