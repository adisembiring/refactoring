package com.refactoring.ch09.after;

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
        return notSummer(date) ? winterCharge(quantity) : summerCharge(quantity);
    }

    private double summerCharge(int quantity) {
        double charge;
        charge = quantity * _summerRate;
        return charge;
    }

    private double winterCharge(int quantity) {
        return quantity * _winterRate + _winterServiceCharge;
    }

    private boolean notSummer(Date date) {
        return date.before (SUMMER_START) || date.after(SUMMER_END);
    }
}
