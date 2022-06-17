package ru.navga228.lab1;

import java.io.*;

public class aplusbb {
    public static void main(String[] args) {
        String line = "";
        String inputFileName = "aplusbb.in";
        String outputFileName = "aplusbb.out";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            line = reader.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        String numbers[] = line.split(" ");
        long a = Integer.parseInt(numbers[0]);
        long b = Integer.parseInt(numbers[1]);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            writer.write(Long.toString(a + b * b));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
