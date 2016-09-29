package tasks;

public class InsertionSort {

    public static void main(String[] args) {
        int[] qwert = new int[]{10,9,8,7,1,2,12,13,5,3};

        sort(qwert);
        print(qwert);
    }

    public static void print(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    public static void sort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int j = i;
            while(j > 0 && arr[j] < arr[j-1]) {
                exch(arr, j-1, j);
                j--;
            }
        }
    }

    public static void exch(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
