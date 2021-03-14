package com.vladimirsimek.linearfunctions;

import java.io.*;
import java.util.ArrayList;

public class Data {

    public static ArrayList<String[]> rawFunctions = new ArrayList<>();
    public static ArrayList<Functions> functionsArrayList = new ArrayList<>();

    public static void loadToArrayList() {
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
                    if (validLinePrepare[2].charAt(i) >= 48 && validLinePrepare[2].charAt(i) <= 57) {
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

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int allFunctions = 0;

    public static void countIt() {

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("data/count.txt"));

            allFunctions = Integer.parseInt(String.valueOf(functionsArrayList.size()));
            bufferedWriter.write(String.valueOf(allFunctions));
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int duplicateFunctions = 0;
    public static int specialFunctions = 0;

    public static void countSpecials() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("data/count_distinct.txt"));

            for (int i = 0; i < functionsArrayList.size(); i++) {
                int duplicity = 0;
                int currentA = functionsArrayList.get(i).a;
                int currentB = functionsArrayList.get(i).b;
                for (int j = 0; j < functionsArrayList.size(); j++) {
                    int otherA = functionsArrayList.get(j).a;
                    int otherB = functionsArrayList.get(j).b;

                    if (currentA == otherA && currentB == otherB) {
                        duplicity++;
                    }
                }
                if (duplicity >= 2) {
                    duplicateFunctions++;
                }
            }

            specialFunctions = allFunctions - duplicateFunctions;

            bufferedWriter.write(String.valueOf(specialFunctions));
            bufferedWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
