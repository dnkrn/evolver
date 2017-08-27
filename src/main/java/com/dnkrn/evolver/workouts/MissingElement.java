package com.dnkrn.evolver.workouts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MissingElement {

    public static void main(String[] args) {

        List<Integer> array1 = new ArrayList<>(Arrays.asList(6, 4, 7, 2, 1, 0, 8, -9, 3, 5, 9));
        List<Integer> array2 = Arrays.asList(6, -9, 7, 2, 1, 0, 8, 3, 5, 9);

        array1.addAll(array2);
        Optional<Integer> missing = array1.stream()
                .reduce((x, y) -> x ^ y);

        System.out.println(missing.get());

    }
}
