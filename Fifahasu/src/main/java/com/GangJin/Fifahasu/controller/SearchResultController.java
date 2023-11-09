package com.GangJin.Fifahasu.controller;

import com.GangJin.Fifahasu.service.ISearchResultService;
import com.GangJin.Fifahasu.util.IRecordSearchUtil;
import com.GangJin.Fifahasu.dto.MatchDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SearchResultController {

    private final ISearchResultService searchResultService;

    @GetMapping("/result")
    public ModelAndView resultV1() {
        return new ModelAndView("/views/searchResult/SearchResult");
    }


    @GetMapping("/v1/api/match-record")
    @ResponseStatus(HttpStatus.OK)
    public List<MatchDTO> getMatchRecord() {
        return searchResultService.findByMatchList();
    }

}
