package methods.numberProgression;

import java.util.Scanner;

public class NumberProgression {

    public static void parseInt(String[] str, int[] num) {
        for (int i = 0; i < str.length; i++) {
            num[i] = Integer.parseInt(str[i]);
        }
    }

    public static int calculatePlusProgression(int[] num) {
        int indexProgression = num[1] - num[0];
        for (int i = 0; i < num.length - 1; i++) {
            if (num[i] + indexProgression == num[i + 1] && i == num.length - 2) {
                return num[i + 1] + indexProgression;
            }
        }
        return 0;
    }

    public static int calculateMultiplyProgression(int[] num) {
        int indexProgression = num[1] / num[0];
        for (int i = 0; i < num.length - 1; i++) {
            if (num[i] * indexProgression == num[i + 1] && i == num.length - 2) {
                return num[i + 1] * indexProgression;
            }
        }
        return 0;
    }

    public static int calculatePowerProgression(int[] num) {
        int indexProgression = 1;
        int isPower = num[1];
        while (isPower != 2) {
            isPower = isPower / 2;
            indexProgression++;
        }
        for (int i = 1; i <= num.length; i++) {
            if ((int) Math.pow(i, indexProgression) == num[i - 1] && i == num.length) {
                return (int) Math.pow(i+1, indexProgression);
            }
        }
        return 0;
    }


    public static int whichProgression(int[] num, String text) {
        int solution = 0;
        if (calculatePlusProgression(num) > 0) {
            solution = calculatePlusProgression(num);
        } else if (calculateMultiplyProgression(num) > 0) {
            solution = calculateMultiplyProgression(num);
        } else if (calculatePowerProgression(num) > 0) {
            solution = calculatePowerProgression(num);
        } else {
            solution = -1;
        }
        System.out.println(text);
        return solution;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number progression.");
        String strNumbers = scanner.nextLine();
        String[] clearStr = strNumbers.split(",");
        int[] numbers = new int[clearStr.length];
        parseInt(clearStr, numbers);
        System.out.println(whichProgression(numbers, "If you see number '-1', it means progression is incorrect."));
    }
}
