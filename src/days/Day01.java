package days;


import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Day01 {

    public String day01_1() throws IOException {
        File file = new File("src/resources/day01_1.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        int sum = 0;

        while ((line = br.readLine()) != null) {
            String digits = "";

            for (int i = 0; i < line.length(); i++) {
                if (StringUtils.isNumeric(String.valueOf(line.charAt(i)))) {
                    digits += line.charAt(i);
                    break;
                }
            }

            for (int i = line.length() - 1; i > -1; i--) {
                if (StringUtils.isNumeric(String.valueOf(line.charAt(i)))) {
                    digits += line.charAt(i);
                    break;
                }
            }

            sum += Integer.parseInt(digits);
        }


        return String.valueOf(sum);
    }

    public String day01_2() throws IOException {
        Map<String, String> numbers = Map.of(
                "one", "1",
                "two", "2",
                "three", "3",
                "four", "4",
                "five", "5",
                "six", "6",
                "seven", "7",
                "eight", "8",
                "nine", "9");

        File file = new File("src/resources/day01_2.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        int sum = 0;

        while ((line = br.readLine()) != null) {
            String firstDigit = "";
            String secondDigit = "";
            int firstIndex = Integer.MAX_VALUE;
            int secondIndex = Integer.MIN_VALUE;

            for (int i = 0; i < line.length(); i++) {
                if (StringUtils.isNumeric(String.valueOf(line.charAt(i)))) {
                    firstDigit = String.valueOf(line.charAt(i));
                    firstIndex = i;
                    break;
                }
            }

            for (int i = line.length() - 1; i > -1; i--) {
                if (StringUtils.isNumeric(String.valueOf(line.charAt(i)))) {
                    secondDigit = String.valueOf(line.charAt(i));
                    secondIndex = i;
                    break;
                }
            }

            for (Map.Entry<String, String> entry : numbers.entrySet()) {
                String k = entry.getKey();
                String v = entry.getValue();

                // handle occurrences from left side
                int currentIdx = line.indexOf(k);
                if (currentIdx != -1 && currentIdx < firstIndex) {
                    firstIndex = currentIdx;
                    firstDigit = v;
                }


                // handle occurrences from right side
                int currentLastIndex = line.lastIndexOf(k);
                if (currentLastIndex != -1 && currentLastIndex > secondIndex) {
                    secondIndex = currentLastIndex;
                    secondDigit = v;
                }
            }

            String digits = firstDigit + secondDigit;

            sum += Integer.parseInt(digits);
        }

        return String.valueOf(sum);
    }
}

