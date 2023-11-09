package com.GangJin.Fifahasu.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MatchDTO {

    private String matchId;
    private String matchDate;
    private int matchType;
    private List<MatchInfoDTO> matchInfo;

}
