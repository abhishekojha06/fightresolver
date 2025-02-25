package com.flatmate.fightresolver.controller;

import com.flatmate.fightresolver.dto.ComplaintRequest;
import com.flatmate.fightresolver.entity.Complaint;
import com.flatmate.fightresolver.service.ComplaintService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
@RequiredArgsConstructor
public class ComplaintController {
    private final ComplaintService complaintService;

    @PostMapping
    public ResponseEntity<Complaint> fileComplaint(@RequestBody ComplaintRequest request,
                                                   @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(complaintService.fileComplaint(request, user.getUsername()));
    }

    @GetMapping
    public ResponseEntity<List<Complaint>> getAllComplaints() {
        return ResponseEntity.ok(complaintService.getAllComplaints());
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<Complaint> resolveComplaint(@PathVariable Long id,
                                                      @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(complaintService.resolveComplaint(id, user.getUsername()));
    }
}
