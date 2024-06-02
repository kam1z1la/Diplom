package com.courses.diplom.db.account.token;

import com.courses.diplom.db.account.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "token")
@Builder
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "access_token", nullable = false, length = 300)
    private String accessToken;

    @Column(name = "data_access_expires_at")
    private LocalDateTime accessExpiresAt;

    @Column(name = "issued_at")
    private LocalDateTime issuedAt;

    @OneToOne(mappedBy = "token")
    private User user;
}
