package ru.AndMosc.springSecurity.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "authorities")
public class Authorities implements GrantedAuthority {
    @Id
    private String username;
    private String authority;
    @Transient
    @ManyToOne(cascade = CascadeType.REMOVE)
    private User user;

    public Authorities(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return getUsername();
    }
}
