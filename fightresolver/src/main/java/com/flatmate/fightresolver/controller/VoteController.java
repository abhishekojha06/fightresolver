package com.flatmate.fightresolver.controller;

import com.flatmate.fightresolver.dto.VoteRequest;
import com.flatmate.fightresolver.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/votes")
@RequiredArgsConstructor
public class VoteController {
    private final VoteService voteService;

    @PostMapping
    public ResponseEntity<String> voteOnComplaint(@RequestBody VoteRequest request,
                                                  @AuthenticationPrincipal User user) {
        voteService.voteOnComplaint(request, user.getUsername());
        return ResponseEntity.ok("Vote recorded successfully");
    }
}
