package com.splitwise2.split;


import com.splitwise2.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExactSplit extends Split {

    public ExactSplit(User user, double amount) {
        super(user);
        this.amount = amount;

    }

}
