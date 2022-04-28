package exercise_1;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class HIndex302 {

	public static void main(String[] args) throws FileNotFoundException {
		// get inputs
		Scanner scanner = new Scanner(System.in);
		int[] citations = new int[100];
		String[] strs;
		System.out.println("Please input the citation numbers:");

		String line = new String();
		/*******处理小于0，非法字符等*******/
		// loop, until user inputs legal string
		while (true) {
			line = scanner.nextLine();
			// if the input is empty
			if (line.length() == 0) {
				System.out.println("Input empty, please re-input:");
				continue;
			}

			// check if each part is integer >= 0
			boolean legalNumbers = true;
			strs = line.split(",");
			for (int i = 0; i < strs.length; i++) {
				// if not, stop checking others and let user re-input
				if (!strs[i].matches("[0-9]+")) {
					System.out.println(strs[i] + " is illegal, please re-input: ");
					legalNumbers = false;
					break; //结束for循环
				}
				// otherwise, store the integer into array
				citations[i] = Integer.parseInt(strs[i]);
			}
			if (!legalNumbers)
				continue;
			else {
				//看下转换后的引用结果是否正确
				printCitations(citations);

				sort(citations);

				//看下排序后的引用结果
				printCitations(citations);

				hindex(citations);


				break;
			}

		}
		scanner.close();

	}

	/**
	 * @param citations
	 * @return
	 */
	private static void printCitations(int[] citations) {
		System.out.println();
		for (int citation : citations) {
			System.out.print(citation+" ");
		}
	}

	/**
	 * @param citations
	 */
	private static int hindex(int[] citations) {
		//calculate H-Index
		int number=citations.length;
		int hindex = 0;
		for (int j = 0; j < number; j++) {
			if (citations[j] >= j + 1)
				hindex = j + 1;
			else
				break;
		}
		//output to console
		System.out.println("\nThe h-index is: " + hindex);
		return hindex;
	}

	/**
	 * @param citations
	 * @return
	 */
	private static void sort(int[] citations) {
		// Bubble Sort
		int number=citations.length;
		int temp;
		for (int i = 0; i < number - 1; i++) {
			for (int j = 0; j < number - i - 1; j++) {
				if (citations[j] < citations[j + 1]) {
					temp = citations[j + 1];
					citations[j + 1] = citations[j];
					citations[j] = temp;
				}
			}
		}
	}

}
