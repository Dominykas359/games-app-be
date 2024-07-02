package com.project.games_app.dto.authenticationDTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {

    private UUID id;
    private String email;
    private String nickname;
    private Integer points;
    private LocalDateTime lastOnline;
    private String profilePictureUrl;
    private String token;
}
