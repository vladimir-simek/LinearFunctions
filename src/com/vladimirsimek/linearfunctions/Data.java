package com.vladimirsimek.linearfunctions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Data {

    public static ArrayList<String[]> rawFunctions = new ArrayList<>();
    public static ArrayList<Functions> functionsArrayList = new ArrayList<>();

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

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadToBrutalList() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("data/functions.txt"));
            String readLine = bufferedReader.readLine();

            while (readLine != null) {

                String[] validLinePrepare = readLine.split(" ");
                String[] validLine = new String[2];
                Functions functions = new Functions();
                StringBuilder parser = new StringBuilder();

                for (int i = 0; i < validLinePrepare[2].length(); i++) {
                    if (validLinePrepare[2].charAt(i) >= 48 && validLinePrepare[2].charAt(i) <= 57){
                        parser.append(validLinePrepare[2].charAt(i));
                    }
                }

                functions.a = Integer.parseInt(parser.toString());
                functions.b = Integer.parseInt(validLinePrepare[4]);

                functionsArrayList.add(functions);

                readLine = bufferedReader.readLine();
            }
            bufferedReader.close();

            /* for (int i = 0; i < functionsArrayList.size(); i++) {
                System.out.println(functionsArrayList.get(i).a + " " + functionsArrayList.get(i).b);
            }*/

            // for test uncomment code above

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
