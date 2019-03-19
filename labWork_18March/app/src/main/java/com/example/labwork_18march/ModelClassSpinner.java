package com.example.labwork_18march;

import java.util.ArrayList;
import java.util.List;

public class ModelClassSpinner {

    public List<String> getItemName(String itemName){
        List<String> listholder = new ArrayList<>();

        if(itemName.equals("Dial Call")){
            listholder.add("dial1");
            listholder.add("dial2");
        }
        else if(itemName.equals("send msg")){
            listholder.add("texting msg1");
            listholder.add("texting msg2");
        }

        return listholder;
    }
}
