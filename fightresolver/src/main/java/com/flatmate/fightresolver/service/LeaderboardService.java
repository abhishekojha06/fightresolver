package com.flatmate.fightresolver.service;

import com.flatmate.fightresolver.dto.LeaderboardResponse;

import java.util.List;

public interface LeaderboardService {
    List<LeaderboardResponse> getLeaderboard();
}
