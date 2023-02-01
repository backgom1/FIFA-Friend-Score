package com.GangJin.Fifahasu.service.fifaInfo;


import com.GangJin.Fifahasu.controller.main.MainSearchForm;
import com.GangJin.Fifahasu.service.matchInfo.MatchDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FIFAUserInfo extends DefaultResponseErrorHandler {


    //유저 정보 가져오기
    public fifaInfoVO Info(@ModelAttribute MainSearchForm form) {
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
        headers.set("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJYLUFwcC1SYXRlLUxpbWl0IjoiNTAwOjEwIiwiYWNjb3VudF9pZCI6IjIwODA2ODI1NjQiLCJhdXRoX2lkIjoiMiIsImV4cCI6MTY5MDAyOTAyNywiaWF0IjoxNjc0NDc3MDI3LCJuYmYiOjE2NzQ0NzcwMjcsInNlcnZpY2VfaWQiOiI0MzAwMTE0ODEiLCJ0b2tlbl90eXBlIjoiQWNjZXNzVG9rZW4ifQ.-brAZxOBgURuSymRobCzU58uiF8ZpGPDsOSkpK8YDMk");
        HttpEntity request = new HttpEntity(headers);


        //결과를 담을 값
        ResponseEntity<fifaInfoVO> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                request,
                fifaInfoVO.class
        );
        log.info("헤더 값={}", response.getHeaders());
        log.info("바디 값={}", response.getBody());
        log.info("피파 레벨={}", response.getBody().getLevel());

        return response.getBody();
    }


    //매치 UID 값 받아오기
    public List<String> MatchUID(@ModelAttribute MainSearchForm form) {


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
        headers.set("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJYLUFwcC1SYXRlLUxpbWl0IjoiNTAwOjEwIiwiYWNjb3VudF9pZCI6IjIwODA2ODI1NjQiLCJhdXRoX2lkIjoiMiIsImV4cCI6MTY5MDAyOTAyNywiaWF0IjoxNjc0NDc3MDI3LCJuYmYiOjE2NzQ0NzcwMjcsInNlcnZpY2VfaWQiOiI0MzAwMTE0ODEiLCJ0b2tlbl90eXBlIjoiQWNjZXNzVG9rZW4ifQ.-brAZxOBgURuSymRobCzU58uiF8ZpGPDsOSkpK8YDMk");
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


    //전적 검색하기
    public MatchDTO MatchVSInfo(@ModelAttribute MainSearchForm form,String matchUID) {
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
        headers.set("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJYLUFwcC1SYXRlLUxpbWl0IjoiNTAwOjEwIiwiYWNjb3VudF9pZCI6IjIwODA2ODI1NjQiLCJhdXRoX2lkIjoiMiIsImV4cCI6MTY5MDAyOTAyNywiaWF0IjoxNjc0NDc3MDI3LCJuYmYiOjE2NzQ0NzcwMjcsInNlcnZpY2VfaWQiOiI0MzAwMTE0ODEiLCJ0b2tlbl90eXBlIjoiQWNjZXNzVG9rZW4ifQ.-brAZxOBgURuSymRobCzU58uiF8ZpGPDsOSkpK8YDMk");
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
