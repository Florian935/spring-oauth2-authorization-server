package com.florian935.oauth2server.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class AuthenticatedUser implements UserDetails {

    User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> grantedAuthorities =new ArrayList<>();

        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+this.user.getRole().getRoleName().toUpperCase()));
        this.user
                .getRole()
                .getPermissions()
                .forEach(permission ->
                        grantedAuthorities.add(new SimpleGrantedAuthority(permission.getPermissionName().toUpperCase())));

        return grantedAuthorities;
    }

    @Override
    public String getPassword() {

        return this.user.getPassword();
    }

    @Override
    public String getUsername() {

        return this.user.getUserName();
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

    public User getUserDetails() {
        return user;
    }
}
