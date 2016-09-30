package tasks;

import java.util.Collections;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{10,9,8,7,6,5,4,3,2,1};

        sort(arr);

        print(arr);
    }

    public static void print(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static  void sort(int[] arr, int lo, int high) {
        if (high <= lo) {
            return;
        }

        int pos = partition(arr, lo, high);

        sort(arr, lo, pos-1);
        sort(arr, pos+1, high);
    }

    private static int partition(int[] arr, int lo, int high) {
        int p = arr[lo];
        int i = lo+1;
        int j = high;
        while(true) {

            while (i < high && arr[i] < p) { i++;}
            while(j > lo && arr[j] > p) {j--;}

            if (i >= j) break;
            swap(arr, i, j);
        }

        swap(arr, j, lo);

        return j;
    }


    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
