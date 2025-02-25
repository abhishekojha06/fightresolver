package com.flatmate.fightresolver.service;

import com.flatmate.fightresolver.dto.AuthResponse;
import com.flatmate.fightresolver.dto.LoginRequest;
import com.flatmate.fightresolver.dto.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}
