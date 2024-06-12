package com.project.games_app.dto.friendDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class FriendResponseDTO extends FriendRequestDTO{

    private UUID id;
    private LocalDate friendsSince;
}
