package com.project.games_app.controller;

import com.project.games_app.dto.gamepointsDTOs.GamePointsRequestDTO;
import com.project.games_app.dto.gamepointsDTOs.GamePointsResponseDTO;
import com.project.games_app.service.GamePointsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/points")
public class GamePointsController {

    private final GamePointsService gamePointsService;

    @PostMapping
    public ResponseEntity<GamePointsResponseDTO> create(
            @RequestBody GamePointsRequestDTO gamePointsRequestDTO
            ){
        return ResponseEntity.ok(gamePointsService.create(gamePointsRequestDTO));
    }

    @PutMapping("/{id}")
    public GamePointsResponseDTO update(
            @PathVariable("id") UUID id,
            @RequestBody GamePointsRequestDTO gamePointsRequestDTO
    ){
        return gamePointsService.update(id, gamePointsRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id){
        gamePointsService.delete(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GamePointsResponseDTO> find(@PathVariable("id") UUID id){

        return ResponseEntity.ok(gamePointsService.find(id));
    }

    @GetMapping("/player/{id}")
    public List<GamePointsResponseDTO> findByPlayer(@PathVariable("id") UUID playerId){

        return gamePointsService.findByPlayer(playerId);
    }

    @GetMapping("/game/{id}")
    public List<GamePointsResponseDTO> findByGame(@PathVariable("id") UUID gameId){

        return gamePointsService.findByGame(gameId);
    }

}
