package tasks;

public class ThirdMaxNumber {

    public int findThirdMaxNumber(int input[]) {
        int first = input[0], second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;

        for (int i = 1; i < input.length; i++) {
            if (input[i] > first) {
                int tmp = first;
                third = second;
                second = tmp;
                first = input[i];
            } else if (input[i] > second) {
                int tmp = second;
                second = input[i];
                third = tmp;
            } else if (input[i] > third) {
                third = input[i];
            }
        }

        return third;
    }
}
