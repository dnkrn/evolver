package com.dnkrn.evolver.workouts;

import java.util.Stack;

/**
 * Created by dinakaran on 5/13/17.
 */
public class TotalSum {


    private static final String PLUS="+";

    private static final String Z_ALPHA="Z";

    private static final String X_ALPHA="X";

    public static int totalScore(String[] blocks, int n) throws  Exception
    {
        if(n != blocks.length)
        {
            throw new Exception("input arr and input n is not the same");
        }
        Stack<Integer> inputSum= new Stack<>();

        int totalScore=0;

        int firstElement=0;

        if(null != blocks)
        {
            for(String input:blocks)
            {
                if(null == input || "".equals(input))
                {
                    continue;
                }
                try
                {
                    int item=Integer.parseInt(input);
                    inputSum.push(item);
                    totalScore+=item;
                }
                catch(NumberFormatException ne)
                {

                    if(Z_ALPHA.equals(input))
                    {
                        totalScore=totalScore-inputSum.peek();
                        inputSum.pop();
                        firstElement=inputSum.peek();

                    }
                    else if(X_ALPHA.equals(input))
                    {
                        int lastelement = 2 * inputSum.peek();
                        firstElement=lastelement;
                        inputSum.push(lastelement);
                        totalScore=totalScore+lastelement;

                    }
                    else if(PLUS.equals(input))
                    {
                        int plusSum=firstElement+inputSum.peek();
                        firstElement=inputSum.peek();
                        inputSum.push(plusSum);
                        totalScore=totalScore+plusSum;

                    }
                    else{
                        throw new Exception("unsupported Char Exception");
                    }

                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }

            }

        }

        return totalScore;

    }


    // METHOD SIGNATURE ENDS

    public static void main (String[] args) {
	    /* code */
        try{
            String[] inputArr= new String[]{"5","-2","4","Z","X","9","+","+"};
            System.out.println(totalScore(inputArr,8));
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
