package com.refactoring.ch01.after;

/**
 * Created by Adi on 12/21/2014.
 */
public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private final String _title;
    private Price _price;

    public Movie(String title, int priceCode) {
        _title = title;
        setPriceCode(priceCode);
    }

    private void setPriceCode(int priceCode) {
        switch (priceCode) {
            case REGULAR:
                _price = new RegularPrice();
                break;
            case CHILDRENS:
                _price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public int getPriceCode() {
        return _price.getPriceCode();
    }

    public String getTitle() {
        return _title;
    }

    public double getCharge(int daysRented) {
        return _price.getCharge(daysRented);
    }

    public double getFrequentPoint(int daysRented) {
        return _price.getCharge(daysRented);
    }
}
