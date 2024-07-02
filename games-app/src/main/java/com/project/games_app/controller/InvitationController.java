package com.project.games_app.controller;

import com.project.games_app.dto.friendDTOs.FriendRequestDTO;
import com.project.games_app.dto.friendDTOs.FriendResponseDTO;
import com.project.games_app.dto.invitationDTOs.InvitationRequestDTO;
import com.project.games_app.dto.invitationDTOs.InvitationResponseDTO;
import com.project.games_app.service.FriendService;
import com.project.games_app.service.InvitationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/invitations")
public class InvitationController {

    private final InvitationsService invitationsService;

    @PostMapping
    public ResponseEntity<InvitationResponseDTO> create(
            @RequestBody InvitationRequestDTO invitationRequestDTO
    ){
        return ResponseEntity.ok(invitationsService.create(invitationRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvitationResponseDTO> findInvitation(
            @PathVariable("id") UUID id
    ){
        return ResponseEntity.ok(invitationsService.findInvitation(id));
    }

    @GetMapping("/list/{id}")
    public List<InvitationResponseDTO> findFriends(
            @PathVariable("id") UUID id
    ){
        return invitationsService.findByPlayer(id);
    }

    @GetMapping("/list/friend/{id}")
    public List<InvitationResponseDTO> findFriendByFriend(
            @PathVariable("id") UUID id
    ){
        return invitationsService.findByFriend(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id){
        invitationsService.delete(id);
    }
}
