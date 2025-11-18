package zadanie1;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FlightVerification {

    public static void main(String[] args) {

        storeToFile("output/zleLoty.txt", checkInvalidPlanes(readFileContent("input/samoloty.txt")));
    }

    public static String readFileContent(String textFile) {

        String flightInformation = "";

        try (Scanner scanner = new Scanner(new File(textFile))) {
            while (scanner.hasNextLine()) {
                flightInformation += scanner.nextLine() + "\n";
            }

        } catch (Exception e) {
            System.out.println("Błąd podczas wczytywania pliku.");
        }

        return flightInformation;
    }

    public static String checkInvalidPlanes(String fileContent) {

        String[] lines = fileContent.split("\n");
        String result = "";

        for (int i = 0; i < lines.length; i++) {

            String[] parts = lines[i].split(";");

            String flightNumber = parts[0];
            int passengerLimit = Integer.parseInt(parts[2]);
            int cargoLimit = Integer.parseInt(parts[3]);

            int totalPassengerWeight = 0;
            int currentPassengers = 0;

            for (int j = 4; j < parts.length; j++) {
                totalPassengerWeight += Integer.parseInt(parts[j]);
                currentPassengers++;
            }

            if (currentPassengers > passengerLimit) {
                result += flightNumber + " nie może się odbyć! Limit pasażerów został przekroczony!\n";

            } else if (totalPassengerWeight > cargoLimit) {
                result += flightNumber + " nie może się odbyć! Limit ładowności został przekroczony!\n";

            } else {
                result += flightNumber + " może się odbyć!\n";
            }
        }
        return result;
    }

    public static void storeToFile(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);

        } catch (Exception e) {
            System.out.println("Błąd podczas zapisu do pliku.");
        }
    }

}
