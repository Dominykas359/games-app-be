package com.project.games_app.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GamePoints {

    private UUID id;
    private UUID playerId;
    private UUID gameId;
    private Integer points;
}
