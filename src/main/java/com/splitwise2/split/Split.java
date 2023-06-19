package com.splitwise2.split;


import com.splitwise2.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Split {

    private User user;
    public double amount;

    public Split(User user) {
        this.user = user;
    }
}
