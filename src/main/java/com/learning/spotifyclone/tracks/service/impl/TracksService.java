package com.learning.spotifyclone.tracks.service.impl;

import com.learning.spotifyclone.albums.model.Albums;
import com.learning.spotifyclone.albums.repository.IAlbumRepository;
import com.learning.spotifyclone.exceptions.ResourceNotFound;
import com.learning.spotifyclone.tracks.dto.CreateTrackDto;
import com.learning.spotifyclone.tracks.dto.UpdateTrackDto;
import com.learning.spotifyclone.tracks.model.Tracks;
import com.learning.spotifyclone.tracks.repository.ITracksRepository;
import com.learning.spotifyclone.tracks.service.ITracksService;
import com.learning.spotifyclone.users.model.User;
import com.learning.spotifyclone.users.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TracksService implements ITracksService {

    private final ITracksRepository tracksRepository;
    private final IUserRepository userRepository;
    private final IAlbumRepository albumRepository;

    public void createTrack(CreateTrackDto trackDto) {
        Tracks track = new Tracks();
        User user = userRepository.findById(trackDto.getOwnerId()).orElseThrow(() -> new ResourceNotFound("User not found"));
        List<Albums> albums = albumRepository.findAllById(trackDto.getAlbumIds());
        track.setName(trackDto.getName());
        track.setTrackUrl(trackDto.getTrackUrl());
        track.setOwner(user);
        track.setAlbums(albums);
        tracksRepository.save(track);
    }

    public Tracks getTrackById(String id) {
        return tracksRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Track not found"));
    }

    public Page<Tracks> getAllTracks(Pageable pageable) {
        return tracksRepository.findAll(pageable);
    }

    public Tracks updateTrack(String id, UpdateTrackDto track) {
        Tracks trackToUpdate = tracksRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Track not found"));
        List<Albums> albums = albumRepository.findAllById(track.getAlbumIds());
        trackToUpdate.setName(track.getName());
        trackToUpdate.setTrackUrl(track.getTrackUrl());
        trackToUpdate.setAlbums(albums);
        return tracksRepository.save(trackToUpdate);
    }
}
