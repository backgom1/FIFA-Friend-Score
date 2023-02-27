package com.GangJin.Fifahasu.domain;

import com.GangJin.Fifahasu.service.matchInfo.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter

@Table(name = "matchinfo")
public class MatchInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Matchinfo_Code")
    private Long id;

    @Column
    private String accessId;

    @Column
    private String nickname;

    @JsonIgnore
    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "matchdetail_code")
    private MatchDetail matchDetail;

    @JsonIgnore
    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "shoot_code")
    private Shoot shoot;

    @JsonIgnore
    @OneToMany(mappedBy = "matchInfo", cascade = CascadeType.ALL)
    private List<ShootDetail> shootDetail = new ArrayList<>();

    @JsonIgnore
    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "pass_code")
    private Pass pass;

    @JsonIgnore
    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "defence_code")
    private Defence defence;

    @JsonIgnore
    @OneToMany(mappedBy = "matchInfo", cascade = CascadeType.ALL)
    private List<Player> player = new ArrayList<>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Match_Code")
    private Matchs matchs;


}
