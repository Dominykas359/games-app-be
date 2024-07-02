package com.project.games_app.service;

import com.project.games_app.dto.gamepointsDTOs.GamePointsRequestDTO;
import com.project.games_app.dto.gamepointsDTOs.GamePointsResponseDTO;
import com.project.games_app.dto.mapper.GamePointsMapper;
import com.project.games_app.models.GamePoints;
import com.project.games_app.repository.GamePointsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GamePointsService {

    private final GamePointsRepository gamePointsRepository;

    @Transactional
    public GamePointsResponseDTO create(GamePointsRequestDTO gamePointsRequestDTO){

        GamePoints gamePoints = GamePointsMapper.fromDto(gamePointsRequestDTO);
        gamePointsRepository.insert(gamePoints);
        return GamePointsMapper.toDto(gamePoints);
    }

    @Transactional
    public GamePointsResponseDTO update(UUID id, GamePointsRequestDTO gamePointsRequestDTO){

        GamePoints gamePoints = gamePointsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));

        gamePoints.setPoints(gamePointsRequestDTO.getPoints());

        gamePointsRepository.update(gamePoints);
        return GamePointsMapper.toDto(gamePoints);
    }

    @Transactional
    public void delete(UUID id){
        gamePointsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        gamePointsRepository.delete(id);
    }

    public GamePointsResponseDTO find(UUID id){

        return GamePointsMapper.toDto(gamePointsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found")));
    }

    public GamePointsResponseDTO findByGameAndPlayer(UUID id, UUID playerId){

        return  GamePointsMapper.toDto(gamePointsRepository.findByPlayerAndGame(id, playerId)
                .orElseThrow(() -> new RuntimeException("Not found")));
    }

    public GamePointsResponseDTO findOneByGameId(UUID id, UUID playerId){

        return GamePointsMapper.toDto(gamePointsRepository.findOneByGameId(id, playerId)
                .orElseThrow(() -> new RuntimeException("Not found")));
    }

    public List<GamePointsResponseDTO> findByPlayer(UUID playerId){

        return gamePointsRepository.findByPlayerId(playerId)
                .stream()
                .map(GamePointsMapper::toDto)
                .toList();
    }

    public List<GamePointsResponseDTO> findByGamePlayer(UUID playerId, UUID gameId){

        return gamePointsRepository.findByGameIdPlayer(playerId, gameId)
                .stream()
                .map(GamePointsMapper::toDto)
                .toList();
    }

    public List<GamePointsResponseDTO> findByGamePlayer2(UUID playerId, UUID gameId){

        return gamePointsRepository.findByGameIdPlayer2(playerId, gameId)
                .stream()
                .map(GamePointsMapper::toDto)
                .toList();
    }

    public List<GamePointsResponseDTO> findByGame(UUID gameId){

        return gamePointsRepository.findByGameId(gameId)
                .stream()
                .map(GamePointsMapper::toDto)
                .toList();
    }
}
