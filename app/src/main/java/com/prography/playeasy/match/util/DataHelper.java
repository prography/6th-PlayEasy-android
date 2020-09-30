package com.prography.playeasy.match.util;



public class DataHelper {

    public static String transformDateToString(String date) {
        return date.split("T")[0];

    }

    public static String makeEndTime(String createdDate, int duration) {

        int endingHour=0;
        String tempEndDate="";
        if (duration % 60 == 0) {
            endingHour = Integer.parseInt(createdDate.split("T")[1].substring(0, 2)) + duration/60;
//        tempEndDate=createdDate.split("T")[0]+Integer.toString(startHour)+createdDate.split("T")[1].substring(2);
            tempEndDate=createdDate.split("T")[1].substring(0,5)+"~"+endingHour+":00";
            return tempEndDate;
        } else {
            endingHour=Integer.parseInt(createdDate.split("T")[1].substring(0, 2))+duration/60;
            tempEndDate = createdDate.split("T")[1].substring(0,5)+"~"+endingHour+":"+duration%60;
            return tempEndDate;
        }
    }
}
