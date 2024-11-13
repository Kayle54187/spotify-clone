package com.learning.spotifyclone.albums.repository;

import com.learning.spotifyclone.albums.model.Albums;
import io.micrometer.observation.annotation.Observed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Observed
public interface IAlbumRepository extends JpaRepository<Albums, String> {
}
