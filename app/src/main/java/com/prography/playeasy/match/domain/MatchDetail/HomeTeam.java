package com.prography.playeasy.match.domain.MatchDetail;

import java.util.Date;

public class HomeTeam {
    int id;
    String name;
    String description;
    enum level{HIGH,MEDIUM,LOW};
    String leader;
    //phone Null가능하고
    String phone;
    Date createdAt;
    Date updatedAt;


}
