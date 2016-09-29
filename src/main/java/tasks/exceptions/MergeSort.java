package tasks.exceptions;

public class MergeSort {

    public static void main(String[] args) {
        int[] tmp = new int[]{4,5,6,1,3,2};

//        merge(tmp, 0, tmp.length / 2, tmp.length - 1);
        sort(tmp);
        print(tmp);
    }

    public static void print(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void sort(int arr[]) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int low, int high) {
        if (high - low < 1) {
            return;
        }

        int mid = low + (high - low) / 2;
        sort(arr, low, mid);
        sort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int arr[], int low, int mid, int high) {
        int[] tempArray = new int[high+1];
            int i = low;
            int j = mid+1;
        for (int k = low; k <= high; k++) {
            if (i == mid + 1) {
                tempArray[k] = arr[j++];
            } else if (j == high + 1) {
                tempArray[k] = arr[i++];
            } else if (arr[i] < arr[j]) {
                tempArray[k] = arr[i++];
            } else {
                tempArray[k] = arr[j++];
            }
        }

        for (int q = low; q <= high; q++) {
            arr[q] = tempArray[q];
        }
    }


    private  static void merge(int[] arr) {

    }
}
