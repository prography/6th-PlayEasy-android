package com.prography.playeasy.mypage.domain;

public class MyMatchVO {
    private String myMatchName;
    private String myMatchLocation;
    private int myMatchPeople;

    public MyMatchVO(String myMatchName, String myMatchLocation, int myMatchPeople) {
        this.myMatchName = myMatchName;
        this.myMatchLocation = myMatchLocation;
        this.myMatchPeople = myMatchPeople;
    }

    public String getMyMatchName() {

        return myMatchName;
    }

    public void setMyMatchName(String myMatchName) {

        this.myMatchName = myMatchName;
    }

    public String getMyMatchLocation() {

        return myMatchLocation;
    }

    public void setMyMatchLocation(String myMatchLocation) {
        this.myMatchLocation = myMatchLocation;
    }

    public int getMyMatchPeople() {
        return myMatchPeople;
    }

    public void setMyMatchPeople(int myMatchPeople) {
        this.myMatchPeople = myMatchPeople;
    }

    @Override
    public String toString() {
        return "MyMatchVO{" +
                "myMatchName='" + myMatchName + '\'' +
                ", myMatchLocation='" + myMatchLocation + '\'' +
                ", myMatchPeople=" + myMatchPeople +
                '}';
    }

}
