package com.idk.covid19.model.weekly;

import java.text.SimpleDateFormat;
import java.util.Date;

class Scratch {

    public static void main(String[] args) {

        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");
        System.out.println(simpleDateformat.format(new Date()));
    }
}