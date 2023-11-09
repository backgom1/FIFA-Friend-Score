package com.GangJin.Fifahasu.service;

import com.GangJin.Fifahasu.dto.FifaInfoVO;
import com.GangJin.Fifahasu.dto.UserSearchResult;
import com.GangJin.Fifahasu.dto.MatchDTO;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

public interface IRecordSearchService {

    /**
     * 사용자 전적 정보를 조회하는 리스트
     */
    FifaInfoVO findRecordList();

    List<String> MatchUID(@ModelAttribute UserSearchResult form);
    MatchDTO MatchVSInfo(@ModelAttribute UserSearchResult form, String matchUID);
}
