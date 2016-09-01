package tasks;

public class MaximumSumIncreasingSubsequence {

    public int findMaxSum(int[] seq) {
        int max = seq[0];
        int currentMaxValue = seq[0];
        int prevMaxValue = -1;

        for (int i = 1; i < seq.length; i++) {
            if (currentMaxValue < seq[i]) {
                max += seq[i];
                prevMaxValue = currentMaxValue;
                currentMaxValue = seq[i];

            } else {
                int prevSum = max - seq[i - 1];
                if (shouldThePrevDigitNeedToBeSkipped(max, max - seq[i - 1], i, seq)) {
                    max = max - seq[i - 1];
                    currentMaxValue = prevMaxValue;
                    i--;
                } else {
                    break;
                }
            }
        }

        return max;
    }

    private boolean shouldThePrevDigitNeedToBeSkipped(int currentSum, int prevSumWithoutLastElem, int startPoint, int[] seq) {
        int futureMax = seq[startPoint];
        int i = startPoint + 1;

        while (i < seq.length && seq[i-1] < seq[i]) {
            futureMax += seq[i];
            i++;
        }

        return currentSum < prevSumWithoutLastElem + futureMax;
    }

    public static void main(String[] args) {
        MaximumSumIncreasingSubsequence m = new MaximumSumIncreasingSubsequence();

        System.out.println(m.findMaxSum(new int[]{1, 101, 2, 3, 100, 4, 5})); // 106
        System.out.println(m.findMaxSum(new int[]{3, 4, 5, 10})); // 22
        System.out.println(m.findMaxSum(new int[]{10, 5, 4, 3})); // 10
        System.out.println(m.findMaxSum(new int[]{3, 2, 6, 4, 5, 1})); // 2 + 4 + 5 = 11
    }
}
