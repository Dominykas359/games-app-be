package com.project.games_app.dto.mapper;

import com.project.games_app.dto.gamepointsDTOs.GamePointsRequestDTO;
import com.project.games_app.dto.gamepointsDTOs.GamePointsResponseDTO;
import com.project.games_app.models.GamePoints;

import java.util.UUID;

public class GamePointsMapper {

    public static GamePointsResponseDTO toDto(GamePoints gamePoints){

        return GamePointsResponseDTO.builder()
                .id(gamePoints.getId())
                .playerId(gamePoints.getPlayerId())
                .gameId(gamePoints.getGameId())
                .points(gamePoints.getPoints())
                .build();
    }

    public static GamePoints fromDto(GamePointsRequestDTO gamePointsRequestDTO){

        return GamePoints.builder()
                .id(UUID.randomUUID())
                .playerId(gamePointsRequestDTO.getPlayerId())
                .gameId(gamePointsRequestDTO.getGameId())
                .points(gamePointsRequestDTO.getPoints())
                .build();
    }
}
