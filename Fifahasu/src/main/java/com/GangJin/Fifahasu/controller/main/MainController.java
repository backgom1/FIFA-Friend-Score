package com.GangJin.Fifahasu.controller.main;

import com.GangJin.Fifahasu.service.fifaInfo.FIFAUserInfo;
import com.GangJin.Fifahasu.service.fifaInfo.fifaInfoVO;
import com.GangJin.Fifahasu.service.matchInfo.MatchDTO;
import com.GangJin.Fifahasu.service.matchInfo.UserSIDMatchDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MainController {

    private final FIFAUserInfo fifaUserInfo;

    @GetMapping
    public String Main(@ModelAttribute MainSearchForm form) {
        return "/views/main/main";
    }

    //검색 결과
    @GetMapping("/find/{nickname}")
    public String Search(Model model, @ModelAttribute MainSearchForm form,@PathVariable("nickname") String nickname) {
        //Exception

        //User
        int level = fifaUserInfo.Info(form).getLevel();

        //Match
        String matchUID = fifaUserInfo.MatchUID(form);

        MatchDTO matchDTO = fifaUserInfo.MatchVSInfo(form);

        log.info("매치값={}",matchDTO);
        //Model
        model.addAttribute("userNickName",nickname);
        model.addAttribute("userLevel",level);
        return "/views/search/search";
    }
}
