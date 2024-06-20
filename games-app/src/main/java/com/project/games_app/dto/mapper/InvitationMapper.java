package com.project.games_app.dto.mapper;

import com.project.games_app.dto.invitationDTOs.InvitationRequestDTO;
import com.project.games_app.dto.invitationDTOs.InvitationResponseDTO;
import com.project.games_app.models.Invitation;

import java.util.UUID;

public class InvitationMapper {

    public static InvitationResponseDTO toDto(Invitation invitation){

        return InvitationResponseDTO.builder()
                .id(invitation.getId())
                .playerId(invitation.getPlayerId())
                .friendId(invitation.getFriendId())
                .build();
    }

    public static Invitation fromDto(InvitationRequestDTO invitationRequestDTO){

        return Invitation.builder()
                .id(UUID.randomUUID())
                .playerId(invitationRequestDTO.getPlayerId())
                .friendId(invitationRequestDTO.getFriendId())
                .build();
    }
}
