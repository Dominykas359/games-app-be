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

    @GetMapping("/one/{id}/player/{player-id}")
    public ResponseEntity<GamePointsResponseDTO> findOne(
            @PathVariable("id") UUID id,
            @PathVariable("player-id") UUID playerId
    ){

        return ResponseEntity.ok(gamePointsService.findOneByGameId(id, playerId));
    }

    @GetMapping("/player/{id}")
    public List<GamePointsResponseDTO> findByPlayer(@PathVariable("id") UUID playerId){

        return gamePointsService.findByPlayer(playerId);
    }

    @GetMapping("player/{playerId}/game/{id}")
    public ResponseEntity<GamePointsResponseDTO> findByPlayerAndGame(
            @PathVariable("id") UUID id,
            @PathVariable("playerId") UUID playerId
    ){
        return ResponseEntity.ok(gamePointsService.findByGameAndPlayer(id, playerId));
    }

    @GetMapping("/leaderboard/{id}/player/{player-id}")
    public List<GamePointsResponseDTO> findByGamePlayer(
            @PathVariable("id") UUID gameId,
            @PathVariable("player-id") UUID playerId
    ){
        return  gamePointsService.findByGamePlayer(playerId, gameId);
    }

    @GetMapping("/leaderboard2/{id}/player/{player-id}")
    public List<GamePointsResponseDTO> findByGamePlayer2(
            @PathVariable("id") UUID gameId,
            @PathVariable("player-id") UUID playerId
    ){
        return  gamePointsService.findByGamePlayer2(playerId, gameId);
    }

    @GetMapping("/game/{id}")
    public List<GamePointsResponseDTO> findByGame(@PathVariable("id") UUID gameId){

        return gamePointsService.findByGame(gameId);
    }

}
