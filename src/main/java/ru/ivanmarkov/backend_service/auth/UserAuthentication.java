package ru.ivanmarkov.backend_service.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import ru.ivanmarkov.backend_service.entity.User;

import java.util.Collection;

public class UserAuthentication implements Authentication {
    private User user;
    private boolean authenticated = true;


    public UserAuthentication(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities();
    }

    @Override
    public Object getCredentials() {
        return user;
    }

    @Override
    public Object getDetails() {
        return user;
    }

    @Override
    public Object getPrincipal() {
        return user;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        authenticated = b;
    }

    @Override
    public String getName() {
        return user.getName();
    }
}
