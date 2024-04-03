package com.example.devapp.controller;

import com.example.devapp.advice.InvalidCredentials;
import com.example.devapp.advice.UnauthorizedUser;
import com.example.devapp.enums.Authorities;
import com.example.devapp.service.AuthorizationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/authorize")
public class AuthorizationController {
    private final AuthorizationService service;

    @GetMapping
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @GetMapping("/error/uno")
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invalidCredentialsHandler(final InvalidCredentials e) {
        return new ResponseEntity<>("InvalidCredential exception: " + e, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/error/due")
    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedUserException(final UnauthorizedUser e) {
        //Логирование
        log.info("UnauthorizedUser exception:" + e);
        return new ResponseEntity<>("UnauthorizedUser exception: " + e, HttpStatus.BAD_REQUEST);
    }
}
