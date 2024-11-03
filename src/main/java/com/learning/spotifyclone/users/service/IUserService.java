package com.learning.spotifyclone.users.service;

import com.learning.spotifyclone.users.dto.CreateUserDto;
import com.learning.spotifyclone.users.dto.UpdateUserDto;
import com.learning.spotifyclone.users.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    void createUser(CreateUserDto user);
    Page<User> getAllUsers(Pageable pageable);
    User getUserById(String id);
    User updateUser(String id, UpdateUserDto user);
}
