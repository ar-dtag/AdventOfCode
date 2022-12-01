package de.ardtag.adventofcode.adventofcode;

import de.ardtag.adventofcode.adventofcode.Day1.Day1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class AdventOfCodeApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(AdventOfCodeApplication.class, args);

        new Day1().run();

    }

}
