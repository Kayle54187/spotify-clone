package com.learning.spotifyclone.users.service.impl;

import com.learning.spotifyclone.exceptions.ResourceNotFound;
import com.learning.spotifyclone.users.dto.CreateUserDto;
import com.learning.spotifyclone.users.dto.UpdateUserDto;
import com.learning.spotifyclone.users.model.User;
import com.learning.spotifyclone.users.repository.IUserRepository;
import com.learning.spotifyclone.users.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    public void createUser(CreateUserDto userDto) {
        try {
            User user = new User();
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setEmail(userDto.getEmail());
            user.setGender(userDto.getGender());
            user.setPassword(userDto.getPassword());
            userRepository.save(user);
        }catch (Exception e){
            throw new DuplicateKeyException("User already exists");
        }
    }

    public User getUserById(String id) {
        User user = userRepository.findByIdWithTracksAndAlbums(id).orElseThrow(() -> new ResourceNotFound("User not found"));
        return user;
    }

    public User updateUser(String id, UpdateUserDto user) {
        User userToUpdate = userRepository.findById(id).orElseThrow(() -> new ResourceNotFound("User not found"));
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        return userRepository.save(userToUpdate);
    }

    public List<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll();
    }
}
