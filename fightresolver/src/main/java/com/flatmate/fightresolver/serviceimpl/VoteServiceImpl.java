package com.flatmate.fightresolver.serviceimpl;



import com.flatmate.fightresolver.dto.VoteRequest;
import com.flatmate.fightresolver.entity.Complaint;
import com.flatmate.fightresolver.entity.User;
import com.flatmate.fightresolver.entity.Vote;
import com.flatmate.fightresolver.repository.ComplaintRepository;
import com.flatmate.fightresolver.repository.UserRepository;
import com.flatmate.fightresolver.repository.VoteRepository;
import com.flatmate.fightresolver.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService {
    private final VoteRepository voteRepository;
    private final ComplaintRepository complaintRepository;
    private final UserRepository userRepository;

    @Override
    public void voteOnComplaint(VoteRequest request, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Complaint complaint = complaintRepository.findById(request.getComplaintId())
                .orElseThrow(() -> new RuntimeException("Complaint not found"));

        Vote vote = new Vote();
        vote.setUser(user);
        vote.setComplaint(complaint);
        vote.setUpvote(request.isUpvote());

        voteRepository.save(vote);
    }
}

