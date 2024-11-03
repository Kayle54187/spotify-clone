package com.learning.spotifyclone.albums.repository;

import com.learning.spotifyclone.albums.model.Albums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlbumRepository extends JpaRepository<Albums, String> {
}
