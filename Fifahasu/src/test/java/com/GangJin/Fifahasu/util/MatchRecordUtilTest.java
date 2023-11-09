package com.GangJin.Fifahasu.util;

import com.GangJin.Fifahasu.dto.FifaInfoVO;
import com.GangJin.Fifahasu.dto.MatchDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@Slf4j
class MatchRecordUtilTest {

    @Autowired
    private MatchRecordUtil matchRecordUtil;

    @Test
    @DisplayName("사용자 AccessId를 가져오는 테스트")
    void accessIdSuccess() {
        FifaInfoVO accessId = matchRecordUtil.getAccessId();
        assertThat(accessId.getAccessId()).isNotNull();
    }

    @Test
    @DisplayName("유저 고유 식별자로 유저의 매치 기록 조회를 하는 테스트")
    void uniqueUserMatchInfoSuccess() {
        //given,when
        FifaInfoVO fifaInfoVO = matchRecordUtil.getAccessId();
        List<String> matchUuidList = matchRecordUtil.getMatchUUID(fifaInfoVO);

        //then
        assertThat(matchUuidList).isNotEmpty();
        assertThat(matchUuidList).hasSize(2);
    }

    @Test
    @DisplayName("매치 상세 기록 조회 테스트")
    void matchDetailInfoSuccess() {
        //given,when
        FifaInfoVO fifaInfoVO = matchRecordUtil.getAccessId();
        List<String> matchUuidList = matchRecordUtil.getMatchUUID(fifaInfoVO);
        List<MatchDTO> matchDetailInfo = matchRecordUtil.getMatchDetailInfo(matchUuidList);

        //then
        assertThat(matchDetailInfo).isNotEmpty();
        assertThat(matchDetailInfo).hasSize(2);
    }
}