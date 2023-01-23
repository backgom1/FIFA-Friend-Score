package com.GangJin.Fifahasu.fifaInfo;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@Slf4j
@RequiredArgsConstructor
public class fifaInfo {
    private fifaInfoVO fifaInfoVO;

    public String Info() {
        URI uri = UriComponentsBuilder
                .fromUriString("https://api.nexon.co.kr")
                .path("fifaonline4/v1.0/users")
                .queryParam("nickname", "은광산")
                .encode()
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();

        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJYLUFwcC1SYXRlLUxpbWl0IjoiNTAwOjEwIiwiYWNjb3VudF9pZCI6IjIwODA2ODI1NjQiLCJhdXRoX2lkIjoiMiIsImV4cCI6MTY5MDAyOTAyNywiaWF0IjoxNjc0NDc3MDI3LCJuYmYiOjE2NzQ0NzcwMjcsInNlcnZpY2VfaWQiOiI0MzAwMTE0ODEiLCJ0b2tlbl90eXBlIjoiQWNjZXNzVG9rZW4ifQ.-brAZxOBgURuSymRobCzU58uiF8ZpGPDsOSkpK8YDMk");


        HttpEntity request = new HttpEntity(headers);


        ResponseEntity<String> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                request,
                String.class
        );

        log.info("값3={}", response.getHeaders());
        log.info("값4={}", response.getBody());

        return response.getBody();
    }
}
