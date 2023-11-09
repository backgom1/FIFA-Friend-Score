package com.GangJin.Fifahasu.controller;

import com.GangJin.Fifahasu.service.IRecordSearchService;
import com.GangJin.Fifahasu.dto.MatchDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SearchResultController {

    private IRecordSearchService recordSearchService;

    @GetMapping("/result")
    public ModelAndView resultV1() {
        return new ModelAndView("/views/searchResult/SearchResult");
    }


    @GetMapping("/api/match-record")
    public ResponseEntity<MatchDTO> findByUserInfo() {
        recordSearchService.findRecordList();
        return null;
    }


    //검색 결과
//    @GetMapping("/find/{nickname}")
//    public ResponseEntity<MatchDTO> findByUserInfo(@ModelAttribute UserSearchResult form, @PathVariable("nickname") String nickname) throws ParseException, UserNotFoundException {
//        log.info("닉네임 확인 = {}", nickname);
//
//        //Exception
//        if (nickname.equals("은광산")) {
//            throw new UserNotFoundException("은광산 예외처리");
//        }
//
//        //Player
//        int level = fifaUserInfo.Info(form).getLevel();
//
//        MatchDTO matchDTO = new MatchDTO();
//
//        //Matchs
//        List<String> matchUID = fifaUserInfo.MatchUID(form);
//        for (String match : matchUID
//        ) {
//            matchDTO = fifaUserInfo.MatchVSInfo(form, match);
//            log.info("매치값={}", matchDTO);
//            //Model
//        }
//        return new ResponseEntity<>(matchDTO, HttpStatus.OK);
//    }
}
