package com.flatmate.fightresolver.serviceimpl;


import com.flatmate.fightresolver.dto.AuthResponse;
import com.flatmate.fightresolver.dto.LoginRequest;
import com.flatmate.fightresolver.dto.RegisterRequest;
import com.flatmate.fightresolver.entity.User;
import com.flatmate.fightresolver.repository.UserRepository;
import com.flatmate.fightresolver.security.JwtUtil;
import com.flatmate.fightresolver.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("User already exists");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFlatCode(request.getFlatCode());
        user.setRoles(Collections.singleton("USER"));
        userRepository.save(user);

        String token = jwtUtil.generateToken(user.getUsername());
        return new AuthResponse(user.getUsername(), token);
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        Optional<User> userOptional = userRepository.findByUsername(request.getUsername());
        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        User user = userOptional.get();
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getUsername());
        return new AuthResponse(user.getUsername(), token);
    }
}
