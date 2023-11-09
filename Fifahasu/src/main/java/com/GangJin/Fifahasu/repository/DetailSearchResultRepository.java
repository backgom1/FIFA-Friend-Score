package com.GangJin.Fifahasu.repository;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Repository
public class DetailSearchResultRepository {

    private final ISearchResultRepository searchResultRepository;


    @Transactional
    public void save(){
    }

}
