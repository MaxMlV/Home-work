package multithreadingOne.shellSort;

public class SortThread implements Runnable {
    private int[] arr;
    private int step;
    private int inner;

    public SortThread(int[] arr, int step, int inner) {
        this.arr = arr;
        this.step = step;
        this.inner = inner;
    }

    public int[] getArr() {
        return arr;
    }

    public int getStep() {
        return step;
    }

    public int getInner() { return inner; }

    private int[] shellSort() {
        for (int i = inner; i < arr.length-step; i += step) {
            int j = i;
            while (j >= 0 && arr[j+step] < arr[j]) {
                int temp = arr[j];
                arr[j] = arr[j+step];
                arr[j+step] = temp;
                j -= step;
            }
        }
        return arr;
    }

    @Override
    public void run() {
        shellSort();
    }
}
