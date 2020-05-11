package multithreads.factorialThreadArray;

import java.math.BigInteger;

public class ThreadFactorial implements Runnable {
    private int number;

    public ThreadFactorial(int number) {
        this.number = number;
    }

    public ThreadFactorial() {
        super();
    }

    public int getNumber() {
        return number;
    }

    private BigInteger calculateFactorial(int number) {
        BigInteger factorial = new BigInteger("" + number);
        if (factorial.equals("1")) {
            return new BigInteger("1");
        } else {
            return factorial.multiply(new BigInteger("" + (number-1)));
        }
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("!" + number + "  =  " + calculateFactorial(number));
    }
}
