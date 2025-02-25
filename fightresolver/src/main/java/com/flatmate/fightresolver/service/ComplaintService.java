package com.flatmate.fightresolver.service;

import com.flatmate.fightresolver.dto.ComplaintRequest;
import com.flatmate.fightresolver.entity.Complaint;
import java.util.List;

public interface ComplaintService {
    Complaint fileComplaint(ComplaintRequest request, String username);
    List<Complaint> getAllComplaints();
    Complaint resolveComplaint(Long id, String username);
}
