package com.dnkrn.evolver.workouts;

import java.util.Scanner;

/**
 * Created by dinakaran on 8/18/17.
 */
public class MaxStocks {

    static long buyMaximumProducts(int n, long k, int[] a) {
        // Complete this function
        if (n != a.length) {
            return 0;
        }

        long totalStocks = 0;
        int days = 1;


        for (long stockPrice : a) {
            long totalStocksPrice=stockPrice*days;
            if(totalStocksPrice==0)
            {
                continue;
            }
            if(totalStocksPrice > k)
            {
                long canBuy=k/stockPrice;
                totalStocks+=canBuy;

            }
            else
            {
                k -= totalStocksPrice;
                totalStocks+=days;
                days++;
            }

        }


        return totalStocks;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        long k = in.nextLong();
        long result = buyMaximumProducts(n, k, arr);
        System.out.println(result);
        in.close();
    }
}
