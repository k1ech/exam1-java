package zadanie2;


public class SequenceNumbers {

    public static void main(String[] args) {

        int[] sequence = {2, 4, 8, 16, 32};
        int[] sequence1 = {2, 4, 6, 8, 10};
        int[] sequence2 = {10, 8, 2, 5, 6};
        int[] sequence3 = {0, -2, -4, -6};
        int[] sequence4 = {1, -2};
        int[] sequence5 = {1, 2, 3};
        int[] sequence7 = {1, 2, 4};
        int[] sequence8 = {0, 0, 0}; /* tutaj ten ciąg jest geo i aryt, ale zgodnie z treścią zadania mam wypisać geo, aryt lub inny, więc tutaj sprawdzanie arytmetyczności jest pierwsze,
        więc wypisze arytmetyczny */
        int[] sequence9 = {1, 0, 0};
        int[] sequence10 = {5, 4, 3, 2, 1};

        System.out.println(getSequenceName(sequence));
        System.out.println(getSequenceName(sequence1));
        System.out.println(getSequenceName(sequence2));
        System.out.println(getSequenceName(sequence3));
        System.out.println(getSequenceName(sequence4));
        System.out.println(getSequenceName(sequence5));
        System.out.println(getSequenceName(sequence7));
        System.out.println(getSequenceName(sequence8));
        System.out.println(getSequenceName(sequence9));
        System.out.println(getSequenceName(sequence10));

    }

    public static String getSequenceName(int[] sequence) {

        if (sequence.length < 3) {
            return "ABY OKREŚLIĆ CIĄG TABLICA MUSI ZAWIERAĆ PRZYNAJMNIEJ 3 ELEMENTY";
        }

        boolean arithmeticSequence = isArithmetic(sequence);
        boolean geometricSequence = isGeometric(sequence);

        if (arithmeticSequence) return "ARYTMETYCZNY";
        if (geometricSequence) return "GEOMETRYCZNY";

        return "INNY";
    }
    private static boolean isArithmetic(int[] sequence) {

        int constArithmetical = sequence[1] - sequence[0];

        for (int i = 2; i < sequence.length; i++) {
            if (sequence[i] - sequence[i - 1] != constArithmetical) return false;
        }
        return true;
    }
    private static boolean isGeometric(int[] sequence) {
        boolean geometricSequence = true;

        if (sequence[0] == 0) {
            for (int i = 1; i < sequence.length; i++) {
                if (sequence[i] != 0) {
                    geometricSequence = false;
                    break;
                }
            }
            return geometricSequence;
        }

        for (int i = 1; i < sequence.length; i++) {
            if (sequence[i] == 0) return false;
        }

        double constGeometric = (double) sequence[1] / sequence[0];

        for (int j = 2; j < sequence.length; j++) {
            if (sequence[j - 1] == 0) return false;
            if ((double) sequence[j] / sequence[j - 1] != constGeometric) {
                geometricSequence = false;
                break;
            }
        }
        return geometricSequence;
    }
}
