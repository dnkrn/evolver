package com.dnkrn.evolver.workouts;

/**
 * Created by dinakaran on 8/24/17.
 */
public class TypeOfTriangle {

    public static void main(String[] args) {
        int[] a = new int[]{7, 10, 7};
        int[] b = new int[]{2, 3, 4};
        int[] c = new int[]{2, 7, 4};
        for (String out : triangleOrNot(a, b, c)) {
            System.out.println(out);
        }
    }

    static String[] triangleOrNot(int[] a, int[] b, int[] c) {

        if (a.length != b.length || b.length != c.length) {
            return new String[0];
        }
        String[] output = new String[a.length];

        for (int index = 0; index < a.length; index++) {
            int aSide = a[index];
            int bSide = b[index];
            int cSide = c[index];

            int max = Math.max(Math.max(aSide, bSide), cSide);

            if (max == cSide) {
               determineDeGeneracy(output,index,max, aSide, bSide);
            } else if (max == bSide) {
                determineDeGeneracy(output,index,max, aSide, cSide);
            } else {
               determineDeGeneracy(output,index,max, bSide, cSide);
            }



        }
        return output;

    }

    static void determineDeGeneracy(String[] output,int index,int max, int side1, int side2) {
        if (max < side1 + side2) {
            output[index] = "Yes";

        }
        else {
            output[index] = "No";
        }
    }
}
