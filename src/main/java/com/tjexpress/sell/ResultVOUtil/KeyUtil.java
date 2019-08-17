package com.tjexpress.sell.ResultVOUtil;

import java.util.Random;

public class KeyUtil {


    public static synchronized String genUniquekey(){
        Random random = new Random();
        Integer number = random.nextInt();
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
