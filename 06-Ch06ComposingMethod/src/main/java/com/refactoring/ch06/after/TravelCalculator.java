package com.refactoring.ch06.after;

/**
 * Created by Adi on 12/22/2014.
 */
public class TravelCalculator {
    private double _primaryForce;
    private double _mass;
    int _delay;
    private double _secondaryForce;

    double getDistanceTravelled (int time) {
        final double result = calculateFirstDistance(time);
        if (getSecondaryTime(time) > 0) {
            return result + calculateSecondDistance(time);
        }
        return result;
    }

    private double calculateFirstDistance(int time) {
        final int primaryTime = Math.min(time, _delay);
        return 0.5 * primaryAcc() * primaryTime * primaryTime;
    }

    private double primaryAcc() {
        return _primaryForce / _mass;
    }

    private int getSecondaryTime(int time) {
        return time - _delay;
    }

    private double calculateSecondDistance(int time) {
        final int secondaryTime = getSecondaryTime(time);
        double primaryVel = primaryAcc() * _delay;
        return primaryVel * secondaryTime + 0.5 * secondaryAcc() *
                secondaryTime * secondaryTime;
    }

    private double secondaryAcc() {
        return (_primaryForce + _secondaryForce) / _mass;
    }
}
