package com.dnkrn.evolver.workouts;

/**
 * Created by dinakaran on 8/3/16.
 */
public class Fibonacci {

    public static void main(String[] args) {

        System.out.println("iterate");
        itertaiveFib(6);

        System.out.println("recurse");
        //finds sixth element
        System.out.println(fibCalculate(6));
    }

    private static void itertaiveFib(int seq)
    {


        int counter=0;


        int lastValue=1;

        int newValue=1;


        int previousValue=1;

        while(counter <= seq)
        {
            if(counter <= 1 )
            {
                System.out.println(1);

            }
            else
            {
                lastValue= newValue + previousValue;
                previousValue=newValue;
                newValue=lastValue;

                System.out.println(lastValue);

            }
            counter++;
        }
    }
    private static int fibCalculate(int n)
    {
        if(n == 0){
            return 0;
        }

        else if(n == 1){
            return 1;
        }

        else {
            return fibCalculate(n - 1) + fibCalculate(n - 2);
        }
    }
}