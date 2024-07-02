package com.project.games_app.controller;


import com.project.games_app.dto.friendDTOs.FriendRequestDTO;
import com.project.games_app.dto.friendDTOs.FriendResponseDTO;
import com.project.games_app.repository.FriendsRepository;
import com.project.games_app.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/friends")
public class FriendController {

    private final FriendService friendService;

    @PostMapping
    public ResponseEntity<FriendResponseDTO> create(
            @RequestBody FriendRequestDTO friendRequestDTO
    ){
        return ResponseEntity.ok(friendService.create(friendRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FriendResponseDTO> findFriendship(
            @PathVariable("id") UUID id
    ){
        return ResponseEntity.ok(friendService.findFriend(id));
    }

    @GetMapping("/list/{id}")
    public List<FriendResponseDTO> findFriends(
            @PathVariable("id") UUID id
    ){
        return friendService.findByPlayer(id);
    }

    @GetMapping("/list/friend/{id}")
    public List<FriendResponseDTO> findFriendByFriend(
            @PathVariable("id") UUID id
    ){
        return friendService.findByFriend(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id){
        friendService.delete(id);
    }
}
