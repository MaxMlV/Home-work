package multithreadingOne.sumOfArray;

public class ThreadSum implements Runnable {
    private int[] numbers;
    private int startMarker;
    private int endMarker;
    private long total;

    public ThreadSum(int[] numbers, int startMarker, int endMarker) {
        this.numbers = numbers;
        this.startMarker = startMarker;
        this.endMarker = endMarker;
        this.total = 0;
    }

    public ThreadSum() {
        super();
    }

    public long getTotal() {
        return total;
    }

    private long sum(int[] numbers, int startMarker, int endMarker) {
        for (int i = startMarker; i < endMarker; i++) {
            total += numbers[i];
        }
        return total;
    }

    @Override
    public void run() {
        sum(numbers, startMarker, endMarker);
    }
}
