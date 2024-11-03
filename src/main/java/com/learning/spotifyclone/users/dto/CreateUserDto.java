package com.learning.spotifyclone.users.dto;


import com.learning.spotifyclone.users.model.enums.Gender;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateUserDto {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private Gender gender;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
}
