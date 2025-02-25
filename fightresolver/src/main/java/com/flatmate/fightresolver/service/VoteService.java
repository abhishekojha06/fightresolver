package com.flatmate.fightresolver.service;

import com.flatmate.fightresolver.dto.VoteRequest;

public interface VoteService {
    void voteOnComplaint(VoteRequest request, String username);
}
