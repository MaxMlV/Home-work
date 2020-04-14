package methods.maxPalindrome;

public class MaxPalindrome {

    public static boolean isPalindrome(int n) {
        String strNumber = Integer.toString(n);
        char[] charArray = strNumber.toCharArray();
        int[] numbers = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            numbers[i] = Character.getNumericValue(charArray[i]);
        }
        boolean isPalindrome = true;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != numbers[numbers.length-i-1]) {
                isPalindrome = false;
            }
        }
        return isPalindrome;
    }

    public static int findMaxPalindrome() {
        int count = 0;
        for (int i = 100; i <= 999; i++) {
            for (int j = 100; j <= 999; j++) {
                int number = i * j;
                if (isPalindrome(number)) {
                    count++;
                }
            }
        }
        int[] palindromeNumber = new int[count];
        for (int i = 100; i <= 999; i++) {
            int nElem = 0;
            for (int j = 100; j <= 999; j++) {
                int number = i * j;
                if (isPalindrome(number)) {
                    palindromeNumber[nElem] = number;
                    nElem++;
                }
            }
        }
        return maxArrayElement(palindromeNumber);
    }

    public static int maxArrayElement(int[] arr) {
        int maxElem = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (maxElem < arr[i]) {
                maxElem = arr[i];
            }
        }
        return maxElem;
    }

    public static void main(String[] args) {
        System.out.println("Max palindrome number is: " + findMaxPalindrome());
    }
}
