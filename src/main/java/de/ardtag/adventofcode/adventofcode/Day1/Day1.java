package de.ardtag.adventofcode.adventofcode.Day1;

import de.ardtag.adventofcode.adventofcode.Helpers.FileImporter;

import java.io.IOException;
import java.util.Arrays;

public class Day1 {
    public void run() throws IOException {
        FileImporter myFileImporter = new FileImporter();

        myFileImporter.readFile("Day1.txt").forEach(s -> {
            System.out.println(s);
        });
    }
}
