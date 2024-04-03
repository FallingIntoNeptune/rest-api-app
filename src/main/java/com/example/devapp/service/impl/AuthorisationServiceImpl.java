package com.example.devapp.service.impl;

import com.example.devapp.advice.InvalidCredentials;
import com.example.devapp.advice.UnauthorizedUser;
import com.example.devapp.enums.Authorities;
import com.example.devapp.repository.UserRepository;
import com.example.devapp.service.AuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Component
public class AuthorisationServiceImpl implements AuthorizationService {
    private final UserRepository userRepository;
    @Override
    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new UnauthorizedUser("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new InvalidCredentials("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
