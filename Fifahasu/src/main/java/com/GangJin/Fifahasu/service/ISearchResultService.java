package com.GangJin.Fifahasu.service;

import com.GangJin.Fifahasu.dto.MatchDTO;

import java.util.List;

public interface ISearchResultService {

    List<MatchDTO> findByMatchList();
}
