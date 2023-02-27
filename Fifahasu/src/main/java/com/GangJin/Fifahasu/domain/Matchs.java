package com.GangJin.Fifahasu.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 경기 세부 정보 담는 테이블
 * 작성자 - 이은성
 * 2023-02-12 최종 수정
 */

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Matchs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Match_Code")
    private Long id;

    @Column
    private String matchId;

    @Column
    private int matchType;

    @JsonIgnore
    @OneToMany(mappedBy = "matchs",cascade = CascadeType.ALL)
    private List<MatchInfo> matchInfo = new ArrayList<>();

}
