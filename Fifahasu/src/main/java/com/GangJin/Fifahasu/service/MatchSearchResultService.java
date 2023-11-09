package com.GangJin.Fifahasu.service;

import com.GangJin.Fifahasu.dto.FifaInfoVO;
import com.GangJin.Fifahasu.dto.MatchDTO;
import com.GangJin.Fifahasu.util.IRecordSearchUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MatchSearchResultService implements ISearchResultService {

    private final IRecordSearchUtil recordSearchUtil;

    public List<MatchDTO> findByMatchList() {
        FifaInfoVO fifaInfoVO = recordSearchUtil.getAccessId();
        List<String> matchUUID = recordSearchUtil.getMatchUUID(fifaInfoVO);
        return recordSearchUtil.getMatchDetailInfo(matchUUID);
    }
}
