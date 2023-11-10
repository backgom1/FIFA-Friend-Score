package com.GangJin.Fifahasu.util;

import com.GangJin.Fifahasu.dto.FifaInfoVO;
import com.GangJin.Fifahasu.dto.MatchDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


/**
 * FIFA 온라인 4 관련 데이터 처리를 위한 유틸리티 클래스입니다.
 *
 * 이 클래스는 넥슨의 FIFA 온라인 4 API를 사용하여 다양한 데이터를 검색하고 처리합니다.
 * API 키를 사용하여 인증된 요청을 보내고, 사용자의 FIFA 정보, 매치 UUID, 매치 상세 정보 등을 가져옵니다.
 *
 * 주요 기능:
 * - 사용자의 FIFA 정보 검색: {@link #getAccessId()}
 * - 특정 사용자의 매치 UUID 목록 검색: {@link #getMatchUUID(FifaInfoVO)}
 * - 매치 목록에 대한 상세 정보 검색: {@link #getMatchDetailInfo(List)}
 *
 * 이 클래스는 {@link Service}로 등록되어 스프링 컨테이너에서 관리됩니다.'
 * @since 2023-11-10
 * @author 이은성
 */
@Slf4j
@Service
@AllArgsConstructor
public class MatchRecordUtil implements IRecordSearchUtil {

    private final static String FIFA_API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJYLUFwcC1SYXRlLUxpbWl0IjoiNTAwOjEwIiwiYWNjb3VudF9pZCI6IjIwODA2ODI1NjQiLCJhdXRoX2lkIjoiMiIsImV4cCI6MTcxNDMxOTYyNiwiaWF0IjoxNjk4NzY3NjI2LCJuYmYiOjE2OTg3Njc2MjYsInNlcnZpY2VfaWQiOiI0MzAwMTE0ODEiLCJ0b2tlbl90eXBlIjoiQWNjZXNzVG9rZW4ifQ.dcD8FnkaeDl0mAYkKgdCZ0fC3l-_4AQSXkku8j_K9Mo";



    /**
     * 지정된 사용자 닉네임에 대한 FIFA 기록을 조회합니다.
     *
     * <p>넥슨의 FIFA 온라인 4 API를 사용하여 사용자의 정보를 가져옵니다. 이 메소드는 "은광산"이라는 닉네임으로
     * 고정된 사용자 정보를 요청하며, 결과를 {@link FifaInfoVO} 클래스의 인스턴스에 담아 반환합니다.</p>
     *
     * @return FifaInfoVO 사용자의 FIFA 정보가 담긴 객체. API 호출이 성공적이면 사용자 정보가,
     * 실패하면 null이 반환될 수 있습니다.
     * @throws RestClientException API 요청 중 오류가 발생할 경우 발생
     */
    public FifaInfoVO getAccessId() {
        log.info("============= AccessId 시작 ==============");
        URI uri = setUrlBuilder("https://public.api.nexon.com",
                "/openapi/fconline/v1.0/users");

        RestTemplate restTemplate = new RestTemplate();

        //서버 요청
        HttpEntity request = requestMatch();


        //결과를 담을 값
        ResponseEntity<FifaInfoVO> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                request,
                FifaInfoVO.class
        );
        log.info("============= AccessId 끝 ==============");
        return response.getBody();
    }


    /**
     * 넥슨 공개 API를 사용하여 특정 사용자의 매치 UUID 목록을 가져옵니다.
     *
     * @param fifaInfoVO FifaInfoVO 객체로, 사용자의 accessId를 포함합니다.
     * @return 매치 UUID의 리스트를 반환합니다. 요청이 성공하면 리스트를, 실패하면 빈 리스트 또는 null을 반환할 수 있습니다.
     */
    public List<String> getMatchUUID(FifaInfoVO fifaInfoVO) {
        log.info("========================== 사용자 UUID 추출 시작 ==========================");
        URI matchUuid = setUrlBuilder("https://public.api.nexon.com",
                "/openapi/fconline/v1.0/users/{accessid}/matches",
                fifaInfoVO);

        RestTemplate uuidRestTemplate = new RestTemplate();

        //서버 요청
        HttpEntity request = requestMatch();


        //결과를 담을 값
        ResponseEntity<List> UID_response = uuidRestTemplate.exchange(
                matchUuid,
                HttpMethod.GET,
                request,
                List.class
        );

        log.info("========================== 사용자 UUID 추출 시작 ==========================");
        return UID_response.getBody();
    }



    /**
     * 매치 목록에 대한 상세 정보를 검색합니다.
     *
     * 이 메소드는 매치 UUID 목록을 받아 각 매치에 대한 상세 정보를 원격 API에 조회합니다.
     * 각 매치에 대해 URI를 구성하고, 원격 서버에 GET 요청을 보내고, 각 응답을 {@link MatchDTO} 객체 목록으로 수집합니다.
     *
     * @param matchUuidList 상세 정보를 검색할 매치 UUID(범용 고유 식별자) 목록.
     * @return 각 매치에 대한 상세 정보가 포함된 {@link MatchDTO} 객체 목록.
     * @throws RestClientException REST 요청 중 오류가 발생했을 경우 발생합니다.
     * @throws URISyntaxException URI 구성 중 오류가 발생했을 경우 발생합니다.
     */
    public List<MatchDTO> getMatchDetailInfo(List<String> matchUuidList) {
        log.info("========================== DetailInfo Start ==========================");

        List<MatchDTO> result = new ArrayList<>();

        for (String matchUuid : matchUuidList) {

            URI matchDetailInfo = UriComponentsBuilder
                    .fromUriString("https://public.api.nexon.com")
                    .path("/openapi/fconline/v1.0/matches/{matchid}")
                    .encode()
                    .build()
                    .expand(matchUuid)
                    .toUri();

            RestTemplate matchRestTemplate = new RestTemplate();
            //서버 요청
            HttpEntity request = requestMatch();

            //결과를 담을 값
            ResponseEntity<MatchDTO> responseMatchInfo = matchRestTemplate.exchange(
                    matchDetailInfo,
                    HttpMethod.GET,
                    request,
                    MatchDTO.class
            );

            result.add(responseMatchInfo.getBody());
        }
        log.info("========================== DetailInfo End ==========================");
        return result;
    }

    public HttpEntity requestMatch() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", FIFA_API_KEY);
        HttpEntity request = new HttpEntity(headers);
        return request;
    }

    public URI setUrlBuilder(String url, String path) {
        return UriComponentsBuilder
                .fromUriString(url)
                .path(path)
                .queryParam("nickname", "{nickname}")
                .encode()
                .build()
                .expand("은광산")
                .toUri();
    }

    public URI setUrlBuilder(String url, String path, FifaInfoVO fifaInfoVO) {
        return UriComponentsBuilder
                .fromUriString(url)
                .path(path)
                .queryParam("matchtype", 40)
                .queryParam("offset", 0)
                .queryParam("limit", 2)
                .encode()
                .build()
                .expand(fifaInfoVO.getAccessId())
                .toUri();
    }
}

