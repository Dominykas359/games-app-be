package com.project.games_app.service;

import com.project.games_app.dto.friendDTOs.FriendRequestDTO;
import com.project.games_app.dto.friendDTOs.FriendResponseDTO;
import com.project.games_app.dto.mapper.FriendMapper;
import com.project.games_app.models.Friend;
import com.project.games_app.repository.FriendsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FriendService {

    private final FriendsRepository friendsRepository;

    @Transactional
    public FriendResponseDTO create(FriendRequestDTO friendRequestDTO){

        Friend friend = FriendMapper.fromDto(friendRequestDTO);
        friendsRepository.insert(friend);
        return FriendMapper.toDto(friend);
    }

    public List<FriendResponseDTO> findByPlayer(UUID playerId){

        return friendsRepository.findByPlayerId(playerId)
                .stream()
                .map(FriendMapper::toDto)
                .toList();
    }

    public List<FriendResponseDTO> findByFriend(UUID friendId){

        return friendsRepository.findByFriendId(friendId)
                .stream()
                .map(FriendMapper::toDto)
                .toList();
    }

    public FriendResponseDTO findFriend(UUID id){

        return FriendMapper.toDto(friendsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Friendship with given id not found.")));
    }

    @Transactional
    public void delete(UUID id){
        friendsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Friendship with given id not found."));
        friendsRepository.delete(id);
    }
}
