package com.GangJin.Fifahasu.controller.main;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class FifaApiController {


    @GetMapping
    public String test(){
        return "test";
    }
}
