package tasks;

public class MaximumSumIncreasingSubsequence {

    public int findMaxSum(int[] seq) {
        int tmp[] = new int[seq.length];

        for (int i = 0; i < seq.length; i++) {
            tmp[i] = seq[i];
        }

        for (int i = 1; i < seq.length; i++) {
            for(int j = 0; j < i; j++) {
                if (seq[i] > seq[j] && tmp[i] < tmp[j] + seq[i]) {
                    tmp[i] = tmp[j] + seq[i];
                }

            }
        }

        int max = 0;

        for(int i = 0; i < seq.length; i++) {
            max = Math.max(tmp[i], max);
        }


        return max;
    }


    public static void main(String[] args) {
        MaximumSumIncreasingSubsequence m = new MaximumSumIncreasingSubsequence();

        System.out.println(m.findMaxSum(new int[]{1, 101, 2, 3, 100, 4, 5})); // 106
        System.out.println(m.findMaxSum(new int[]{3, 4, 5, 10})); // 22
        System.out.println(m.findMaxSum(new int[]{10, 5, 4, 3})); // 10
        System.out.println(m.findMaxSum(new int[]{3, 2, 6, 4, 5, 1})); // 2 + 4 + 5 = 11
        System.out.println(m.findMaxSum(new int[]{1,101,2,3,4,5,1000})); // 1102

    }
}
