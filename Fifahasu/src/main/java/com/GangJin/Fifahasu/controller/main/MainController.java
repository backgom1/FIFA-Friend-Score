package com.GangJin.Fifahasu.controller.main;

import com.GangJin.Fifahasu.service.fifaInfo.FIFAUserInfo;
import com.GangJin.Fifahasu.service.matchInfo.MatchDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MainController {

    private final FIFAUserInfo fifaUserInfo;

    @GetMapping
    public ModelAndView Main() {
        return new ModelAndView("/views/main/main");
    }

    @GetMapping("/good/{nickname}")
    public ModelAndView result(@PathVariable("nickname") String nickname) {
        ModelAndView mav = new ModelAndView("/views/exception/SearchException");
        mav.addObject("nickname",nickname);
        return mav;
    }

    //검색 결과
    @GetMapping("/find/{nickname}")
    public ResponseEntity<MatchDTO> findByUserInfo(@ModelAttribute MainSearchForm form, @PathVariable("nickname") String nickname) throws ParseException {
        log.info("닉네임 확인 = {}", nickname);

        //Exception

        //Player
        int level = fifaUserInfo.Info(form).getLevel();

        MatchDTO matchDTO = new MatchDTO();

        //Matchs
        List<String> matchUID = fifaUserInfo.MatchUID(form);
        for (String match : matchUID
        ) {
            matchDTO = fifaUserInfo.MatchVSInfo(form, match);
            log.info("매치값={}", matchDTO);
            //Model
        }
        return new ResponseEntity<>(matchDTO, HttpStatus.OK);
    }
}
