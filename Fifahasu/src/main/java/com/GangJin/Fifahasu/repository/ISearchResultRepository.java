package com.GangJin.Fifahasu.repository;

import com.GangJin.Fifahasu.domain.MatchInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISearchResultRepository extends JpaRepository<MatchInfo,Long> {
}
