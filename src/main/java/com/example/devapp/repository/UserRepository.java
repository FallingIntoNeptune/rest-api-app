package com.example.devapp.repository;

import com.example.devapp.entity.User;
import com.example.devapp.enums.Authorities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class UserRepository {

    /**
     * В качетсве временного хранилища пользователей выступает Map
     */
    private Map<User, List<Authorities>> usersAndAuthorities = new HashMap<>(
            Map.of(
                    new User("victor", "123"),
                    List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE),
                    new User("helen", "456"),
                    List.of(Authorities.READ, Authorities.WRITE)
            )
    );
    public List<Authorities> getUserAuthorities(String user, String password) {
        final var tempUser = new User(user, password);

        if (!usersAndAuthorities.containsKey(tempUser)) {
            log.info("Не найден пользователь " + tempUser.getLogin());
            return new ArrayList<>();
        }
        log.info("Разрешения получены для пользователя " + tempUser.getLogin());
        return usersAndAuthorities.get(tempUser);
    }
}
