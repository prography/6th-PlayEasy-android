package com.prography.playeasy.lib.firebase;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
import com.prography.playeasy.R;


public class FirebaseManager {
    private static final String TAG = "FIREBASE";

    private static String firebaseToken = "";

    public static void initialize(Context context, FirebaseTokenCallback callback) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create channel to show notifications.
            NotificationManager notificationManager =
                    context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(
                    new NotificationChannel(
                            context.getString(R.string.channel_id),
                            context.getString(R.string.channel_name),
                            NotificationManager.IMPORTANCE_LOW
                    )
            );
        }

        FirebaseMessaging.getInstance().setAutoInitEnabled(true);


        // 토큰이 등록되는 시점에 호출되는 메소드 입니다.
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        Log.d(TAG, "excuted?");
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "getInstanceId failed", task.getException());
                            return;

                            // 여기서 앱 강제 종료
                        }

                        // Get new Instance ID token
                        String token = task.getResult().getToken();
                        Log.d(TAG, "FIREBASE_TOKEN: " + token);

                        callback.onSuccess(token);

                        // Log and toast
//                        String msg = token;
//                        Log.d(TAG, msg);
//                        Toast.makeText(Main.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
    }


}
