package com.learning.spotifyclone.tracks.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.spotifyclone.albums.model.Albums;
import com.learning.spotifyclone.users.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tracks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tracks {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String trackUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore  // Prevents loading user details in circular references
    private User owner;

    @ManyToMany(mappedBy = "tracks")
    @JsonIgnore  // Prevents loading all albums associated with the track when not needed
    private List<Albums> albums;
}
