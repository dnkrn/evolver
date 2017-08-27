package com.dnkrn.evolver.workouts;

/**
 * Created by dinakaran on 8/22/17.
 */
public class DistanceImplementation extends Distance  implements Comparable<Distance>{

    @Override
    public void setFeetAndInches(int feet, float inches) {
        this.inches = inches;
        this.feet = feet;
    }

    @Override
    public int getFeet() {
        return this.feet;
    }

    @Override
    public float getInches() {
        return this.inches;
    }

    @Override
    String getDistanceComparison(Distance dist2) {
        int comparison = this.compareTo(dist2);
        if (comparison == 0) {
            return "Both distances are equal.";
        } else if (comparison == 1) {
            return "First distance is greater.";
        } else {
            return "Second distance is greater.";
        }
    }


    float getTotalDistance(int feet, float inches) {
        int feetInInch = feet * 12;
       // System.out.println(feetInInch + inches);
        return feetInInch + inches;
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }


    public int compareTo(Distance dist) {
        if (this.getTotalDistance(this.getFeet(), this.getInches()) == getTotalDistance(dist.getFeet(), dist.getInches())) {
            return 0;
        } else if (this.getTotalDistance(this.getFeet(), this.getInches()) < getTotalDistance(dist.getFeet(), dist.getInches())) {
            return -1;

        }
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && this.getClass() == obj.getClass() && this.getFeet() == ((DistanceImplementation) obj).getFeet()
                && this.getInches() == ((DistanceImplementation) obj).getInches();
    }


}
