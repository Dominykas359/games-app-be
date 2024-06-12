package com.project.games_app.dto.mapper;

import com.project.games_app.dto.friendDTOs.FriendRequestDTO;
import com.project.games_app.dto.friendDTOs.FriendResponseDTO;
import com.project.games_app.models.Friend;

import java.time.LocalDate;
import java.util.UUID;

public class FriendMapper {

    public static FriendResponseDTO toDto(Friend friend){

        return FriendResponseDTO.builder()
                .id(friend.getId())
                .playerId(friend.getPlayerId())
                .friendId(friend.getFriendId())
                .friendsSince(friend.getFriendsSince())
                .build();
    }

    public static Friend fromDto(FriendRequestDTO friendRequestDTO){

        return Friend.builder()
                .id(UUID.randomUUID())
                .playerId(friendRequestDTO.getPlayerId())
                .friendId(friendRequestDTO.getFriendId())
                .friendsSince(LocalDate.now())
                .build();
    }
}
