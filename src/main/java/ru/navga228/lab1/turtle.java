package ru.navga228.lab1;

import java.io.*;

public class turtle {
    public static void main(String[] args) {
        String inputFileName = "turtle.in";
        String outputFileName = "turtle.out";
        int h = 0; // Строк в поле
        int w = 0; // Длина каждой строки поля
        int[][] matrix = new int[0][0];

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String[] fieldSize = reader.readLine().split(" ");
            h = Integer.parseInt(fieldSize[0]);
            w = Integer.parseInt(fieldSize[1]);
            matrix = new int[h][w];
            for (int i = 0; i < h; i++) {
                String[] fieldLine = reader.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    matrix[i][j] = Integer.parseInt(fieldLine[j]);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // Динамически высчитываем правую и нижнюю края поля
        for (int i = h - 1; i > 0; i--) {
            matrix[i - 1][0] = matrix[i - 1][0] + matrix[i][0];
        }
        for (int i = 0; i < w - 1; i++) {
            matrix[h - 1][i + 1] = matrix[h - 1][i + 1] + matrix[h - 1][i];
        }

        // Основной алгоритм динамического подсчета выгодного пути
        for (int i = h - 2; i >= 0; i--) {
            for (int j = 1; j < w; j++) {
                if(matrix[i][j - 1] >= matrix[i + 1][j]){
                    matrix[i][j] += matrix[i][j - 1];
                }
                else {
                    matrix[i][j] += matrix[i + 1][j];
                }
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            writer.write(Integer.toString(matrix[0][w - 1]));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
