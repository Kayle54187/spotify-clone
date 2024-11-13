package com.learning.spotifyclone.users.repository;

import com.learning.spotifyclone.users.model.User;
import io.micrometer.observation.annotation.Observed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Observed
public interface IUserRepository extends JpaRepository<User, String> {
    @Query("SELECT u FROM User u " +
            "LEFT JOIN FETCH u.tracks " +
            "LEFT JOIN FETCH u.albums " +
            "WHERE u.id = :userId")
    Optional<User> findByIdWithTracksAndAlbums(String userId);
}
