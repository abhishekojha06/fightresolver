package com.flatmate.fightresolver.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoteRequest {
    private Long complaintId;
    private boolean upvote;
}
