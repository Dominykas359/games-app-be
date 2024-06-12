package com.project.games_app.service;

import com.fasterxml.classmate.AnnotationOverrides;
import com.project.games_app.dto.authenticationDTOs.AuthenticationRequest;
import com.project.games_app.dto.authenticationDTOs.AuthenticationResponse;
import com.project.games_app.dto.authenticationDTOs.RegisterRequest;
import com.project.games_app.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.project.games_app.models.Player;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final PlayerRepository playerRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {

        var player = Player.builder()
                .id(UUID.randomUUID())
                .email(request.getEmail())
                .nickname(request.getNickname())
                .password(passwordEncoder.encode(request.getPassword()))
                .points(100)
                .lastOnline(null)
                .profilePictureUrl(null)
                .build();
        playerRepository.insert(player);
        var jwtToken = jwtService.generateToken(player);
        return AuthenticationResponse.builder()
                .id(player.getId())
                .email(player.getEmail())
                .nickname(player.getNickname())
                .points(player.getPoints())
                .lastOnline(player.getLastOnline())
                .profilePictureUrl(player.getProfilePictureUrl())
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse login(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var player = playerRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(player);
        return AuthenticationResponse.builder()
                .id(player.getId())
                .email(player.getEmail())
                .nickname(player.getNickname())
                .points(player.getPoints())
                .lastOnline(player.getLastOnline())
                .profilePictureUrl(player.getProfilePictureUrl())
                .token(jwtToken)
                .build();
    }
}
