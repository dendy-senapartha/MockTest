package org.tddkata;

/**
 * @author dendy
 * @Date 17/05/2022
 * @Time 09.49
 * Description :
 */
public class StringCalculator {
    public int add(String text) {
        if (text.equals("")) {
            return 0;
        } else {
            String delimiter = ",";
            if (text.matches("//(.*)\n(.*)")) {
                delimiter = Character.toString(text.charAt(2));
                text = text.substring(4);
            }

            String numList[] = splitNumbers(text, delimiter + "|\n");
            return sum(numList);
        }
    }

    private int toInt(String number) {
        return Integer.parseInt(number);
    }

    private String[] splitNumbers(String numbers, String divider) {
        return numbers.split(divider);
    }

    private int sum(String[] numbers) {
        int total = 0;
        String negString = "";

        for (String number : numbers) {
            if (toInt(number) < 0) {
                if (negString.equals(""))
                    negString = number;
                else
                    negString += ("," + number);
            }
            if (toInt(number) < 1000)
                total += toInt(number);
        }

        if (!negString.equals("")) {
            throw new IllegalArgumentException("Negatives not allowed: " + negString);
        }

        return total;
    }
}
