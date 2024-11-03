package com.learning.spotifyclone.albums.service;

import com.learning.spotifyclone.albums.dto.CreateAlbumDto;
import com.learning.spotifyclone.albums.dto.UpdateAlbumDto;
import com.learning.spotifyclone.albums.model.Albums;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAlbumService {
    Page<Albums> getAllAlbums(Pageable pageable);
    Albums getAlbumById(String id);
    Albums updateAlbum(String id, UpdateAlbumDto album);
    void createAlbum(CreateAlbumDto album);
    void deleteAlbum(String id);
}
