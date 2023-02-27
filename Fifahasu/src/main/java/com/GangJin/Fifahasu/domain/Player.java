package com.GangJin.Fifahasu.domain;

import com.GangJin.Fifahasu.service.matchInfo.StatusDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

/**
 * 피파 API 계정의 내용을 저장하는 값
 * 작성자 - 이은성
 * 2023-02-12 최종 수정
 */
@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Player_Code")
    private Long id;

    @Column
    private int spId;    //	선수 고유 식별자 (/metadata/spid API 참고)

    @Column
    private int spPosition;    // 	선수 포지션 (/metadata/spposition API 참고)

    @Column
    private int spGrade;//	선수 강화 등급


    @JsonIgnore
    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private Status status;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Matchinfo_Code")
    private MatchInfo matchInfo;


}
