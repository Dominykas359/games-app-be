package com.project.games_app.service;

import com.project.games_app.dto.playerDTOs.PlayerRequestDTO;
import com.project.games_app.dto.playerDTOs.PlayerResponseDTO;
import com.project.games_app.dto.mapper.PlayerMapper;
import com.project.games_app.models.Player;
import com.project.games_app.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Transactional
    public PlayerResponseDTO createPlayer(PlayerRequestDTO playerRequestDTO) {
        Player player = PlayerMapper.fromDto(playerRequestDTO);
        playerRepository.insert(player);

        return PlayerMapper.toDto(player);
    }

    public PlayerResponseDTO getPlayer(UUID id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found with ID: " + id));
        return PlayerMapper.toDto(player);
    }

    public PlayerResponseDTO getPlayerByEmail(String email){

        return PlayerMapper.toDto(playerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Not found")));
    }

    public PlayerResponseDTO getPlayerByNickname(String nickname){
        return PlayerMapper.toDto(playerRepository.findByNickname(nickname)
                .orElseThrow(() -> new RuntimeException("Not found")));
    }

    public List<PlayerResponseDTO> getPlayers(){
        return playerRepository.findAll()
                .stream()
                .map(PlayerMapper::toDto)
                .toList();
    }

    @Transactional
    public PlayerResponseDTO update(UUID id, PlayerRequestDTO playerRequestDTO){
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found with ID: " + id));

        player.setEmail(playerRequestDTO.getEmail());
        player.setNickname(playerRequestDTO.getNickname());
        player.setPoints(playerRequestDTO.getPoints());
        player.setLastOnline(playerRequestDTO.getLastOnline());
        player.setProfilePictureUrl(playerRequestDTO.getProfilePictureUrl());

        playerRepository.update(player);

        return PlayerMapper.toDto(player);
    }

    @Transactional
    public void delete(UUID id){
        playerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Player not found with ID: " + id));
        playerRepository.delete(id);
    }
}
