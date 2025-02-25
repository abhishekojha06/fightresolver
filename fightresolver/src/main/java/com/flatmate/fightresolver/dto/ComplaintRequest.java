package com.flatmate.fightresolver.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComplaintRequest {
    private String title;
    private String description;
    private String type;
    private String severity;
}
