package com.Group6.BackendApiProgress.user;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userType;


    public User(int userId, String userName, String userType){
        this.userId = userId;
        this.userName = userName;
        this.userType = userType;
    }

    public User(String userName, String userType){
        this.userName = userName;
        this.userType = userType;
    }

    public User(){

    }

    public int getUserId(){return userId;}

    public void setUserId(int userId){this.userId=userId;}

    public String getUserName(){return userName;}

    public void setUserName(String userName){this.userName = userName;}

    public String getUserType(){return userType;}

    public void setUserType(String userType){this.userType=userType;}

}
