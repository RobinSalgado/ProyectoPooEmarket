package util;

import java.util.Random;

public abstract class genID {
    public String genID(String Type){
        Random r = new Random();
        long num = r.nextLong();
        return Type +  " - " + num;
    }
}
