import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class MergeSort {

    public static void main(String[] args) throws IOException, InterruptedException {
        var list = new long[50 * 1000 * 1000];

        var start = java.lang.System.currentTimeMillis();
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream("lotsofvalues.txt");
            sc = new Scanner(inputStream, "UTF-8");
            int i = 0;
            while (sc.hasNextLine()) {
                list[i] = Long.parseLong(sc.nextLine());

                i++;
            }
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }
        var end = java.lang.System.currentTimeMillis();
        double differenz = (double)(end - start) / 1000.0;
        System.out.println("Lesen: " + differenz);

        start = java.lang.System.currentTimeMillis();
        parallelSort(list);
        end = java.lang.System.currentTimeMillis();
        differenz = (double)(end - start) / 1000.0;
        System.out.println("Sortieren: " + differenz);
    }

    private static long[] parallelSort(long[] array) throws InterruptedException {
        int size = array.length / 4;
        var sortArray = new long[array.length];

        var threads = new ArrayList<MergeSortThread>();
        for(int i = 0; i < 3; i++) {
            var left = i * size;
            var right = (i + 1) * size - 1;
            var mergeSortThread = new MergeSortThread(array, left, right, sortArray);
            mergeSortThread.start();
            threads.add(mergeSortThread);
        }

        var lastThread = new MergeSortThread(array, 3 * size, array.length - 1, sortArray);
        lastThread.start();
        threads.add(lastThread);

        for(var thread : threads) {
            thread.join();
        }

        return sortArray;
    }

}
