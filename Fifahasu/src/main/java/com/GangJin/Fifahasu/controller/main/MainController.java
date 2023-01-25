package com.GangJin.Fifahasu.controller.main;

import com.GangJin.Fifahasu.service.fifaInfo.FIFAUserInfo;
import com.GangJin.Fifahasu.service.fifaInfo.fifaInfoVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MainController {

    private final FIFAUserInfo fifaUserInfo;

    @GetMapping
    public String Main(@ModelAttribute MainSearchForm form) {
        return "/views/main/main";
    }

    @GetMapping("/do")
    public String Search(Model model, @ModelAttribute MainSearchForm form) {
        String nickname = fifaUserInfo.Info(form).getNickname();
        int level = fifaUserInfo.Info(form).getLevel();
        model.addAttribute("userNickName",nickname);
        model.addAttribute("userLevel",level);
        return "/views/search/search";
    }
}
