package com.GangJin.Fifahasu.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Status_Code")
    private Long id;

    @Column
    private int shoot;    // 슛 수

    @Column
    private int effectiveShoot;//		유효 슛 수

    @Column
    private int assist;//	어시스트 수

    @Column
    private int goal;    //	득점 수

    @Column
    private int dribble;    //드리블 거리(야드)

    @Column
    private int intercept;//		인터셉트 수

    @Column
    private int defending;//		디펜딩 수

    @Column
    private int passTry;    //	패스 시도 수

    @Column
    private int passSuccess;//		패스 성공 수

    @Column
    private int dribbleTry;//		드리블 시도 수

    @Column
    private int dribbleSuccess;//		드리블 성공 수

    @Column
    private int ballPossesionTry;//	볼 소유 시도 수

    @Column
    private int ballPossesionSuccess;//	볼 소유 성공 수

    @Column
    private int aerialTry;//	공중볼 경합 시도 수

    @Column
    private int aerialSuccess;    //	공중볼 경합 성공 수

    @Column
    private int blockTry;    //	블락 시도 수

    @Column
    private int block;    //	블락 성공 수

    @Column
    private int tackleTry;    //	태클 시도 수

    @Column
    private int tackle;    //	태클 성공 수

    @Column
    private int yellowCards;    //	옐로카드 수

    @Column
    private int redCards;//		레드카드 수

    @Column
    private float spRating;    //	선수 평점

    @OneToOne(mappedBy = "status", fetch = FetchType.LAZY)
    private Player player;
}


