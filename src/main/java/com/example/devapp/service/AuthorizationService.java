package com.example.devapp.service;

import com.example.devapp.enums.Authorities;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис авторизации
 *
 */
public interface AuthorizationService {
    List<Authorities> getAuthorities(String user, String password);

}
