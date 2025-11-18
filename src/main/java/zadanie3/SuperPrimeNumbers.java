package zadanie3;

import java.util.Arrays;

public class SuperPrimeNumbers {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(superPrimes(10, 200)));
    }
    public static int[] superPrimes(int from, int to) {

        int[] temp = new int[to - from + 1];
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
            int t = number;
            while (t > 0) {
                sum += t % 10;
                t /= 10;
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
            if (sumPrime) temp[count++] = number;
        }
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }
        return result;
    }}