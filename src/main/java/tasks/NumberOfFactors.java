package tasks;

import java.util.Scanner;

public class NumberOfFactors {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t > 0) {
            int q = sc.nextInt();
            System.out.println(numberOfPrimes(q));
            t--;
        }
    }

    public static int numberOfPrimes(int n) {
        int factorCount = 2;

        for (int i = 2; i < n - 1; i++) {
            if (n % i == 0) {
                factorCount++;
            }
        }

        return factorCount;
    }
}
