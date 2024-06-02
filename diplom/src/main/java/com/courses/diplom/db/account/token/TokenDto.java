package com.courses.diplom.db.account.token;

import com.courses.diplom.db.MapperToEntity;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenDto implements MapperToEntity<Token> {
    private String accessToken;
    private LocalDateTime accessExpiresAt;
    private LocalDateTime issuedAt;

    @Override
    public Token toEntity() {
        return Token.builder()
                .accessToken(this.accessToken)
                .accessExpiresAt(this.accessExpiresAt)
                .issuedAt(this.issuedAt)
                .build();
    }
}
