package de.ardtag.adventofcode.adventofcode.Day2;

import de.ardtag.adventofcode.adventofcode.Helpers.FileImporter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Day2Part2 {

    /*
    score rules
    A,X = 1 stone
    B,Y = 2 paper
    C,Z = 3 scissor
    lost = 0
    draw = 3
    win = 6

    game rules
    A,X = stone
    B,Y = paper
    C,Z = scissors (Schere)

    stone (A,X) breaks scissors (C,Z) -> stone wins
    paper (B,Y) paper wrapped stones (A,B) -> paper wins
    scissors (C,Z) cut paper (B,Y) -> scissors wins
     */

    public void run() throws IOException{

        //Variables
        FileImporter myFileImporter = new FileImporter();
        AtomicInteger intMyPoints = new AtomicInteger();

        intMyPoints.set(0);
        final HashMap<String,Integer> rulesAndPointsHashMap = new HashMap<>() {
            {
                put("A X", 4); // stone vs. stone, draw
                put("A Y", 8); // stone vs. paper, I win
                put("A Z", 3); // stone vs. scissor, elfe wins

                put("B X", 1); // paper vs. stone, elfe wins
                put("B Y", 5); // paper vs. paper, draw
                put("B Z", 9); // paper vs. scissor, I win

                put("C X", 7); // scissor vs. stone, I win
                put("C Y", 2); // scissor vs. paper, elfe wins
                put("C Z", 6); // scissor vs. scissor, draw
            }
        };

        //read file content and do magic
        myFileImporter.readFile("Day2.txt").forEach(line -> {

            //replace line with new rules value
            String myNewLine = this.changeLineByNewWinningRules(line);


            //calculate points per each line
            if (!line.isEmpty()) {

                rulesAndPointsHashMap.forEach((e,f) -> {
                    if (myNewLine.equals(e)) {
                        System.out.println("result for " + line + " and new rule " + myNewLine +" is " + f);
                        intMyPoints.set(intMyPoints.intValue() + f);
                    }
                } );
            }
            else {
                System.out.println("empty line!");
            }
            System.out.println("My Points now are: " + intMyPoints);
        });

        System.out.println("My total points are: " + intMyPoints);

    }

    private String changeLineByNewWinningRules(String givenLine){

        /*
        Case is given:
        X = I have to lose
        Y = I have to draw
        Z = I have to win
        */

        switch (givenLine){
            case "A X": return "A Z"; // stone vs. stone, draw
            case "A Y": return "A X"; // stone vs. paper, I win
            case "A Z": return "A Y"; // stone vs. scissor, elfe wins

            case "B X": return givenLine; // paper vs. stone, elfe wins
            case "B Y": return givenLine; // paper vs. paper, draw
            case "B Z": return givenLine; // paper vs. scissor, I win

            case "C X": return "C Y"; // scissor vs. stone, I win
            case "C Y": return "C Z"; // scissor vs. paper, elfe wins
            case "C Z": return "C X"; // scissor vs. scissor, draw
        }

        return "";
    }
}
