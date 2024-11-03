package com.learning.spotifyclone.albums.model;

import com.learning.spotifyclone.tracks.model.Tracks;
import com.learning.spotifyclone.users.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "albums")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Albums {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    String id;

    String name;

    String thumbnail;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    User owner;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    List<Tracks> tracks;
}
