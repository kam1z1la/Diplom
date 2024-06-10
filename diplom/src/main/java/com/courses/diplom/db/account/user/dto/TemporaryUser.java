package com.courses.diplom.db.account.user.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TemporaryUser {
    private String email;
    private String password;
}
