package com.project.games_app.dto.gamepointsDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class GamePointsRequestDTO {

    private UUID playerId;
    private UUID gameId;
    private Integer points;
}
