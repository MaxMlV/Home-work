package methods.numberCombinations;

import java.util.Arrays;

public class NumberCombinations {

    public static void calculateCombinations(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                System.out.println(Arrays.toString(array));
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        calculateCombinations(numbers);
    }
}
