package zadanie3;

import java.util.Arrays;

public class SuperPrimeNumbers {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(superPrimes(-10, 11)));
    }

    public static int[] superPrimes(int from, int to) {

        int[] array = new int[to - from + 1];
        int count = 0;

        for (int number = from; number <= to; number++) {

            boolean isPrime = true;

            if (number < 2) isPrime = false;
            else {
                for (int i = 2; i * i <= number; i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            if (!isPrime) continue;

            int sum = 0;
            int tempNumber = number;

            while (tempNumber > 0) {
                sum += tempNumber % 10;
                tempNumber /= 10;
            }

            boolean sumPrime = true;
            if (sum < 2) sumPrime = false;
            else {
                for (int i = 2; i * i <= sum; i++) {
                    if (sum % i == 0) {
                        sumPrime = false;
                        break;
                    }
                }
            }
            if (sumPrime) {
                array[count++] = number;
            }
        }

        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = array[i];
        }
        return result;
    }
}