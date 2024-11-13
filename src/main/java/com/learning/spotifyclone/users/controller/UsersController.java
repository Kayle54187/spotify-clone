package com.learning.spotifyclone.users.controller;

import com.learning.spotifyclone.users.dto.CreateUserDto;
import com.learning.spotifyclone.users.dto.UpdateUserDto;
import com.learning.spotifyclone.users.model.User;
import com.learning.spotifyclone.users.service.IUserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "Users", description = "Users API")
@RequiredArgsConstructor
public class UsersController {

    private final IUserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(Pageable pageable) {
        List<User> users = userService.getAllUsers(pageable);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@RequestParam String id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestParam String id, @RequestBody UpdateUserDto user) {
        User updatedUser = userService.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody CreateUserDto user) {
        userService.createUser(user);
        return ResponseEntity.ok().build();
    }
}
