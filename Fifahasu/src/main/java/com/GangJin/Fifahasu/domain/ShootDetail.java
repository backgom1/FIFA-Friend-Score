package com.GangJin.Fifahasu.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter

@Table(name = "shootdetail")
public class ShootDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Shootdetail_Code")
    private Long id;

    @Column
    private int goalTime; //슛 시간

    @Column
    private double x; // 슛 x좌표 (전체 경기장 기준)

    @Column
    private double y; //슛 y좌표 (전체 경기장 기준)

    @Column
    private int type; //슛 종류1: normal 2: finesse 3: header 4: lob (로빙슛)5: flare (플레어슛) 6: low (낮은 슛) 7: volley (발리)8: free-kick (프리킥) 9: penalty (페널티킥10: KNUCKLE (무회전슛))

    @Column
    private int result;    //	슛 결과 (1 : ontarget , 2 : offtarget , 3 : goal)

    @Column
    private int spId;    //슈팅 선수 고유 식별자 (/metadata/spid API 참고)

    @Column
    private int spGrade; //	슈팅 선수 강화 등급

    @Column
    private int spLevel;    //슈팅 선수 레벨

    @Column
    private boolean spIdType; //	슈팅 선수 임대 여부 (임대선수 : true, 비임대선수 : false)

    @Column
    private boolean assist;    //	어시스트 받은 골 여부. (받음 : true, 안받음 : false)

    @Column
    private int assistSpId;    // 어시스트 선수 고유 식별자 (/metadata/spid API 참고)

    @Column
    private double assistX;     //		어시스트 x좌표

    @Column
    private double assistY;    //	어시스트 y좌표

    @Column
    private boolean hitPost;    //	골포스트 맞춤 여부. (맞춤 : true, 못 맞춤 : false)

    @Column
    private boolean inPenalty;    //	페널티박스 안에서 넣은 슛 여부 (안 : true, 밖 : false)

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Match_id")
    private MatchInfo matchInfo;
}
