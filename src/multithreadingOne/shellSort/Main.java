package multithreadingOne.shellSort;

public class Main {

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j >= 1 && arr[j-1] > temp) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] numbersOne = new int[10000000];
        int n = numbersOne.length;

        for (int i = 0; i < n; i++) {
            numbersOne[i] = (int) (Math.random() * 1000);
        }

        int step = n/4;

        System.out.println();

        long startMulti = System.currentTimeMillis();

        while (step > 1) {
            Thread[] threads = new Thread[step];
            SortThread[] sortThreads = new SortThread[step];
            for (int i = 0; i < step; i++) {
                sortThreads[i] = new SortThread(numbersOne, step, i);
                threads[i] = new Thread(sortThreads[i]);
                threads[i].start();
            }
            for (int i = 0; i < step; i++) {
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < sortThreads.length; i++) {
                numbersOne[i] = sortThreads[i].getInner();
                numbersOne[i+step] = sortThreads[i].getArr()[i+step];
            }
            step /= 4;
        }

        insertionSort(numbersOne);

        System.out.println();
        System.out.println("Multithreaded time: " + (System.currentTimeMillis() - startMulti) + " ms");

        long startSimple = System.currentTimeMillis();

        int[] numbersTwo = new int[10000000];

        for (int i = 0; i < numbersTwo.length; i++) {
            numbersTwo[i] = (int) (Math.random() * 1000);
        }

        insertionSort(numbersTwo);

        System.out.println();
        System.out.println("Single stream time: " + (System.currentTimeMillis() - startSimple) + " ms");
    }
}
