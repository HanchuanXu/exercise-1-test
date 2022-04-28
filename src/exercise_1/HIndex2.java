package exercise_1;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class HIndex2 {

	public static void main(String[] args) throws FileNotFoundException {
		//get inputs from console
		Scanner scanner = new Scanner(System.in);
		int[] citations = new int[100];
		String[] strs;
		System.out.println("Please input the citation numbers:");
		String line = scanner.nextLine();
		strs = line.split(",");
		for (int i = 0; i < strs.length; i++)
			citations[i] = Integer.parseInt(strs[i]);
		

//		// 从文件读入
//		String line = "";
//		File file = new File(".\\src\\input.txt");
//		Scanner scanner = new Scanner(file);
//		if (scanner.hasNextLine()) {
//			line = scanner.nextLine();
//		}
//		int[] citations = new int[100];
//		String[] strs;
//		strs = line.split(",");
//		for (int i = 0; i < strs.length; i++)
//			citations[i] = Integer.parseInt(strs[i]);


		//看下转换后的引用结果是否正确
		printCitations(citations);

		sort(citations);

		//看下排序后的引用结果
		printCitations(citations);

		hindex(citations);

		scanner.close();

	}

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
	 *
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
