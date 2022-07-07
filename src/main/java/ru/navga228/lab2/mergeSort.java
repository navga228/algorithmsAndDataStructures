package ru.navga228.lab2;

import java.io.*;


public class mergeSort {

    public static void sort(int mas[], int p, int r, int q){
        // p - номер первого элемента массива, r - номер последнего элемента массива, q - середина массива
        if(p >= r){
            return;
        }
        int n1 = (q - p); // размер левой половинки массива
        int n2 = (r + 1 - q); // размер правой половинки массива
        int left[] = new int[n1];
        int right[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = mas[i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = mas[n1 + i];
        }

        int lQ = left.length / 2;
        int rQ = right.length / 2;
        sort(left, 0, n1 - 1, lQ);
        sort(right, 0, n2 - 1, rQ);
        merge(mas, left, right);
    }

    public static void merge(int mas[], int left[], int right[]){
        int lCounter = 0;
        int rCounter = 0;
        for (int i = 0; i < mas.length; i++) {
            if(lCounter == left.length) {
                int count = i;
                for (int j = rCounter; j < right.length; j++) {
                    mas[count] = right[j];
                    count++;
                }
                break;
            }
            if(rCounter == right.length){
                int count = i;
                for (int j = lCounter; j < left.length; j++) {
                    mas[count] = left[j];
                    count++;
                }
                break;
            }

            if (left[lCounter] <= right[rCounter]) {
                mas[i] = left[lCounter];
                lCounter++;
            }
            else {
                mas[i] = right[rCounter];
                rCounter++;
            }
        }
    }

    public static void main(String[] args) {
        String inputFileName = "sort.in";
        String outputFileName = "sort.out";
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

        sort(arr, 0, arr.length - 1, arr.length / 2);

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
