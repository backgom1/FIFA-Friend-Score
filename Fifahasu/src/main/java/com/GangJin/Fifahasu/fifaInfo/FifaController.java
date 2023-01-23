package com.GangJin.Fifahasu.fifaInfo;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequiredArgsConstructor
public class FifaController {

    private final fifaInfo fifaInfo;

    @GetMapping("/api/test")
    public String Info(Model model){
        model.addAttribute("UserInfo",fifaInfo.Info());
        return fifaInfo.Info();
    }
}
