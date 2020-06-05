package com.prography.playeasy.login.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kakao.auth.ApiResponseCallback;
import com.kakao.auth.AuthService;
import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.auth.network.response.AccessTokenInfoResponse;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;
import com.kakao.util.exception.KakaoException;
import com.prography.playeasy.R;
import com.prography.playeasy.login.service.LoginService;
import com.prography.playeasy.util.playeasyServiceManager.PlayeasyServiceManager;

public class LoginActivity extends AppCompatActivity{

    private static final String TAG = "";
    private Button button;
    private String accessToken;
<<<<<<< HEAD
    private LoginService loginService = new LoginService();
    private Context context;
=======
    private LoginService loginService;

>>>>>>> ee53814470ec2d038deec17116fcfd84bf1f9867
    // 세션 콜백 구현
    private ISessionCallback sessionCallback = new ISessionCallback() {
        @Override
        public void onSessionOpened() {
            Log.i("KAKAO_SESSION", "로그인 성공");
            AuthService.getInstance()
                    .requestAccessTokenInfo(new ApiResponseCallback<AccessTokenInfoResponse>() {
                        @Override
                        public void onSessionClosed(ErrorResult errorResult) {
                            Log.e("KAKAO_API", "세션이 닫혀 있음: " + errorResult);
                        }

                        @Override
                        public void onFailure(ErrorResult errorResult) {
                            Log.e("KAKAO_API", "토큰 정보 요청 실패: " + errorResult);
                        }

                        @Override
                        public void onSuccess(AccessTokenInfoResponse result) {
                            Log.d("KAKAO_API", "사용자 아이디: " + result.getUserId());
                            Log.d("KAKAO_API", "남은 시간 (ms): " + result.getExpiresInMillis());
                            accessToken = Session.getCurrentSession().getAccessToken();
                            Log.d("KAKAO_ACCESS_TOKEN", accessToken);

                            loginService.userLogin(accessToken, getApplicationContext());
                        }
                    });
        }

        @Override
        public void onSessionOpenFailed(KakaoException exception) {
            Log.e("KAKAO_SESSION", "로그인 실패", exception);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginService = PlayeasyServiceManager.getInstance(LoginService.class);

        // 세션 콜백 등록
        Session.getCurrentSession().addCallback(sessionCallback);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserManagement.getInstance()
                        .requestLogout(new LogoutResponseCallback() {
                            @Override
                            public void onCompleteLogout() {
                                Log.i("KAKAO_API", "로그아웃 완료");
                            }
                        });

                loginService.userLogout(v.getContext());
            }
        });

    //    context=this.getActivity();



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 세션 콜백 삭제
        Session.getCurrentSession().removeCallback(sessionCallback);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        // 카카오톡|스토리 간편로그인 실행 결과를 받아서 SDK로 전달
        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            return;
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
