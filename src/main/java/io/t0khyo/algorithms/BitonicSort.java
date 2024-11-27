package io.t0khyo.algorithms;

// عبدالرحمن محمد أحمد الطوخي - D4

public class BitonicSort {

    public static void bitonicSort(int[] arr, boolean ascending) {
        bitonicSortRec(arr, 0, arr.length, ascending);
    }

    private static void bitonicSortRec(int[] arr, int low, int cnt, boolean ascending) {
        if (cnt > 1) {
            int k = cnt / 2;

            bitonicSortRec(arr, low, k, true);
            bitonicSortRec(arr, low + k, k, false);

            bitonicMerge(arr, low, cnt, ascending);
        }
    }

    private static void bitonicMerge(int[] arr, int low, int cnt, boolean ascending) {
        if (cnt > 1) {
            int k = cnt / 2;
            for (int i = low; i < low + k; i++) {
                if ((arr[i] > arr[i + k]) == ascending) {
                    int temp = arr[i];
                    arr[i] = arr[i + k];
                    arr[i + k] = temp;
                }
            }
            bitonicMerge(arr, low, k, ascending);
            bitonicMerge(arr, low + k, k, ascending);
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 4, 8, 6, 2, 1, 5};
        System.out.println("Original Array:");
        printArray(arr);

        bitonicSort(arr, true);

        System.out.println("Sorted Array in Ascending Order:");
        printArray(arr);
    }
}
