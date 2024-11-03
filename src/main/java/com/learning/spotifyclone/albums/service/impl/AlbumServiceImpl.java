package com.learning.spotifyclone.albums.service.impl;

import com.learning.spotifyclone.albums.dto.CreateAlbumDto;
import com.learning.spotifyclone.albums.dto.UpdateAlbumDto;
import com.learning.spotifyclone.albums.model.Albums;
import com.learning.spotifyclone.albums.repository.IAlbumRepository;
import com.learning.spotifyclone.albums.service.IAlbumService;
import com.learning.spotifyclone.exceptions.ResourceNotFound;
import com.learning.spotifyclone.tracks.model.Tracks;
import com.learning.spotifyclone.tracks.repository.ITracksRepository;
import com.learning.spotifyclone.users.model.User;
import com.learning.spotifyclone.users.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements IAlbumService {

    private final IAlbumRepository albumRepository;
    private final IUserRepository userRepository;
    private final ITracksRepository tracksRepository;

    public void createAlbum(CreateAlbumDto albumDto) {
        Albums album = new Albums();
        User user = userRepository.findById(albumDto.getOwnerId()).orElseThrow(() -> new ResourceNotFound("User not found"));
        if(albumDto.getTrackIds() != null && albumDto.getTrackIds().length > 0){
            List<Tracks> tracks = tracksRepository.findAllById(Arrays.stream(albumDto.getTrackIds()).collect(Collectors.toList()));
            album.setTracks(tracks);
        }
        album.setName(albumDto.getName());
        album.setOwner(user);
        album.setThumbnail(albumDto.getThumbnail());
        albumRepository.save(album);
    }

    public void deleteAlbum(String id) {
        albumRepository.deleteById(id);
    }

    public Page<Albums> getAllAlbums(Pageable pageable) {
        return albumRepository.findAll(pageable);
    }

    public Albums getAlbumById(String id) {
        return albumRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Album not found"));
    }

    public Albums updateAlbum(String id, UpdateAlbumDto album) {
        Albums albumToUpdate = albumRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Album not found"));
        User user = userRepository.findById(album.getOwnerId()).orElseThrow(() -> new ResourceNotFound("User not found"));
        if(album.getTrackIds() != null && album.getTrackIds().length > 0){
            List<Tracks> tracks = tracksRepository.findAllById(Arrays.stream(album.getTrackIds()).collect(Collectors.toList()));
            albumToUpdate.setTracks(tracks);
        }
        albumToUpdate.setName(album.getName());
        albumToUpdate.setOwner(user);
        albumToUpdate.setThumbnail(album.getThumbnail());
        return albumRepository.save(albumToUpdate);
    }

}
