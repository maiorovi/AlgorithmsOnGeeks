package tasks;

public class QuickSelect {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 10, 4, 3, 20, 15};

        System.out.println(quickSelect(arr, 3));
        System.out.println(kthMaxElem(arr, 3));
    }

    public static int kthMaxElem(int[] arr, int requiredPosition) {
        return quickSelect(arr, 0, arr.length - 1, arr.length - requiredPosition );
    }

    public static int quickSelect(int[] arr, int requiredPosition) {
        return quickSelect(arr, 0, arr.length - 1, requiredPosition - 1);
    }

    private static int quickSelect(int[] arr, int low, int high, int requiredPosition) {
        if (high <= low) {
            return arr[low];
        }

        int currentPosition = QuickSort.partition(arr, low, high);

        if (requiredPosition > currentPosition) {
            return quickSelect(arr, currentPosition+1, high, requiredPosition);
        }  else if(requiredPosition < currentPosition) {
            return quickSelect(arr, low, currentPosition - 1, requiredPosition);
        } else {
            return arr[currentPosition];
        }
    }

}
