package com.GangJin.Fifahasu.domain;


import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
public class Pass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Pass_Code")
    private Long id;


    @Column
    private int passTry;    //	패스 시도 수

    @Column
    private int passSuccess;    //	패스 성공 수

    @Column
    private int shortPassTry;//		숏 패스 시도 수

    @Column
    private int shortPassSuccess;    //	숏 패스 성공 수

    @Column
    private int longPassTry;    //	롱 패스 시도 수

    @Column
    private int longPassSuccess;    //	롱 패스 성공 수

    @Column
    private int bouncingLobPassTry;    //바운싱 롭 패스 시도 수

    @Column
    private int bouncingLobPassSuccess;//	바운싱 롭 패스 성공 수

    @Column
    private int drivenGroundPassTry;    //드리븐 땅볼 패스 시도 수

    @Column
    private int drivenGroundPassSuccess;    //	드리븐 땅볼 패스 성공 수

    @Column
    private int throughPassTry;    //	스루 패스 시도 수

    @Column
    private int throughPassSuccess;//	스루 패스 성공 수

    @Column
    private int lobbedThroughPassTry;    //	로빙 스루 패스 시도 수

    @Column
    private int lobbedThroughPassSuccess;    //	로빙 스루 패스 성공 수

    @OneToOne(mappedBy = "pass", fetch = FetchType.LAZY)
    private MatchInfo matchInfo;
}
