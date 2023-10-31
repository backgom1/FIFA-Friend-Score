package com.GangJin.Fifahasu.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter

@Table(name = "matchdetail")
public class MatchDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Matchdetail_Code")
    private Long id;

    @Column
    private int seasonId;

    @Column
    private String matchResult;

    @Column
    private int matchEndType;

    @Column
    private int systemPause;

    @Column
    private int foul;

    @Column
    private int injury;

    @Column
    private int redCards;

    @Column
    private int yellowCards;

    @Column
    private int dribble;

    @Column
    private int cornerKick;

    @Column
    private int possession;

    @Column
    private int OffsideCount;

    @Column
    private double averageRating;

    @Column
    private String controller; // 사용한 컨트롤러 타입 (keyboard / pad / etc )

    @OneToOne(mappedBy = "matchDetail", fetch = FetchType.LAZY)
    private MatchInfo matchInfo;
}
