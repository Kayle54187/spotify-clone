package com.learning.spotifyclone.tracks.repository;

import com.learning.spotifyclone.tracks.model.Tracks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITracksRepository extends JpaRepository<Tracks, String> {
}
