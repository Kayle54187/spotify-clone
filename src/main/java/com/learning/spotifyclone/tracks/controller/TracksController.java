package com.learning.spotifyclone.tracks.controller;


import com.learning.spotifyclone.tracks.dto.CreateTrackDto;
import com.learning.spotifyclone.tracks.dto.UpdateTrackDto;
import com.learning.spotifyclone.tracks.model.Tracks;
import com.learning.spotifyclone.tracks.service.ITracksService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tracks")
@Tag(name = "Tracks", description = "Tracks API")
@RequiredArgsConstructor
public class TracksController {
    private final ITracksService tracksService;

    @GetMapping
    public ResponseEntity<Page<Tracks>> getAllTracks(Pageable pageable) {
        return ResponseEntity.ok(tracksService.getAllTracks(pageable));
    }

    @PostMapping
    public ResponseEntity createTrack(@RequestBody CreateTrackDto track) {
        tracksService.createTrack(track);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tracks> getTrackById(@PathVariable String id) {
        return ResponseEntity.ok(tracksService.getTrackById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tracks> updateTrack(@PathVariable String id, @RequestBody UpdateTrackDto track) {
        return ResponseEntity.ok(tracksService.updateTrack(id, track));
    }
}
