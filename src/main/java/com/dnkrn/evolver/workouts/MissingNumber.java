package com.dnkrn.evolver.workouts;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by dinakaran on 8/22/17.
 */
public class MissingNumber {


    static String findNumber(int[] arr, int k) {

        Arrays.sort(arr);

        for(int num:arr)
        {
            System.out.println(num + "---");
            if(num == k)
            {
                return "YES";
            }
        }
        System.out.println(arr);

        return "NO";
    }

    static int[] oddNumbers(int l, int r) {
        if(l>r)
        {
            int temp=l;
            l=r;
            r=temp;

        }
        int[] oddNum=new int[(r-l)/2+1];

        for(int i=l,j=0;i<=r;i++)
        {
            if(i%2 !=0)
            {
                oddNum[j]=i;
                System.out.println(i);
                j++;
            }

        }

        return oddNum;

    }

    public static void main(String[] args) throws Exception {
       int[] _arr= new int[]{1,2,3,6,9,5};

       // System.out.println(findNumber(_arr, 6));

        System.out.println(oddNumbers(2,5));

    }

}
