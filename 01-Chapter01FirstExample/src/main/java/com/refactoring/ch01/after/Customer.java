package com.refactoring.ch01.after;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by Adi on 12/21/2014.
 */
public class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(each.getCharge()) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalAmount()) +
                "\n";
        result += "You earned " + String.valueOf(getFrequentPoints())
                +
                " frequent renter points";
        return result;
    }

    private double getTotalAmount() {
        return _rentals
                .stream()
                .mapToDouble(Rental::getCharge)
                .sum();
    }

    private double getFrequentPoints() {
        return _rentals
                .stream()
                .mapToDouble(Rental::getFrequentRenterPoints)
                .sum();
    }
}
