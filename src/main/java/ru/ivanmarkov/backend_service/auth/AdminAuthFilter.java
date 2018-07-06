package ru.ivanmarkov.backend_service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import ru.ivanmarkov.backend_service.entity.User;
import ru.ivanmarkov.backend_service.service.UserService;

import javax.annotation.PostConstruct;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Component
public class AdminAuthFilter extends GenericFilterBean {

    @Autowired
    private UserService userService;

    private User admin;

    @PostConstruct
    void init(){
        admin = (User) userService.loadUserByUsername("admin");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(new UserAuthentication(admin));
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
