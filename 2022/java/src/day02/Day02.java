package day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Day02 {
    public static int getStrategy() throws IOException {
        List<String> linesList = Files.readAllLines(Paths.get("./inputs/day02/input.txt"));
        String[] linesArray = linesList.toArray(new String[0]);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("X", "A");
        hashMap.put("Y", "B");
        hashMap.put("Z", "C");

        int totalScore = 0;
        for (String game: linesArray) {
            int c = 0;

            String them = game.split( " ")[0];
            String me = game.split( " ")[1];

            if (Objects.equals(me, "X")) {
                c += 1;
            } else if (Objects.equals(me, "Y")) {
                c += 2;
            } else if (Objects.equals(me, "Z")) {
                c += 3;
            }

            me = hashMap.get(me);

            if (Objects.equals(them, me)) {
                c += 3;
            } else if (Objects.equals(them, "A") && Objects.equals(me, "B")) {
                c += 6;
            } else if (Objects.equals(them, "B") && Objects.equals(me, "C")) {
                c += 6;
            } else if (Objects.equals(them, "C") && Objects.equals(me, "A")) {
                c += 6;
            }

            totalScore += c;
        }

        return totalScore;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getStrategy());
    }
}
