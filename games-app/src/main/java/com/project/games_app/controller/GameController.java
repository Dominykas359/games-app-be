package com.project.games_app.controller;

import com.project.games_app.dto.gameDTOs.GameRequestDTO;
import com.project.games_app.dto.gameDTOs.GameResponseDTO;
import com.project.games_app.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    @PostMapping
    public ResponseEntity<GameResponseDTO> createGame(
            @RequestBody GameRequestDTO gameRequestDTO
    ){
        return ResponseEntity.ok(gameService.createGame(gameRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameResponseDTO> getGame(@PathVariable("id") UUID id){
        return ResponseEntity.ok(gameService.getGame(id));
    }

    @GetMapping
    public List<GameResponseDTO> getGames(){
        return gameService.getGames();
    }

    @PutMapping("/{id}")
    public GameResponseDTO updateGame(
            @PathVariable("id") UUID id,
            @RequestBody GameRequestDTO gameRequestDTO
    ){
        return gameService.updateGame(id, gameRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id){
        gameService.deleteGame(id);
    }
}
