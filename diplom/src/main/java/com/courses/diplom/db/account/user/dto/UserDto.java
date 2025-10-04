package com.courses.diplom.db.account.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @JsonProperty("_firstName")
    private String firstName;

    @JsonProperty("_lastName")
    private String lastName;

    @JsonProperty("_mail")
    private String mail;

    @JsonProperty("_phoneNumber")
    private String phoneNumber;

    @JsonProperty("_id")
    private Long id;

}
