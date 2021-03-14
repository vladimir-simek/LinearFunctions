package com.vladimirsimek.linearfunctions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Data {

    public static ArrayList<String[]> rawFunctions = new ArrayList<>();

    public static void loadToArrayList(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("data/functions.txt"));
            String readLine = bufferedReader.readLine();

            while (readLine != null) {

                String[] validLinePrepare = readLine.split(" ");
                String[] validLine = new String[2];

                validLine[0] = validLinePrepare[2];
                validLine[1] = validLinePrepare[4];

                rawFunctions.add(validLine);

                readLine = bufferedReader.readLine();
            }

            /*for (String[] rawFunction : rawFunctions) {
                System.out.println(Arrays.toString(rawFunction));
            }*/

            // for test uncomment code above


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
