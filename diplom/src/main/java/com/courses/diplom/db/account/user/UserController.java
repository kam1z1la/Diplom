package com.courses.diplom.db.account.user;

import com.courses.diplom.db.account.token.TokenService;
import com.courses.diplom.db.account.user.dto.TemporaryUser;
import com.courses.diplom.db.account.user.dto.UserDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final TokenService tokenService;

    @GetMapping("/user")
    public ResponseEntity<User> getUser(HttpServletRequest request) {
        String mail = tokenService.getMailFromHttpRequest(request);
        return ResponseEntity.ok(userService.getUserByMail(mail));
    }

    @PostMapping("/check-email")
    public ResponseEntity<Boolean> checkUserByEmail(@RequestBody String email) {
        return ResponseEntity.ok(userService.isUserExist(email));
    }

    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody TemporaryUser user) {
        userService.changePassword(user);
        return ResponseEntity.ok("Success update");
    }

    @PatchMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody UserDto dto) {
        userService.updateUser(dto);
        return ResponseEntity.ok("Success update user data");
    }
}
