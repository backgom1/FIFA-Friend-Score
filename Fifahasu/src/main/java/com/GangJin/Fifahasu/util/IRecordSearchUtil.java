package com.GangJin.Fifahasu.util;

import com.GangJin.Fifahasu.dto.FifaInfoVO;
import com.GangJin.Fifahasu.dto.MatchDTO;

import java.util.List;

public interface IRecordSearchUtil {

    /**
     * 사용자 전적 정보를 조회하는 리스트
     */
    FifaInfoVO getAccessId();
    List<String> getMatchUUID(FifaInfoVO fifaInfoVO);
    List<MatchDTO> getMatchDetailInfo(List<String> matchUuidList);
}
