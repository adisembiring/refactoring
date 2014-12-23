package com.refactoring.ch09.before;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Adi on 12/23/2014.
 */
public class SummerPrice {
    public static Date SUMMER_START = new Date();
    public static Date SUMMER_END = new Date();
    private double _winterRate;
    private double _summerRate;
    private double _winterServiceCharge;

    public SummerPrice() {

    }

    double getCharge(Date date, int quantity) {
        double charge;
        if (date.before (SUMMER_START) || date.after(SUMMER_END))
            charge = quantity * _winterRate + _winterServiceCharge;
        else charge = quantity * _summerRate;

        return charge;
    }


}
