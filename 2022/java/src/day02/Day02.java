package day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Day02 {
    public static int getStrategy() throws IOException {
        List<String> linesList = Files.readAllLines(Paths.get("./inputs/day02/input.txt"));
        String[] linesArray = linesList.toArray(new String[0]);
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("X", "A");
        hashMap.put("Y", "B");
        hashMap.put("Z", "C");

        int totalScore = 0;
        for (String game: linesArray) {
            int score = 0;

            String them = game.split( " ")[0];
            String me = game.split( " ")[1];

            if (Objects.equals(me, "X")) {
                score += 1;
            } else if (Objects.equals(me, "Y")) {
                score += 2;
            } else if (Objects.equals(me, "Z")) {
                score += 3;
            }

            me = hashMap.get(me);

            if (Objects.equals(them, me)) {
                score += 3;
            } else if (Objects.equals(them, "A") && Objects.equals(me, "B")) {
                score += 6;
            } else if (Objects.equals(them, "B") && Objects.equals(me, "C")) {
                score += 6;
            } else if (Objects.equals(them, "C") && Objects.equals(me, "A")) {
                score += 6;
            }

            totalScore += score;
        }

        return totalScore;
    }

    public static int getStrategyPartTwo() throws IOException {
        List<String> linesList = Files.readAllLines(Paths.get("./inputs/day02/input.txt"));
        String[] linesArray = linesList.toArray(new String[0]);
        List<String> values = new ArrayList<>();
        values.add("A");
        values.add("B");
        values.add("C");

        int totalScore = 0;
        for (String game: linesArray) {
            int score = 0;

            String them = game.split( " ")[0];
            String me = game.split( " ")[1];

            if (Objects.equals(me, "X")) {
                score += 0;
            }
            if (Objects.equals(me, "Y")) {
                score += 3;
            }
            if (Objects.equals(me, "Z")) {
                score += 6;
            }

            int more = values.indexOf(them) + 1;

            if (Objects.equals(me, "X")) {
                more -= 1;
            }
            if (Objects.equals(me, "Z")) {
                more += 1;
            }
            more = more % 3;
            score += more;

            if (more == 0) {
                score += 3;
            }

            totalScore += score;
        }

        return totalScore;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getStrategy());
        System.out.println(getStrategyPartTwo());
    }
}
