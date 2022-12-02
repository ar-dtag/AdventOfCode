package de.ardtag.adventofcode.adventofcode.Day1;

import de.ardtag.adventofcode.adventofcode.Helpers.FileImporter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Day1 {
    public void run() throws IOException {
        //Variables
        FileImporter myFileImporter = new FileImporter();
        List<Integer> ElveList = new ArrayList<>();
        AtomicInteger intCalories = new AtomicInteger();

        //read file content and do magic
        myFileImporter.readFile("Day1.txt").forEach(s -> {

            if (!s.isEmpty()) {
                intCalories.getAndAdd(Integer.parseInt(s));
            }
            else {
                ElveList.add(intCalories.get());
                intCalories.set(0);
            }
        });

        ElveList.forEach(integer -> {
          System.out.println(integer);
        });


        // Create maxValue variable and initialize with 0
        int maxValue = 0;

        // Check maximum element using for loop
        for (Integer integer : ElveList) {
            if (integer > maxValue)
                maxValue = integer;
        }
        System.out.println("The maximum value is "
                + maxValue);

        System.out.println("The sorted List is :");

        //sort reverse
        ElveList.sort((o1, o2) -> o2.compareTo(o1));

        ElveList.forEach(integer -> {
            System.out.println(integer);
        });



    }
}
