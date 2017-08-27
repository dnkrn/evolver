package com.dnkrn.evolver.workouts;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dinakaran on 5/9/17.
 */
public class unique {

    public static void main(String[] args) {
        String toVerify="vijaysar";
        System.out.println("Duplicate Char found with data struct-->" + isUnique(toVerify));
    }

    //with data struct
    private static boolean isUnique(String toCheck)
    {
        Set<Character> strSet= new HashSet<>();
        for(Character c:toCheck.toCharArray())
        {
             if(!(strSet.add(c)))
            {
                //contains duplicate
                return true;
            }
        }

        //System.out.println(strSet);

        return false;

    }



}
