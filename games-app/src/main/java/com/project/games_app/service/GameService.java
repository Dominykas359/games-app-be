package com.project.games_app.service;

import com.project.games_app.dto.gameDTOs.GameRequestDTO;
import com.project.games_app.dto.gameDTOs.GameResponseDTO;
import com.project.games_app.dto.mapper.GameMapper;
import com.project.games_app.models.Game;
import com.project.games_app.repository.GamesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GamesRepository gamesRepository;

    @Transactional
    public GameResponseDTO createGame(GameRequestDTO gameRequestDTO){

        Game game = GameMapper.fromDto(gameRequestDTO);
        gamesRepository.insert(game);
        return GameMapper.toDto(game);
    }

    public GameResponseDTO getGame(UUID id){

        return GameMapper.toDto(gamesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game with given Id not found")));
    }

    public List<GameResponseDTO> getGames(){

        return gamesRepository.findAll()
                .stream()
                .map(GameMapper::toDto)
                .toList();
    }

    @Transactional
    public GameResponseDTO updateGame(UUID id, GameRequestDTO gameRequestDTO){

        Game game = gamesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game with given Id not found."));

        game.setTitle(gameRequestDTO.getTitle());
        gamesRepository.update(game);

        return GameMapper.toDto(game);
    }

    @Transactional
    public void deleteGame(UUID id){
        gamesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game with given Id not found"));
        gamesRepository.delete(id);
    }
}
