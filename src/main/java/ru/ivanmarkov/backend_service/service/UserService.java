package ru.ivanmarkov.backend_service.service;

import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ivanmarkov.backend_service.entity.Role;
import ru.ivanmarkov.backend_service.entity.User;
import ru.ivanmarkov.backend_service.repository.UserRepository;

import java.util.Date;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /*
    @PostConstruct
    public void init() {

        User user = userRepository.findByName("Ivan");
        if (user != null){
            System.out.println(user.toString());
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            System.out.println(user.toString());
        } else {
            System.out.println("User ivan doesn't exist");
        }
    }*/


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByName(s);
        if (user == null) {
            System.out.println("no such user");
            user = new User(
                    "admin",
                    "password",
                    "thiendio@yandeex.ru",
                    new Date()
            );
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            user.setAuthorities(ImmutableList.of(Role.ADMIN));
            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setCredentialNonExpired(true);
            user.setEnabled(true);
            userRepository.save(user);
            System.out.println(user.toString());
            return user;
        } else {
            System.out.println(user.toString());
            return user;
        }
    }
}
