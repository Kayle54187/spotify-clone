package com.learning.spotifyclone.tracks.model;


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
    String id;

    String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    User owner;

    String thumbnail;
    String trackUrl;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    List<Albums> albums;
}
