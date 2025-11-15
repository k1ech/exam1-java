package zadanie2;

public class SequenceNumbers {

    public static void main(String[] args) {

        int[] sequence = {2, 4, 8, 16, 32};
        int[] sequence1 = {2, 4, 6, 8, 10};
        int[] sequence2 = {10, 8, 2, 5, 6};

        System.out.println(getSequenceName(sequence));
        System.out.println(getSequenceName(sequence1));
        System.out.println(getSequenceName(sequence2));

    }


    public static String getSequenceName(int[] sequence) {


        boolean arithmeticSequence = true;
        boolean geometricSequence = true;

        if (sequence.length < 2) {
            return "Ciąg jest zawsze geometryczny";
        }

        int constArithmetical = sequence[1] - sequence[0];
        int constGeometric = sequence[1] / sequence[0];

        for (int i = 2; i < sequence.length; i++) {
            if (sequence[i] - sequence[i - 1] != constArithmetical) {
                arithmeticSequence = false;
                break;
            }
        }

            for (int j = 2; j < sequence.length; j++) {
                if (sequence[j] / sequence[j - 1] != constGeometric) {
                    geometricSequence = false;
                    break;
                }
            }

        if (arithmeticSequence) return "Ciąg jest arytmetyczny";
        if (geometricSequence) return "Ciąg jest geometryczny";
        return "Ciąg jest inny";
    }

}
