package com.flatmate.fightresolver.repository;

import com.flatmate.fightresolver.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}
