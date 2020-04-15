package methods.numberCombinations;

import java.util.Arrays;

public class NumberCombinations {

    public static void calculateCombinations(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                System.out.println(Arrays.toString(arr));
                int tmp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        calculateCombinations(numbers);
    }
}
