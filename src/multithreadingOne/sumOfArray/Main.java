package multithreadingOne.sumOfArray;

public class Main {
    public static void main(String[] args) {
        int n = 1000;
        int[] numbers = new int[90000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 90000);
        }

        int part = numbers.length / n;
        int endMarker = part;

        ThreadSum[] threadSums = new ThreadSum[n];
        Thread[] threads = new Thread[n];

        long startTimeMultithreading = System.currentTimeMillis();

        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                threadSums[i] = new ThreadSum(numbers, (endMarker - part), numbers.length);
            } else {
                threadSums[i] = new ThreadSum(numbers, (endMarker - part), endMarker);
                endMarker += part;
            }
            threads[i] = new Thread(threadSums[i]);
            threads[i].start();
        }

        for (int i = 0; i < n; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += threadSums[i].getTotal();
        }

        long multithreadingSpeed = System.currentTimeMillis() - startTimeMultithreading;

        System.out.println("Sum by multithreading: " + sum + "(time: " + multithreadingSpeed + "ms).");


        long simpleSum = 0;

        long simpleStartTime = System.currentTimeMillis();

        for (int i = 0; i < numbers.length; i++) {
            simpleSum += numbers[i];
        }

        long simpleSpeed = System.currentTimeMillis() - simpleStartTime;

        System.out.println();
        System.out.println("Sum by single thread: " + simpleSum + " (time: " + simpleSpeed + "ms).");
    }
}
