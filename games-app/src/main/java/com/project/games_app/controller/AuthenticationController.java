package com.project.games_app.controller;

import com.project.games_app.dto.authenticationDTOs.AuthenticationRequest;
import com.project.games_app.dto.authenticationDTOs.AuthenticationResponse;
import com.project.games_app.dto.authenticationDTOs.RegisterRequest;
import com.project.games_app.dto.playerDTOs.PlayerResponseDTO;
import com.project.games_app.service.AuthenticationService;
import com.project.games_app.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    private final PlayerService playerService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(service.login(request));
    }

    @GetMapping("/check-email/{email}")
    public ResponseEntity<PlayerResponseDTO> checkEmail(
            @PathVariable("email") String email
    ){
        return ResponseEntity.ok(playerService.getPlayerByEmail(email));
    }

    @GetMapping("/check-nickname/{nickname}")
    public ResponseEntity<PlayerResponseDTO> checkNickname(
            @PathVariable("nickname") String nickname
    ){
        return ResponseEntity.ok(playerService.getPlayerByNickname(nickname));
    }
}
