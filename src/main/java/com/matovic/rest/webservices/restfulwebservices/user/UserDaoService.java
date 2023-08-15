package com.matovic.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int counter = 0;

    static {
        users.add(User.builder()
                        .id(counter++)
                        .name("Petar Petrovic")
                        .birthDate(LocalDate.now().minusYears(30))
                        .build());
        users.add(User.builder()
                        .id(counter++)
                        .name("Nikola Nikolic")
                        .birthDate(LocalDate.now().minusYears(22))
                        .build());
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        user.setId(counter++);
        users.add(user);
        return user;
    }

    public User findUser(Integer id) {
        Predicate<User> userPredicate = u -> u.getId().equals(id);
        return users.stream().filter(userPredicate).findFirst().orElse(null);
    }

    public void deleteById(Integer id) {
        users.removeIf(p -> p.getId() == id);
    }
}
