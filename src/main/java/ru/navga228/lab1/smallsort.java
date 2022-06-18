package ru.navga228.lab1;

import java.io.*;

public class smallsort {
    public static void main(String[] args) {
        String inputFileName = "smallsort.in";
        String outputFileName = "smallsort.out";
        int arr[] = new int[0];

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            int arrLength = Integer.parseInt(reader.readLine());
            arr = new int[arrLength];
            String[] numbers = reader.readLine().split(" ");
            for (int i = 0; i < arrLength; i++) {
                arr[i] = Integer.parseInt(numbers[i]);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // Сортировка вставками
        for (int j = 1; j < arr.length; j++) {
            int key = arr[j];

            int i = j - 1;

            while (i >= 0 && arr[i] > key){
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (int i = 0; i < arr.length; i++) {
                writer.write(arr[i] + " ");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
