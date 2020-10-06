package com.prography.playeasy.lib;

import android.app.Activity;

import com.prography.playeasy.R;

import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class HorizontalCalendarManager {

    public static void initialize(Activity activity, HorizontalCalendarListener listener){
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH,-1);

        Calendar endDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH,1);

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(activity, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build();

        horizontalCalendar.setCalendarListener(listener);
    }
}
