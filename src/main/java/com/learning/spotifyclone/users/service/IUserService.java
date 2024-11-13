package com.learning.spotifyclone.users.service;

import com.learning.spotifyclone.users.dto.CreateUserDto;
import com.learning.spotifyclone.users.dto.UpdateUserDto;
import com.learning.spotifyclone.users.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    void createUser(CreateUserDto user);
    List<User> getAllUsers(Pageable pageable);
    User getUserById(String id);
    User updateUser(String id, UpdateUserDto user);
}
