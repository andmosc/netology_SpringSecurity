package ru.AndMosc.springSecurity.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(schema = "spring_security", name = "users")
public class User implements UserDetails {
    @Id
    private String username;
    private String password;
    private short enabled;
    @Transient
    private String confirmPassword;
    @OneToMany(targetEntity = Authorities.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username")

    private Set<Authorities> authority;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getAuthority();
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
