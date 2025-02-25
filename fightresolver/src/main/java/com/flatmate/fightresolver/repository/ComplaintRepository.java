package com.flatmate.fightresolver.repository;

import com.flatmate.fightresolver.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    long countByResolved(boolean resolved);
}
