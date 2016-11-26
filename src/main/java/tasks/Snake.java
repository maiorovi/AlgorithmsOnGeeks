package tasks;

import java.util.Arrays;

public class Snake {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        int[][] matrix1 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int[][] matrix2 = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };

        System.out.println(Arrays.toString(printSnake(matrix)));
    }

    public static int[] printSnake(int matrix[][]) {
        int answer[] = new int[matrix.length * matrix.length];
        int m = matrix.length;
        int n = matrix[0].length;
        int k = 0, r = 0, c = 0;


        while (r < m && c < n) {

            for (int i = c; i < n - 1; i++) {
                answer[k++] = matrix[r][i];
            }

            for(int i = r; i < m - 1; i++) {
                answer[k++] = matrix[i][m-1];
            }

            for (int i = n - 1; i > r; i--) {
                answer[k++] = matrix[m-1][i];
            }


            for(int i = m - 1; i > c; i--) {
                answer[k++] = matrix[i][c];
            }

            r++;
            c++;
            m--;
            n--;
        }


        if (matrix.length % 2 != 0) {
            answer[answer.length - 1] = matrix[matrix.length / 2][matrix[0].length / 2];
        }



        return answer;
    }
}
