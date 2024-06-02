package com.courses.diplom.db.account.user.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUp {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}