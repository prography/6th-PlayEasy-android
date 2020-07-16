package com.prography.playeasy.mypage.service;

import com.prography.playeasy.lib.RetrofitClientFactory;
import com.prography.playeasy.mypage.api.RetrofitMyMatchRegisterApi;
import com.prography.playeasy.team.api.RetrofitTeamApi;

public class UserApiService {





    private static final String TAG = "TEAM_SERVICE";
    private RetrofitMyMatchRegisterApi userClient;

    public UserApiService(){


        this.userClient = RetrofitClientFactory.getClient(RetrofitMyMatchRegisterApi.class);
    }




}
