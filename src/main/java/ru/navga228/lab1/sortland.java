package ru.navga228.lab1;

import java.io.*;

public class sortland {
    public static void main(String[] args) {
        String inputFileName = "sortland.in";
        String outputFileName = "sortland.out";
        double sortArr[] = new double[0];

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            int arrLength = Integer.parseInt(reader.readLine());
            sortArr = new double[arrLength];
            String[] numbers = reader.readLine().split(" ");
            for (int i = 0; i < arrLength; i++) {
                sortArr[i] = Double.parseDouble(numbers[i]);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        int arrId[] = new int[sortArr.length];
        for (int i = 0; i < arrId.length; i++) {
            arrId[i] = i + 1;
        }

        for (int j = 1; j < sortArr.length; j++) {
            double key = sortArr[j];

            int i = j - 1;

            while (i >= 0 && sortArr[i] > key){
                sortArr[i + 1] = sortArr[i];
                arrId[i + 1] = arrId[i];
                i--;
            }
            sortArr[i + 1] = key;
            arrId[i + 1] = j + 1;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            writer.write(arrId[0] + " " + arrId[arrId.length/2] + " "+ arrId[sortArr.length - 1]);
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
}
