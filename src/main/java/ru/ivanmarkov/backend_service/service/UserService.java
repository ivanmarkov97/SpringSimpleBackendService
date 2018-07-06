package ru.ivanmarkov.backend_service.service;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ivanmarkov.backend_service.entity.Role;
import ru.ivanmarkov.backend_service.entity.User;
import ru.ivanmarkov.backend_service.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.Collection;

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
        } else {
            System.out.println("Username " + user.getName());
            System.out.println("Username " + user.getPassword());
        }
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return ImmutableList.of(Role.USER);
            }

            @Override
            public String getPassword() {
                return user.getPassword();
            }

            @Override
            public String getUsername() {
                return user.getName();
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
        };
    }
}
