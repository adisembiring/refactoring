package com.refactoring.ch01.after;

/**
 * Created by Adi on 12/21/2014.
 */
public class Rental {
    private final Movie _movie;
    private final int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public double getCharge() {
        return _movie.getCharge(_daysRented);
    }

    public double getFrequentRenterPoints() {
        return _movie.getFrequentPoint(_daysRented);
    }
}
