package com.dnkrn.evolver.workouts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dinakaran on 8/5/16.
 */
public class Prime {

    private static List<Integer> listPrimes = new ArrayList<>();

    public static void main(String[] args) {

        //2,3,5,7,11

        int primeCount = 5;

        int primeToFind = 1000;

        listPrimes.add(2);
        listPrimes.add(3);
        listPrimes.add(5);
        listPrimes.add(7);
        listPrimes.add(11);

        int foundNumber=nthPrime(13, primeCount, primeToFind);

        System.out.println(foundNumber);


    }


    public static boolean isPrime(int n) {
        for (int prime : listPrimes) {
            if (n % prime == 0) {
                return false;
            }

           // System.out.println(listPrimes);

        }


        return true;
    }

    public static int nthPrime(int n, int primeCount, int primeToFind) {
        System.out.println("prime to find" + n + " prime count" + primeCount);

        if (primeCount ==primeToFind) {
            return n - 2;
        }

        if (isPrime(n)) {

            primeCount = primeCount + 1;
            listPrimes.add(n);
            System.out.println("number-->" + n + " primeCount-->" + primeCount);
        }

        return nthPrime(n + 2, primeCount, primeToFind);

    }


}
