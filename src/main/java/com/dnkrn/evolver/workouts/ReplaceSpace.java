package com.dnkrn.evolver.workouts;

import java.util.Arrays;

/**
 * Created by dinakaran on 5/9/17.
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        String spacStr="Mr John Smith ";
        System.out.println(replaceSpace(spacStr));

    }

    private static String replaceSpace(String input)
    {
        StringBuilder bui=new StringBuilder();
       for(char c:input.toCharArray())
       {
           if(c == ' ')
           {
               bui.append("%20");
           }
           else {
               bui.append(c);
           }
       }

        return bui.toString();
    }
}
