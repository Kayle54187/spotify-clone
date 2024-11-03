package com.learning.spotifyclone.tracks.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateTrackDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String thumbnail;
    @NotEmpty
    private String trackUrl;
    @NotEmpty
    private List<String> albumIds;
    @NotEmpty
    private String ownerId;
}
