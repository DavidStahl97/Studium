public class MergeSortThread extends Thread {

    private long[] array;
    private long[] sortArray;
    private int left;
    private int right;

    public MergeSortThread(long[] array, int left, int right, long[] sortArray) {
        this.array = array;
        this.left = left;
        this.right = right;
        this.sortArray = sortArray;
    }

    @Override
    public void run() {
        mergeSort(array, left, right);
        storeSortedArray();
    }

    private synchronized void storeSortedArray() {
        for(int i = 0; i < right - left; i++) {
            sortArray[left + i] = array[left + i];
        }
    }

    // Merges two subarrays of arr[].
// First subarray is arr[l..m]
// Second subarray is arr[m+1..r]
    private void merge(long arr[], int l, int m, int r)
    {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 =  r - m;

        /* create temp arrays */
        long[] L = new long[n1];
        long[] R = new long[n2];

        /* Copy data to temp arrays L[] and R[] */
        for (i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (j = 0; j < n2; j++)
            R[j] = arr[m + 1+ j];

        /* Merge the temp arrays back into arr[l..r]*/
        i = 0; // Initial index of first subarray
        j = 0; // Initial index of second subarray
        k = l; // Initial index of merged subarray
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

    /* Copy the remaining elements of L[], if there
       are any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

    /* Copy the remaining elements of R[], if there
       are any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    /* l is for left index and r is right index of the
       sub-array of arr to be sorted */
    private void mergeSort(long arr[], int l, int r)
    {
        if (l < r)
        {
            // Same as (l+r)/2, but avoids overflow for
            // large l and h
            int m = l+(r-l)/2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);

            merge(arr, l, m, r);
        }
    }
}
