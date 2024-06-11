package com.project.games_app.dto.playerDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class PlayerRequestDTO {

    private UUID id;
    private String email;
    private String nickname;
    private String password;
    private Integer points;
    private LocalDateTime lastOnline;
}
