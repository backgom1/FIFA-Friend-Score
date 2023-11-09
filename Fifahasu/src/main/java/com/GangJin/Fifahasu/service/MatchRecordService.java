package com.GangJin.Fifahasu.service;

import com.GangJin.Fifahasu.dto.FifaInfoVO;
import com.GangJin.Fifahasu.dto.UserSearchResult;
import com.GangJin.Fifahasu.repository.ISearchResultRepository;
import com.GangJin.Fifahasu.dto.MatchDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;


/**
 * 사용자의 FIFA 매치 기록을 조회합니다.
 *
 * @return FIFAUserInfo 사용자의 FIFA 매치 정보를 담은 객체를 반환합니다.
 *         현재는 구현되지 않았으므로 항상 null을 반환합니다.
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class MatchRecordService implements IRecordSearchService{

    private final static String FIFA_API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJYLUFwcC1SYXRlLUxpbWl0IjoiNTAwOjEwIiwiYWNjb3VudF9pZCI6IjIwODA2ODI1NjQiLCJhdXRoX2lkIjoiMiIsImV4cCI6MTcxNDMxOTYyNiwiaWF0IjoxNjk4NzY3NjI2LCJuYmYiOjE2OTg3Njc2MjYsInNlcnZpY2VfaWQiOiI0MzAwMTE0ODEiLCJ0b2tlbl90eXBlIjoiQWNjZXNzVG9rZW4ifQ.dcD8FnkaeDl0mAYkKgdCZ0fC3l-_4AQSXkku8j_K9Mo";


    private final ISearchResultRepository searchResultRepository;
    public FifaInfoVO findRecordList() {
        URI uri = UriComponentsBuilder
                .fromUriString("https://api.nexon.co.kr")
                .path("fifaonline4/v1.0/users")
                .queryParam("nickname", "{nickname}")
                .encode()
                .build()
                .expand(form.getNickname())
                .toUri();

        RestTemplate restTemplate = new RestTemplate();

        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization",FIFA_API_KEY);
        HttpEntity request = new HttpEntity(headers);


        //결과를 담을 값
        ResponseEntity<FifaInfoVO> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                request,
                FifaInfoVO.class
        );
        log.info("헤더 값={}", response.getHeaders());
        log.info("바디 값={}", response.getBody());
        log.info("피파 레벨={}", response.getBody().getLevel());

        return response.getBody();
    }

    public List<String> MatchUID(UserSearchResult form) {
        URI UID_uri = UriComponentsBuilder
                .fromUriString("https://api.nexon.co.kr")
                .path("fifaonline4/v1.0/users/{accessId}/matches")
                .queryParam("matchtype", 40)
                .queryParam("offset", 0)
                .queryParam("limit", 2)
                .encode()
                .build()
                .expand(Info(form).getAccessId())
                .expand(form.getNickname())
                .toUri();

        RestTemplate UID_restTemplate = new RestTemplate();

        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization",FIFA_API_KEY);
        HttpEntity request = new HttpEntity(headers);


        //결과를 담을 값
        ResponseEntity<List> UID_response = UID_restTemplate.exchange(
                UID_uri,
                HttpMethod.GET,
                request,
                List.class
        );

        log.info("매치 UID 헤더 값={}", UID_response.getHeaders());
        log.info("매치 UID 바디 값={}", UID_response.getBody());

        return UID_response.getBody();
    }


    public MatchDTO MatchVSInfo(UserSearchResult form, String matchUID) {
        // List<String> matchUID = MatchUID(form);
        log.info("배열 담은 값={}", matchUID);
        URI MatchInfo_uri = UriComponentsBuilder
                .fromUriString("https://api.nexon.co.kr")
                .path("fifaonline4/v1.0/matches/{matchid}")
                .encode()
                .build()
                .expand(matchUID)
                .toUri();

        RestTemplate Match_restTemplate = new RestTemplate();

        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", FIFA_API_KEY);
        HttpEntity request = new HttpEntity(headers);


        //결과를 담을 값
        ResponseEntity<MatchDTO> Match_response = Match_restTemplate.exchange(
                MatchInfo_uri,
                HttpMethod.GET,
                request,
                MatchDTO.class
        );

        log.info("매치 상세 경기 헤더 값={}", Match_response.getHeaders());
        log.info("매치 상세 경기 바디 값={}", Match_response.getBody());

        return Match_response.getBody();
    }
    }
}
