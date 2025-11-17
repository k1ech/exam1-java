package zadanie4;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class CheckingNumbers {

    public static void main(String[] args) {

        System.out.println(raportAboutNumbers("liczby.txt"));

    }

    public static String raportAboutNumbers(String file) {

        String result = "";

        try (Scanner scanner = new Scanner(new File(file))) {
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                line = line.trim();
                String[] parts = line.split(" ");

                int[] numbers = new int[parts.length];

                for (int i = 0; i < parts.length; i++) {
                    numbers[i] = Integer.parseInt(parts[i]);
                }
                boolean isIncreasing = true;
                boolean isDecreasing = true;
                boolean isConstant = true;

                for (int i = 0; i < numbers.length - 1; i++) {

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
                if (isConstant) {
                    result += Arrays.toString(numbers) + " Stały\n";
                } else if (isIncreasing) {
                    result += Arrays.toString(numbers) + " Rosnący\n";
                } else if (isDecreasing) {
                    result += Arrays.toString(numbers) + " Malejący\n";
                } else {
                    result += Arrays.toString(numbers) + " Mieszany\n";
                }
            }
        } catch (Exception e) {
            System.out.println("Błąd podczas wczytywania pliku.");
        }

        return result;
    }

}

