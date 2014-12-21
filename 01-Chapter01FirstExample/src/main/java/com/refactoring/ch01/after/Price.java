package com.refactoring.ch01.after;

/**
 * Created by Adi on 12/21/2014.
 */
public abstract class Price {
    abstract int getPriceCode();
    abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented){
        return 1;
    }
}
