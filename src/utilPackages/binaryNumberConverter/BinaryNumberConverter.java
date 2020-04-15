package utilPackages.binaryNumberConverter;

import java.util.Scanner;

public class BinaryNumberConverter {

    public static int converter(String binaryNumber) {
        int number = 0;
        char[] binaryArray = binaryNumber.toCharArray();
        for (int i=0; i<binaryArray.length;i++){
            if (binaryArray[i]=='1') {
                number+=Math.pow(2,binaryArray.length-i-1);
            }
        }
        return number;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input binary number");
        String binaryNumber = scanner.nextLine();

        System.out.println(converter(binaryNumber));
    }
}
