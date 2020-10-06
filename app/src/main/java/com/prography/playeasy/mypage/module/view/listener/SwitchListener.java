package com.prography.playeasy.mypage.module.view.listener;

import android.content.Context;
import android.widget.CompoundButton;

import com.prography.playeasy.lib.SettingManager;

public class SwitchListener implements CompoundButton.OnCheckedChangeListener {

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Context context = buttonView.getContext();
        String switchKey = context.getResources()
                .getResourceName(buttonView.getId());

        SettingManager.set(context, switchKey, isChecked);

    }


}
