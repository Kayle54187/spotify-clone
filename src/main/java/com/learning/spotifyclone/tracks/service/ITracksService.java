package com.learning.spotifyclone.tracks.service;

import com.learning.spotifyclone.tracks.dto.CreateTrackDto;
import com.learning.spotifyclone.tracks.dto.UpdateTrackDto;
import com.learning.spotifyclone.tracks.model.Tracks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITracksService {
    Page<Tracks> getAllTracks(Pageable pageable);
    Tracks getTrackById(String id);
    Tracks updateTrack(String id, UpdateTrackDto track);
    void createTrack(CreateTrackDto track);
}
