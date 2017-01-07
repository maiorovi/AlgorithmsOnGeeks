package tasks;

import java.util.Arrays;
import java.util.Scanner;

public class MoveAllNegativeElementsToEnd {

	public static void main(String[] args) {
		readInput();
	}

	public static int[] doJob(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int key = arr[i];

			if (arr[i] < 0) {
				continue;
			}

			int j = i - 1;

			while(j >= 0 && arr[j] < 0) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}

			arr[j+1] = key;
		}

		return arr;
	}

	public static void readInput() {
		Scanner scanner = new Scanner(System.in);

		int numberOfTestCases = scanner.nextInt();
		scanner.nextLine();
		int i = 0;
		while (i < numberOfTestCases) {
			int size = scanner.nextInt();
			scanner.nextLine();
			int[] tmp = toArray(scanner.nextLine(), "\\s", size);

			System.out.println(Arrays.toString(doJob(tmp)).replaceAll("\\[|\\]", "").replaceAll(",", ""));

			i++;
		}
	}
//42
//		-33 34 0 69 24 -22 58 62 -36 5 45 -19 -73 61 -9 95 42 -73 -64 91 -96 2 53 -8 82 -79 16 18 -5 -53 26 71 38 -31 12 -33 -1 -65 -6 3 -89 22

	public static int[] toArray(String s, String delimiter, int size) {
		int[] temp = new int[size];

		String[] splitted = s.split(delimiter);

		for (int i = 0; i < size; i++) {
			temp[i] = Integer.parseInt(splitted[i]);
		}

		return temp;
	}
}
