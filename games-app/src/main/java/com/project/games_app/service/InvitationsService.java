package com.project.games_app.service;

import com.project.games_app.dto.friendDTOs.FriendRequestDTO;
import com.project.games_app.dto.friendDTOs.FriendResponseDTO;
import com.project.games_app.dto.invitationDTOs.InvitationRequestDTO;
import com.project.games_app.dto.invitationDTOs.InvitationResponseDTO;
import com.project.games_app.dto.mapper.FriendMapper;
import com.project.games_app.dto.mapper.InvitationMapper;
import com.project.games_app.models.Invitation;
import com.project.games_app.repository.InvitationsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InvitationsService {

    private final InvitationsRepository invitationsRepository;

    @Transactional
    public InvitationResponseDTO create(InvitationRequestDTO invitationRequestDTO){
        Invitation invitation = InvitationMapper.fromDto(invitationRequestDTO);
        invitationsRepository.insert(invitation);
        return InvitationMapper.toDto(invitation);
    }

    public List<InvitationResponseDTO> findByPlayer(UUID playerId){

        return invitationsRepository.findByPlayerId(playerId)
                .stream()
                .map(InvitationMapper::toDto)
                .toList();
    }

    public List<InvitationResponseDTO> findByFriend(UUID friendId){

        return invitationsRepository.findByFriendId(friendId)
                .stream()
                .map(InvitationMapper::toDto)
                .toList();
    }

    public InvitationResponseDTO findInvitation(UUID id){

        return InvitationMapper.toDto(invitationsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Friendship with given id not found.")));
    }

    @Transactional
    public void delete(UUID id){
        invitationsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Friendship with given id not found."));
        invitationsRepository.delete(id);
    }
}
