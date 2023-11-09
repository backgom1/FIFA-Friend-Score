package com.GangJin.Fifahasu.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MatchInfoDTO {


    private String accessId;
    private String nickname;
    private MatchDetailDTO matchDetail;
    private ShootDTO shoot;
    private List<ShootDetailDTO> shootDetail;
    private PassDTO pass;
    private DefenceDTO defence;
    private List<PlayerDTO> player;

}
