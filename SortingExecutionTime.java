import java.util.Arrays;
import java.util.Random;

public class SortingExecutionTime
{
    public static void main(String[] args)
    {
        int[] sizes = {50000, 100000, 150000, 200000, 250000, 300000};
        System.out.printf("%-15s%-20s%-20s%-20s\n", "Array Size", "Selection Sort", "Bubble Sort", "Merge Sort");

        for (int size : sizes)
        {
            int[] data = createRandomArray(size);

            // Selection sort
            int[] selectionSortData = Arrays.copyOf(data, data.length);
            long selectionSortTime = executionTime(() -> selectionSort(selectionSortData));

            // Bubble sort
            int[] bubbleSortData = Arrays.copyOf(data, data.length);
            long bubbleSortTime = executionTime(() -> bubbleSort(bubbleSortData));

            // Merge sort
            int[] mergeSortData = Arrays.copyOf(data, data.length);
            long mergeSortTime = executionTime(() -> mergeSort(mergeSortData));

            System.out.printf("%-15d%-20d%-20d%-20d\n", size, selectionSortTime, bubbleSortTime, mergeSortTime);
        }
    }

    private static int[] createRandomArray(int size)
    {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
        {
            arr[i] = random.nextInt();
        }
        return arr;
    }

    private static long executionTime(Runnable task)
    {
        long startTime = System.nanoTime();
        task.run();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Selection sort implementation
    public static void selectionSort(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            int minIndex = i;
            for (int j  = i + 1; j < arr.length; j++)
            {
                if (arr[j] < arr[minIndex])
                {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }        
    }

    // Bubble sort implementation
    public static void bubbleSort(int[] arr)
    {
        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++)
        {
            swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Merge sort implementation
    public static void mergeSort(int arr[])
    {
        if (arr.length > 1)
        {
            int mid = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);

            mergeSort(left);
            mergeSort(right);

            merge(arr, left, right);
        }
    }

    public static void merge(int arr[], int[] left, int[] right)
    {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length)
        {
            if (left[i] <= right[j])
            {
                arr[k++] = left[i++];
            }
            else
            {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length)
        {
            arr[k++] = left[i++];
        }

        while (j < right.length)
        {
            arr[k++] = right[j++];
        }
    }
}
