package com.matovic.rest.webservices.restfulwebservices.user;

import com.matovic.rest.webservices.restfulwebservices.jpa.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jpa/users")
@AllArgsConstructor
public class UserJPAController {

    private final UserRepository userRepository;
    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty())
            throw new UserNotFoundException("User with id: " + id + " not found!");

        return user.get();
    }

    @PostMapping
    public User saveUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Integer id) {
        userRepository.deleteById(id);
    }
}
