package com.refactoring.ch01.after;

/**
 * Created by Adi on 12/21/2014.
 */
public class ChildrensPrice extends Price {

    @Override
    int getPriceCode() {
        return Movie.CHILDRENS;
    }

    @Override
    double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5;
        return result;
    }
}
