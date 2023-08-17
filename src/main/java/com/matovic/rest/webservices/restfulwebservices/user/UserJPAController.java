package com.matovic.rest.webservices.restfulwebservices.user;

import com.matovic.rest.webservices.restfulwebservices.jpa.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jpa/users")
@AllArgsConstructor
public class UserJPAController {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

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

    @GetMapping("/{user_id}/posts")
    public List<Post> getPostsForUser(@PathVariable("user_id") Integer user_id) {
        Optional<User> user = userRepository.findById(user_id);

        if (user.isEmpty())
            throw new UserNotFoundException("User with id: " + user_id + " not found!");

        return user.get().getPosts();
    }

    @PostMapping("/{user_id}/posts")
    public ResponseEntity<Post> savePostForUser(@PathVariable("user_id") Integer user_id, @Valid @RequestBody Post post) {

        Optional<User> user = userRepository.findById(user_id);

        if (user.isEmpty()) {
            throw new UserNotFoundException("User with id: " + user_id + " not found!");
        }

        post.setUser(user.get());
        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
