package com.pptb.eirene.mapit;

public class UserProfile {
    public String userEmail;
    public String userName;
    public String userBornWhere;
    public String userBornWhen;
    public String userAge;

    public UserProfile(){

    }

    public UserProfile(String userEmail, String userName, String userBornWhere, String userBornWhen, String userAge) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userBornWhere = userBornWhere;
        this.userBornWhen = userBornWhen;
        this.userAge = userAge;
    }

    public UserProfile(String userName, String userBornWhere, String userBornWhen, String userAge) {
        this.userName = userName;
        this.userBornWhere = userBornWhere;
        this.userBornWhen = userBornWhen;
        this.userAge = userAge;
    }

    public UserProfile(String userEmail, String userName) {
        this.userEmail = userEmail;
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserBornWhere() {
        return userBornWhere;
    }

    public void setUserBornWhere(String userBornWhere) {
        this.userBornWhere = userBornWhere;
    }

    public String getUserBornWhen() {
        return userBornWhen;
    }

    public void setUserBornWhen(String userBornWhen) {
        this.userBornWhen = userBornWhen;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }
}
