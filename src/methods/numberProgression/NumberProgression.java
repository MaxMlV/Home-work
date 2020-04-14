package methods.numberProgression;

import java.util.Scanner;

public class NumberProgression {

    public static void parseInt(String[] str, int[] num) {
        for (int i = 0; i < str.length; i++) {
            num[i] = Integer.parseInt(str[i]);
        }
    }

    public static int plusProgression(int[] num) {
        for (int i = 0; i < num.length; i++) {
            if (num[i] + 2 == num[i+1] && i <= num.length-2) {
                if (i == num.length-3) {
                    num[num.length-1] = num[i+1] + 2;
                    break;
                } else {
                    continue;
                }
            } else if (num[i] + 3 == num[i+1] && i <= num.length-2) {
                if (i == num.length-3) {
                    num[num.length-1] = num[i+1] + 3;
                    break;
                } else {
                    continue;
                }
            } else {
                break;
            }
        }
        return num[num.length-1];
    }

    public static int whichProgression(int[] num) {
        int solution = 0;
        if (plusProgression(num) > 0) {
            solution = plusProgression(num);
        } else {
            solution = -1;
        }
        return solution;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number progression.");
        String strNumbers = scanner.nextLine();
        String[] clearStr = strNumbers.split(",");
        int[] numbers = new int[clearStr.length+1];
        parseInt(clearStr, numbers);
        System.out.println(whichProgression(numbers));
    }
}
