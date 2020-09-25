package com.prography.playeasy.match.domain.dtos.response;

import com.google.gson.annotations.SerializedName;
import com.prography.playeasy.match.domain.models.Application;

import java.util.Date;

public class MatchApplySoloPostResponseDto {
    @SerializedName("application")
    Application application;

    public Application getApplication(){
        return application;
    }
}
