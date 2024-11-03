package com.learning.spotifyclone.albums.controller;


import com.learning.spotifyclone.albums.dto.CreateAlbumDto;
import com.learning.spotifyclone.albums.dto.UpdateAlbumDto;
import com.learning.spotifyclone.albums.model.Albums;
import com.learning.spotifyclone.albums.service.IAlbumService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@Tag(name = "Albums", description = "The Album API")
@RequestMapping("/api/v1/albums")
@RequiredArgsConstructor
public class AlbumController {
    private final IAlbumService albumService;

    @PostMapping
    public void createAlbum(@RequestBody CreateAlbumDto album) {
        albumService.createAlbum(album);
    }

    @GetMapping
    public ResponseEntity<Page<Albums>> getAllAlbums(Pageable pageable) {
        Page<Albums> albums = albumService.getAllAlbums(pageable);
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Albums> getAlbumById(@PathVariable String id) {
        Albums album = albumService.getAlbumById(id);
        return new ResponseEntity<>(album, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Albums> updateAlbum(@PathVariable String id,@RequestBody UpdateAlbumDto album) {
        return new ResponseEntity<>(albumService.updateAlbum(id, album), HttpStatus.OK);
    }
}
