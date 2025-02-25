package com.flatmate.fightresolver.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LeaderboardResponse {
    private String username;
    private int karmaPoints;
}
