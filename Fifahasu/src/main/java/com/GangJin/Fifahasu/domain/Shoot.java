package com.GangJin.Fifahasu.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Shoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Shoot_Code")
    private Long id;
    @Column
    private int shootTotal;    //총 슛 수

    @Column
    private int effectiveShootTotal;    //총 유효슛 수

    @Column
    private int shootOutScore;    //승부차기 슛 수

    @Column
    private int goalTotal;    //총 골 수 (실제 골 수) goalInPenalty+goalOutPenalty+goalPenaltyKick

    @Column
    private int goalTotalDisplay;    //게임 종료 후 유저에게 노출되는 골 수

    @Column
    private int ownGoal; //자책 골 수

    @Column
    private int shootHeading;    //헤딩 슛 수

    @Column
    private int goalHeading;    //헤딩 골 수

    @Column
    private int shootFreekick;    //프리킥 슛 수

    @Column
    private int goalFreekick;    //프리킥 골 수

    @Column
    private int shootInPenalty;    //인패널티 슛 수

    @Column
    private int goalInPenalty;    //인패널티 골 수

    @Column
    private int shootOutPenalty;    //아웃패널티 슛 수

    @Column
    private int goalOutPenalty;    //아웃패널티 골 수

    @Column
    private int shootPenaltyKick;    //패널티킥 슛 수

    @Column
    private int goalPenaltyKick;    //패널티킥 골 수


    @OneToOne(mappedBy = "shoot" , fetch = FetchType.LAZY)
    private MatchInfo matchInfo;
}
