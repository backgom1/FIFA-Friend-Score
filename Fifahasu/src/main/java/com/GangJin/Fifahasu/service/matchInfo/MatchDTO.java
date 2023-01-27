package com.GangJin.Fifahasu.service.matchInfo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MatchDTO {

    private String matchId;
    private String matchDate;
    private int matchType;
    private List<MatchInfoDTO> matchInfo = new ArrayList<>();

}
