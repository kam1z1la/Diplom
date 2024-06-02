package com.courses.diplom.db.account.user;

import com.courses.diplom.auth.AuthenticationSService;
import com.courses.diplom.db.account.user.dto.SignIn;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final AuthenticationSService authenticationService;

    @GetMapping("/auth/login")
    public String loginPage(Model model) {
        model.addAttribute("signIn", new SignIn());
        return "login-sign_up-page";
    }

//    @PostMapping("/auth/login")
//    public String loginPage(@Valid @ModelAttribute("signIn") SignIn signUp,
//                            BindingResult bindingResult, Model model) {
//        authenticationService.signin(signUp);
//        return "footer";
//    }

    @GetMapping("/registration")
    public String registrationPage() {
        return "footer";
    }

//    @PostMapping("/login")
//    public String login(@RequestParam String mail, @RequestParam String password, Model model) {
//        try {
//            UserDetails userDetails = userService.loadUserByUsername(mail);
//            // Валидируем пароль
//            if (passwordEncoder().matches(password, userDetails.getPassword())) {
//                return "redirect:/success";
//            } else {
//                model.addAttribute("error", true);
//                return "login";
//            }
//        } catch (UsernameNotFoundException e) {
//            model.addAttribute("error", true);
//            return "login";
//        }
//    }

}
