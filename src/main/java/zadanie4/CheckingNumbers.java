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
                String[] parts = line.split(" ");

                int[] numbers = new int[parts.length];

                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = Integer.parseInt(parts[i]);
                }

                boolean isIncreasing = true;
                boolean isDecreasing = true;
                boolean isConstant = true;
                int min = numbers[0];
                int max = numbers[0];
                int maxfreq = numbers[0];
                int max_count = 0;

                for (int i = 0; i < numbers.length; i++) {

                    if (max < numbers[i]) {
                        max = numbers[i];
                    }
                    if (min > numbers[i]) {
                        min = numbers[i];
                    }
                    if (i < numbers.length - 1) {
                        if (numbers[i] != numbers[i + 1]) {
                            isConstant = false;
                        }
                        if (numbers[i + 1] > numbers[i]) {
                            isDecreasing = false;
                        }
                        if (numbers[i] > numbers[i + 1]) {
                            isIncreasing = false;
                        }
                    }
                    int count = 0;

                    for (int j = 0; j < numbers.length; j++) {
                        if (numbers[i] == numbers[j]) {
                            count++;
                        }
                    }
                    if (count > max_count) {
                        max_count = count;
                        maxfreq = numbers[i];
                    }
                }
                result += Arrays.toString(numbers) + "\n";

                if (isConstant) {
                    result += "Stały\n";
                } else if (isIncreasing) {
                    result += "Rosnący\n";
                } else if (isDecreasing) {
                    result += "Malejący\n";
                } else {
                    result += "Mieszany\n";
                }

                boolean allNumbersPresent = true;

                for (int numberToCheck = min; numberToCheck <= max; numberToCheck++) {
                    boolean found = false;

                    for (int i = 0; i < numbers.length; i++) {
                        if (numbers[i] == numberToCheck) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        allNumbersPresent = false;
                        break;
                    }
                }
                result += "Min: " + min + ", Max: " + max + "\n";
                result += "Najpopularniejsza liczba to: " + maxfreq + "\n";
                result += "Wszystkie naturalne między min i max: "
                        + (allNumbersPresent ? "TAK" : "NIE") + "\n\n";
            }
        } catch (Exception e) {
            System.out.println("Błąd podczas wczytywania pliku.");
        }
        return result;
    }
}


