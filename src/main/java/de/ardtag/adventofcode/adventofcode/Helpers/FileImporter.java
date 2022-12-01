package de.ardtag.adventofcode.adventofcode.Helpers;

import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.core.io.Resource;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FileImporter {

    public List<String> readFile(String fileName) {

        BufferedReader bufferedReader;
        List<String> stringList = new ArrayList<>();

        String strPath = "C:/Users/A302772/IdeaProjects/AdventOfCode/src/main/resources/";

        try {
            bufferedReader = new BufferedReader(new FileReader(strPath+fileName));

            String line = bufferedReader.readLine();

            while (line != null) {
                stringList.add(line);
                line = bufferedReader.readLine();
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;

    }

}
