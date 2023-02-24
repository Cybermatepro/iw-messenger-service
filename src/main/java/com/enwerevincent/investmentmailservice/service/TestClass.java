package com.enwerevincent.investmentmailservice.service;

import org.apache.commons.lang.RandomStringUtils;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

public class TestClass {
    public static void main(String[] args) {

        Date date = new Date();

//        Calendar calendar = Calendar.getInstance();
//        Calendar calendar1 = Calendar.getInstance();
//        var c = calendar.getTime();
//         calendar1.set(2022 , 12, 23, 34 , 23);
//        System.out.println();
//        System.out.println( calendar1.getTime().getTime() - c.getTime());
        var c = LocalDateTime.now();
        var d = LocalDateTime.of(2022, Month.DECEMBER , 2 , 17 , 01 , 00).plusMinutes(5);

        System.out.println(LocalDateTime.now().isAfter(d));
        System.out.println(RandomStringUtils.randomAlphanumeric(65));
    }
}
