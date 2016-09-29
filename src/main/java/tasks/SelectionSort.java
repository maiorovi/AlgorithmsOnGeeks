package tasks;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,6,5,3,12,10,13,18};

        sort(arr);

        printArray(arr);
    }

    public static void printArray(int[] arr) {
           for (int i = 0; i < arr.length; i++) {
               System.out.print(arr[i] + " ");
           }
    }


    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            int ind = -1;

            for (int j = i; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    ind = j;
                }
            }

            exch(arr, ind, i);
        }
    }

    public static void exch(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
