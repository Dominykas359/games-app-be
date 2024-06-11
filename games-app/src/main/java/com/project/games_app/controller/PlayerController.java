package com.project.games_app.controller;

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

    @GetMapping
    public List<PlayerResponseDTO> getPlayers(){
        return playerService.getPlayers();
    }

    @PutMapping("/{id}")
    public PlayerResponseDTO updatePlayer(@PathVariable(value = "id") UUID id, @RequestBody PlayerRequestDTO playerRequestDTO){
        return playerService.update(id, playerRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable(value = "id") UUID id){
        playerService.delete(id);
    }
}
