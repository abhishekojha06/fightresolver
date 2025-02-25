package com.flatmate.fightresolver.serviceimpl;


import com.flatmate.fightresolver.dto.ComplaintRequest;
import com.flatmate.fightresolver.entity.Complaint;
import com.flatmate.fightresolver.entity.User;
import com.flatmate.fightresolver.repository.ComplaintRepository;
import com.flatmate.fightresolver.repository.UserRepository;
import com.flatmate.fightresolver.service.ComplaintService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComplaintServiceImpl implements ComplaintService {
    private final ComplaintRepository complaintRepository;
    private final UserRepository userRepository;

    @Override
    public Complaint fileComplaint(ComplaintRequest request, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Complaint complaint = new Complaint();
        complaint.setTitle(request.getTitle());
        complaint.setDescription(request.getDescription());
        complaint.setType(request.getType());
        complaint.setSeverity(request.getSeverity());
        complaint.setTimestamp(LocalDateTime.now());
        complaint.setResolved(false);
        complaint.setUser(user);

        return complaintRepository.save(complaint);
    }

    @Override
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    @Override
    public Complaint resolveComplaint(Long id, String username) {
        Complaint complaint = complaintRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));

        complaint.setResolved(true);
        return complaintRepository.save(complaint);
    }
}
