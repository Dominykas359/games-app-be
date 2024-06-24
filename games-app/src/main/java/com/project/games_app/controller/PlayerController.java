package com.project.games_app.controller;

import com.project.games_app.dto.authenticationDTOs.PasswordRequest;
import com.project.games_app.dto.playerDTOs.PlayerRequestDTO;
import com.project.games_app.dto.playerDTOs.PlayerResponseDTO;
import com.project.games_app.service.PlayerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping("/{id}")
    public ResponseEntity<PlayerResponseDTO> getPlayer(@PathVariable(value = "id") UUID id){
        return ResponseEntity.ok(playerService.getPlayer(id));
    }

    @GetMapping("/username/{nickname}")
    public ResponseEntity<PlayerResponseDTO> getPlayerByNickname(
            @PathVariable(value = "nickname") String nickname) {
        return ResponseEntity.ok(playerService.getPlayerByNickname(nickname));
    }

    @GetMapping
    public List<PlayerResponseDTO> getPlayers(){
        return playerService.getPlayers();
    }

    @GetMapping("/leaderboard")
    public List<PlayerResponseDTO> getPlayersForLeaderboard(){
        return playerService.getPlayersForLeaderboard();
    }

    @GetMapping("/leaderboard/friends/{id}")
    public List<PlayerResponseDTO> getPlayersForLeaderboardFriends(@PathVariable(value = "id") UUID id){
        return playerService.getPlayersForLeaderboardFriends(id);
    }

    @GetMapping("/leaderboard/friends/by-player/{id}")
    public List<PlayerResponseDTO> getPlayersForLeaderboardFriendsByPlayer(@PathVariable(value = "id") UUID id){
        return playerService.getPlayersForLeaderboardFriendsByPlayer(id);
    }

    @PutMapping("/{id}")
    public PlayerResponseDTO updatePlayer(@PathVariable(value = "id") UUID id, @RequestBody PlayerRequestDTO playerRequestDTO){
        return playerService.update(id, playerRequestDTO);
    }

    @PutMapping("/change-password/{id}")
    public PlayerResponseDTO updatePassword(
            @PathVariable(value = "id") UUID id,
            @RequestBody PasswordRequest passwordRequest
            ){
        return playerService.updatePassword(id, passwordRequest);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable(value = "id") UUID id){
        playerService.delete(id);
    }
}
