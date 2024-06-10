package com.courses.diplom.db.account.user;

import com.courses.diplom.db.course.Course;
import com.courses.diplom.db.course.Expert;
import com.courses.diplom.db.account.Role;
import com.courses.diplom.db.account.token.Token;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"user\"")
@NamedEntityGraph(
        name = "user-entity-graph",
        attributeNodes = {
                @NamedAttributeNode("roles"),
                @NamedAttributeNode("experts"),
                @NamedAttributeNode("token")
        }
)
@Builder
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;

    @Column(unique = true, length = 100)
    private String mail;

    @Column(name = "phone_number", unique = true, length = 30)
    private String phoneNumber;

    @Column(nullable = false, unique = true, length = 300)
    private String password;

    @Column(name = "refresh_token", length = 500)
    private String refreshToken;

    @Column(unique = true, length = 500)
    private String photo;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "token_id", referencedColumnName = "id")
    private Token token;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "user_course",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private List<Expert> experts = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return mail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
