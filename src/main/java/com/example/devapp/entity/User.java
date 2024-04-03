package com.example.devapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Реализация сущности пользователя
 */
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public final class User {
    /**
     * Логин пользователя
     */
    private String login;
    /**
     * Пароль пользователя
     */
    private String password;
}
