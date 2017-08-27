package com.dnkrn.evolver.workouts;

/**
 * Created by dinakaran on 8/27/17.
 */
public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(10));
    }

    private static int factorial(int n)
    {
        if(n == 1)
        {
            //System.out.println("1");
            return 1;
        }
        return n * factorial(n-1);
    }
}
