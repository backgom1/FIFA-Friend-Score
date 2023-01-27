package com.GangJin.Fifahasu.service.matchInfo;

import lombok.Data;

@Data
public class PlayerDTO {
    private int spId;    //	선수 고유 식별자 (/metadata/spid API 참고)
    private int spPosition;    // 	선수 포지션 (/metadata/spposition API 참고)
    private int spGrade;//	선수 강화 등급
    private StatusDTO status; //선수 경기 스탯

}
