package de.ardtag.adventofcode.adventofcode.Day3;

import de.ardtag.adventofcode.adventofcode.Helpers.FileImporter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Day3Part1 {

    /*
    a b c d e f g h i j  k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z
    1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26

    A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z
    27 28 29 30 31 32 33 34 35 46 47 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52

     */

    public void run() throws IOException {
        //Variables
        FileImporter myFileImporter = new FileImporter();
        List<Integer> ElveList = new ArrayList<>();
        AtomicInteger intSumPrio = new AtomicInteger();
        List<Character> charsList = new ArrayList<>();
        List<Character> charsListFinal = new ArrayList<>();

        final HashMap<Character,Integer> priorityHashMap = new HashMap<Character, Integer>();

        //fill PrioHashMap
        char ch;
        int intPrio = 1;
        for(ch = 'a'; ch <= 'z'; ++ch){
            priorityHashMap.put(ch,intPrio++);
        }
        for(ch = 'A'; ch <= 'Z'; ++ch){
            priorityHashMap.put(ch,intPrio++);
        }

        //read file content and do magic
        myFileImporter.readFile("Day3.txt").forEach(line -> {
            //Split line in two half parts
            int intTimAfter = (line.length()/2);
            System.out.println("Split after : " + intTimAfter);


            //Split
            String left = line.substring(0, intTimAfter);
            String right = line.substring(intTimAfter);

            System.out.print("left is : " + left + " ");
            System.out.println("right is : " + right);


            //find charachters which appears in each side.
            // compare each chat from left with each other in the right side.
            for (int i = 0; i < left.toCharArray().length; i++) {

                for (int ii = 0; ii < right.toCharArray().length; ii++) {
                    if (right.charAt(ii) == left.charAt(i) ){
                        if (!charsList.contains(left.charAt(i)))
                            charsList.add(left.charAt(i));
                        System.out.println(left.charAt(i));
                    }

                }
            }

            charsListFinal.addAll(charsList);
            charsList.clear();

        });



        //Calculate priorities
        charsListFinal.forEach(character -> {
            intSumPrio.addAndGet(priorityHashMap.get(character));
        });

        System.out.println("Final PrioSum is: " + intSumPrio);


    }
}
