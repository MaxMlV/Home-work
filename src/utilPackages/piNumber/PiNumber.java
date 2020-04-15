package utilPackages.piNumber;

import java.util.Formatter;

public class PiNumber {
    public static void main(String[] args) {
        Formatter formatter = new Formatter();
        for (int i=2; i<12;i++){
            formatter.format("%." + i + "f" + "\n", Math.PI);
        }
        System.out.println(formatter.toString());
    }
}
