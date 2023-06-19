package com.splitwise2;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {


    private String name;

    private String userId;

    private String email;

    private int mobileNumber;

    public User(String name, String userId, String email, int mobileNumber) {
        this.name = name;
        this.userId = userId;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

}
