package com.project.games_app.dto.mapper;

import com.project.games_app.dto.playerDTOs.PlayerRequestDTO;
import com.project.games_app.dto.playerDTOs.PlayerResponseDTO;
import com.project.games_app.models.Player;


public class PlayerMapper {
    public static PlayerResponseDTO toDto(Player player) {

        return PlayerResponseDTO.builder()
                .id(player.getId())
                .email(player.getEmail())
                .nickname(player.getNickname())
                .points(player.getPoints())
                .lastOnline(player.getLastOnline())
                .build();
    }
    public static Player fromDto(PlayerRequestDTO playerDTO) {
        return Player.builder()
                .id(playerDTO.getId())
                .email(playerDTO.getEmail())
                .nickname(playerDTO.getNickname())
                .password(playerDTO.getPassword())
                .points(playerDTO.getPoints())
                .lastOnline(playerDTO.getLastOnline())
                .build();
    }
}
