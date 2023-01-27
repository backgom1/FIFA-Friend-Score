package com.GangJin.Fifahasu.service.matchInfo;

import lombok.Data;

@Data
public class MatchDetailDTO {

    private int seasonId;
    private String matchResult;
    private int matchEndType;
    private int systemPause;
    private int foul;
    private int injury;
    private int redCards;
    private int yellowCards;
    private int dribble;
    private int cornerKick;
    private int possession;
    private int OffsideCount;
    private double averageRating;
    private String controller; // 사용한 컨트롤러 타입 (keyboard / pad / etc ) 중 1
}
