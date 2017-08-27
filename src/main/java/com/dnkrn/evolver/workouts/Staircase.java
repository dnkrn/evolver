package com.dnkrn.evolver.workouts;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by dinakaran on 11/19/16.
 */
public class Staircase {

    public static void main(String[] args) {

        int n=6;

        List<String> stak=  new ArrayList<>();


        String val="";
        for (int i=1;i<=n;i++) {

            val +="#";
            stak.add(val);
           // System.out.println(val);

            System.out.println(getPattern(n,i,"#"));
        }

       

    }

    private static String getPattern(int total,int count,String pattern)
    {
        String finalPattern="";
        int space= total-count;
        while(total >= 1)
        {
            if(finalPattern.length()>=space)
            {
                finalPattern +=pattern;
            }
            else
            {
                finalPattern +=" ";
            }
            total--;
        }


        return finalPattern;
    }


}
