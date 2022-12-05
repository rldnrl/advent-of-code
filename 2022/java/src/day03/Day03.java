package day03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Day03 {
    public static int sumOfCommonCharacter() throws IOException {
        List<String> linesList = Files.readAllLines(Paths.get("./inputs/day03/input.txt"));
        String[] linesArray = linesList.toArray(new String[0]);

        Map<Character, Integer> lowercaseAlphabet = new HashMap<>();
        Map<Character, Integer> uppercaseAlphabet = new HashMap<>();

        int result = 0;

        for (int i = 1; i < 27; i++) {
            lowercaseAlphabet.put((char) (96 + i), i);
            uppercaseAlphabet.put((char) (64 + i), i + 26);
        }

        for (String rucksack: linesArray) {
            Set<Character> set = new LinkedHashSet<>();
            int sum = 0;
            int size = rucksack.length();
            int halfSize = size / 2;
            String leftRucksack = rucksack.substring(0, halfSize);
            String rightRucksack = rucksack.substring(halfSize, size);

            for (int i = 0; i < halfSize; i++) {
                set.add(leftRucksack.charAt(i));
            }

            for (int i = 0; i < halfSize; i++) {
                char currentCharacter = rightRucksack.charAt(i);
                if (set.contains(currentCharacter)) {
                    if (Character.isLowerCase(currentCharacter)) {
                        sum += lowercaseAlphabet.get(currentCharacter);
                    }
                    if (Character.isUpperCase(currentCharacter)) {
                        sum += uppercaseAlphabet.get(currentCharacter);
                    }
                    break;
                }
            }

            result += sum;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(sumOfCommonCharacter());
    }
}
