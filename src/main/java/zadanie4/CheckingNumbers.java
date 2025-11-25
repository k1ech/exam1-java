package zadanie4;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class CheckingNumbers {

    public static void main(String[] args) {

        System.out.println(reportAboutNumbers("input_zad4/liczby.txt"));

    }

    public static String reportAboutNumbers(String file) {

        String result = "";

        try (Scanner scanner = new Scanner(new File(file))) {

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine().trim();
                int[] numbers = parseLineToIntArray(line);

                boolean isConstant = isConstant(numbers);
                boolean isIncreasing = isIncreasing(numbers);
                boolean isDecreasing = isDecreasing(numbers);

                int min = getMin(numbers);
                int max = getMax(numbers);
                int mostFrequentNumber = getMostFrequent(numbers);
                boolean allNumbersPresent = areAllNumbersPresent(numbers, min, max);

                result += Arrays.toString(numbers) + "\n";

                if (isConstant) result += "Stały\n";
                else if (isIncreasing) result += "Rosnący\n";
                else if (isDecreasing) result += "Malejący\n";
                else result += "Mieszany\n";

                result += "Min: " + min + ", Max: " + max + "\n";
                result += "Najpopularniejsza liczba to: " + mostFrequentNumber + "\n";
                result += "Wszystkie naturalne między min a max: " +
                        (allNumbersPresent ? "TAK" : "NIE") + "\n\n";
            }

        } catch (Exception e) {
            System.out.println("Błąd podczas wczytywania pliku.");
        }

        return result;
    }

    private static int[] parseLineToIntArray(String line) {
        String[] parts = line.split(" ");
        int[] numbers = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }
        return numbers;
    }

    private static boolean isConstant(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] != numbers[i + 1]) return false;
        }
        return true;
    }

    private static boolean isIncreasing(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) return false;
        }
        return true;
    }

    private static boolean isDecreasing(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] < numbers[i + 1]) return false;
        }
        return true;
    }

    private static int getMin(int[] numbers) {
        int min = numbers[0];
        for (int n : numbers) {
            if (n < min) min = n;
        }
        return min;
    }

    private static int getMax(int[] numbers) {
        int max = numbers[0];
        for (int n : numbers) {
            if (n > max) max = n;
        }
        return max;
    }

    private static int getMostFrequent(int[] numbers) {
        int mostFrequent = numbers[0];
        int highestCount = 0;

        for (int i = 0; i < numbers.length; i++) {
            int count = 0;
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) count++;
            }
            if (count > highestCount) {
                highestCount = count;
                mostFrequent = numbers[i];
            }
        }

        return mostFrequent;
    }

    private static boolean areAllNumbersPresent(int[] numbers, int min, int max) {
        for (int value = min; value <= max; value++) {
            boolean found = false;
            for (int n : numbers) {
                if (n == value) {
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }
}


