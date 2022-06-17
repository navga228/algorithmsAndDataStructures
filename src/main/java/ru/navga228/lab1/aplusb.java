package ru.navga228.lab1;

import java.io.*;

public class aplusb {
    public static void main(String[] args) {
        String line = new String();
        int a;
        int b;
        String inputFileName = "aplusb.in";
        String outputFileName = "aplusb.out";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            line = reader.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        String parts[] = line.split(" ");
        a = Integer.parseInt(parts[0]);
        b = Integer.parseInt(parts[1]);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            writer.write(Integer.toString(a + b));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
