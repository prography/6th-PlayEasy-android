package com.prography.playeasy.team.domain;


import com.prography.playeasy.mypage.domain.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@ToString
@Accessors(fluent = true)
@NoArgsConstructor
public class ApplyUser {

   private Integer id;
   private String status;
   private Integer quota;
   private Integer matchId;
   private Integer userId;

   private User user;

   @Builder
   public ApplyUser(int id, String status, int quota, int matchId, int userId) {
       this.id = id;
       this.status = status;
       this.quota = quota;
       this.matchId = matchId;
       this.userId = userId;
   }
}
