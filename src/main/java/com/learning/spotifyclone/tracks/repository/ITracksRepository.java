package com.learning.spotifyclone.tracks.repository;

import com.learning.spotifyclone.tracks.model.Tracks;
import io.micrometer.observation.annotation.Observed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Observed
public interface ITracksRepository extends JpaRepository<Tracks, String> {
}
