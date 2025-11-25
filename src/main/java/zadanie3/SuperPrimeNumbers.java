package zadanie3;

import java.util.Arrays;

public class SuperPrimeNumbers {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(superPrimes(-20, 40)));
    }

    public static int[] superPrimes(int from, int to) {

        int[] array = new int[to - from + 1];
        int count = 0;

        for (int number = from; number <= to; number++) {
            if (isSuperPrime(number)) {
                array[count++] = number;
            }
        }

        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = array[i];
        }
        return result;
    }

    private static boolean isSuperPrime(int number) {
        if (!isPrime(number)) return false;
        int sum = digitSum(number);
        return isPrime(sum);
    }

    private static boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    private static int digitSum(int number) {
        if (number < 0) number = -number;
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}