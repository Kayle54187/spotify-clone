package com.learning.spotifyclone.users.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.learning.spotifyclone.tracks.model.Tracks;
import com.learning.spotifyclone.users.model.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    String id;

    String firstName;

    String lastName;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(unique = true)
    String email;

    String password;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Tracks> tracks;
}
