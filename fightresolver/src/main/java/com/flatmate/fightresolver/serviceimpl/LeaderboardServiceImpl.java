package com.flatmate.fightresolver.serviceimpl;



import com.flatmate.fightresolver.dto.LeaderboardResponse;
import com.flatmate.fightresolver.entity.User;
import com.flatmate.fightresolver.repository.UserRepository;
import com.flatmate.fightresolver.service.LeaderboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LeaderboardServiceImpl implements LeaderboardService {
    private final UserRepository userRepository;

    @Override
    public List<LeaderboardResponse> getLeaderboard() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new LeaderboardResponse(user.getUsername(), calculateKarmaPoints(user)))
                .sorted((a, b) -> Integer.compare(b.getKarmaPoints(), a.getKarmaPoints()))
                .toList();
    }

    private int calculateKarmaPoints(User user) {
        return user.getRoles().contains("MODERATOR") ? 100 : 10;  // Dummy logic, replace with actual calculations
    }
}
