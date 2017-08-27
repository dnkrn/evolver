package com.dnkrn.evolver.workouts;

/**
 * Created by dinakaran on 8/26/17.
 */
public class BinaryCounter {

    static int counting(String s) {

        int len=s.length();

        //Check for consecutive numbers based on length
       int cnt = 0,max=0;
        for(int i=0;i<s.length();i++){
            cnt=0;
            while(i<s.length()&& s.toCharArray()[i]=='1'){
                cnt++;
                i++;
            }
            if(cnt>max) max=cnt;
        }

        System.out.println(cnt+"---"+ max);


        return 0;
    }


    public static void main(String[] args) {
        System.out.println(counting("001101111000111"));
    }
}
