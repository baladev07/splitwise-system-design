package com.splitwise2.split;


import com.splitwise2.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EqualSplit extends Split {
    public EqualSplit(User user) {
        super(user);
    }



}
