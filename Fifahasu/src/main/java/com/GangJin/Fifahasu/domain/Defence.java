package com.GangJin.Fifahasu.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Defence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Defence_Code")
    private Long id;

    @Column
    private int blockTry;    //	블락 시도 수

    @Column
    private int blockSuccess;    //	블락 성공 수

    @Column
    private int tackleTry;    //태클 시도 수

    @Column
    private int tackleSuccess;    //	태클 성공 수

    @OneToOne(mappedBy = "defence", fetch = FetchType.LAZY)
    private MatchInfo matchInfo;
}
