package com.courses.diplom.db.account.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @NotBlank(message = "Ел.адреса обов'язкова для заповнення")
    @Email(message = "Ел.адреса має бути дійсною")
    private String mail;

    @NotBlank(message = "Пароль обов'язковий для заповнення")
    @Size(min = 5, max = 20, message = "Пароль має бути більше ніж 5 символів і не має перевищувати більше 20 символів")
    private String password;
}
