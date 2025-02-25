package com.flatmate.fightresolver.controller;

import com.flatmate.fightresolver.repository.ComplaintRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/flat/stats")
@RequiredArgsConstructor
public class FlatStatsController {
    private final ComplaintRepository complaintRepository;

    @GetMapping
    public ResponseEntity<Map<String, Long>> getFlatStats() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("totalComplaints", complaintRepository.count());
        stats.put("resolvedComplaints", complaintRepository.countByResolved(true));
        stats.put("pendingComplaints", complaintRepository.countByResolved(false));
        return ResponseEntity.ok(stats);
    }
}
