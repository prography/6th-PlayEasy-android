package com.prography.playeasy.login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
import com.kakao.usermgmt.callback.UnLinkResponseCallback;
import com.kakao.util.exception.KakaoException;
import com.prography.playeasy.R;
import com.prography.playeasy.application.PlayeasyApplication;
import com.prography.playeasy.login.service.LoginService;
import com.prography.playeasy.util.PlayeasyServiceFactory;

public class LoginActivity extends AppCompatActivity{

    private Button logout;
    private Button sessionCutt;
    private String accessToken;
    private LoginService loginService;

    // 세션 콜백 구현
    private ISessionCallback sessionCallback = new ISessionCallback() {
        @Override
        public void onSessionOpened() {
            Log.i("KAKAO_SESSION", "로그인 성공");
            AuthService.getInstance()
                    .requestAccessTokenInfo(new ApiResponseCallback<AccessTokenInfoResponse>() {
                        @Override
                        public void onSessionClosed(ErrorResult errorResult) {
                            Toast.makeText(getApplicationContext(),"세션 닫힘",Toast.LENGTH_LONG).show();
                            Log.e("KAKAO_API", "세션이 닫혀 있음: " + errorResult);
                        }

                        @Override
                        public void onFailure(ErrorResult errorResult) {
                            Toast.makeText(getApplicationContext(),"토큰 정보 요청 실패",Toast.LENGTH_LONG).show();
                            Log.e("KAKAO_API", "토큰 정보 요청 실패: " + errorResult);
                        }

                        @Override
                        public void onSuccess(AccessTokenInfoResponse result) {
                            Log.d("KAKAO_API", "사용자 아이디: " + result.getUserId());
                            Log.d("KAKAO_API", "남은 시간 (ms): " + result.getExpiresInMillis());
                            accessToken = Session.getCurrentSession().getAccessToken();
                            Log.d("KAKAO_ACCESS_TOKEN", accessToken);

                            Toast.makeText(getApplicationContext(),"로그인 성공",Toast.LENGTH_LONG).show();
                            loginService.userLogin(accessToken, getApplicationContext());
                        }
                    });
        }

        @Override
        public void onSessionOpenFailed(KakaoException exception) {
            Toast.makeText(getApplicationContext(),"로그인 실패",Toast.LENGTH_LONG).show();
            Log.e("KAKAO_SESSION", "로그인 실패", exception);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginService = PlayeasyServiceFactory.getInstance(LoginService.class);

        // 세션 콜백 등록
        Session.getCurrentSession().addCallback(sessionCallback);

        logout = findViewById(R.id.button);
        logout.setOnClickListener(new View.OnClickListener() {
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

        sessionCutt = findViewById(R.id.button2);
        sessionCutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserManagement.getInstance()
                        .requestUnlink(new UnLinkResponseCallback() {
                            @Override
                            public void onSessionClosed(ErrorResult errorResult) {
                                Log.e("KAKAO_API", "세션이 닫혀 있음: " + errorResult);
                            }

                            @Override
                            public void onFailure(ErrorResult errorResult) {
                                Log.e("KAKAO_API", "연결 끊기 실패: " + errorResult);

                            }
                            @Override
                            public void onSuccess(Long result) {
                                Log.i("KAKAO_API", "연결 끊기 성공. id: " + result);
                            }
                        });

            }
        });



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
