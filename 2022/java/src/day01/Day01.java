package day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day01 {
    public static int getMaximumCalorie() throws IOException {
        List<String> linesList = Files.readAllLines(Paths.get("./inputs/day01/input.txt"));
        String[] linesArray = linesList.toArray(new String[0]);

        int max = 0;
        int sum = 0;
        for (String calorie: linesArray) {
            if (calorie.trim().length() > 0) {
                sum += Integer.parseInt(calorie);
            } else {
                max = Math.max(sum, max);
                sum = 0;
            }
        }

        return max;
    }

    public static int getSumOfTopThree() throws IOException {
        List<String> linesList = Files.readAllLines(Paths.get("./inputs/day01/input.txt"));
        String[] linesArray = linesList.toArray(new String[0]);
        List<Integer> calories = new ArrayList<>();

        int sum = 0;
        for (String calorie: linesArray) {
            if (calorie.trim().length() > 0) {
                sum += Integer.parseInt(calorie);
            } else {
                calories.add(sum);
                sum = 0;
            }
        }

        calories.sort(Collections.reverseOrder());
        return calories.get(0) + calories.get(1) + calories.get(2);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getMaximumCalorie());
        System.out.println(getSumOfTopThree());
    }
}
