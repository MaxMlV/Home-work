package utilPackages.myToString;

public class MyToString {

    public static String newToString(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int arrElem : arr) {
                stringBuilder.append(arrElem + ",");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(",")).append("]");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 6, 5, 2, 4};
        System.out.println(newToString(numbers));
    }
}
