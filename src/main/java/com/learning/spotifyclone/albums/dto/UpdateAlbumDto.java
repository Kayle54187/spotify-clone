package com.learning.spotifyclone.albums.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateAlbumDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String thumbnail;
    @NotEmpty
    private String ownerId;
    private String[] trackIds;
}
