package tasks;

import scala.Char;

import java.util.HashSet;
import java.util.Scanner;

public class StringReversal {

	public static String stringReversal(String s) {
		char eliminateCh1 = ' ';
		HashSet<Character> seenCharacter = new HashSet<Character>();
		StringBuilder sb = new StringBuilder();

		for (int i = s.length() - 1; i >= 0; i--) {
			char current = s.charAt(i);
			if (current != eliminateCh1 && !seenCharacter.contains(current)) {
				seenCharacter.add(current);
				sb.append(current);
			}
		}

		return sb.toString();
	}


	public static void readInput() {
		Scanner scanner = new Scanner(System.in);

		int numberOfTestCases = scanner.nextInt();
		scanner.nextLine();
		int i = 0;
		while (i < numberOfTestCases) {
			String line = scanner.nextLine();
			System.out.println(stringReversal(line));
			i++;
		}
	}

	public static void main(String[] args) {
		readInput();
	}

}
