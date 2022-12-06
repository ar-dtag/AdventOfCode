package de.ardtag.adventofcode.adventofcode;

import de.ardtag.adventofcode.adventofcode.Day2.Day2Part1;
import de.ardtag.adventofcode.adventofcode.Day2.Day2Part2;
import de.ardtag.adventofcode.adventofcode.Day3.Day3Part1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URL;

@SpringBootApplication
public class AdventOfCodeApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(AdventOfCodeApplication.class, args);

        //Day 2
        //new Day1().run();

        //Day2
        //new Day2Part1().run();
        //new Day2Part2().run();

        //Day3
        new Day3Part1().run();



    }

}
