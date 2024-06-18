package com.project.games_app.dto.mapper;

import com.project.games_app.dto.gameDTOs.GameRequestDTO;
import com.project.games_app.dto.gameDTOs.GameResponseDTO;
import com.project.games_app.models.Game;

import java.util.UUID;

public class GameMapper {

    public static GameResponseDTO toDto(Game game){

        return GameResponseDTO.builder()
                .id(game.getId())
                .title(game.getTitle())
                .pictureUrl(game.getPictureUrl())
                .build();
    }

    public static Game fromDto(GameRequestDTO gameRequestDTO){

        Game game = Game.builder()
                .id(UUID.randomUUID())
                .title(gameRequestDTO.getTitle())
                .pictureUrl(gameRequestDTO.getPictureUrl())
                .build();

        return game;
    }
}
