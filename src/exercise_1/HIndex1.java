package exercise_1;

import java.util.Scanner;

public class HIndex1 {


	public static void main(String[] args) {
		// get inputs
		Scanner scanner = new Scanner(System.in);
		int[] citations = new int[100];
		String[] strs;
		System.out.println("Please input the citation numbers:");
		String line = scanner.nextLine();
		strs = line.split(",");
		for (int i = 0; i < strs.length; i++)
			citations[i] = Integer.parseInt(strs[i]);

		// 看下转换后的引用结果是否正确
		for (int citation : citations) {
			System.out.print(citation+" ");
		}

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

		//看下排序后的引用结果
		System.out.println();
		for (int citation : citations) {
			System.out.print(citation+" ");
		}
		
		//calculate H-Index
		int hindex = 0;
		for (int j = 0; j < number; j++) {
			if (citations[j] >= j + 1)
				hindex = j + 1;
			else
				break;
		}
		//output to console
		System.out.println("\nThe h-index is: " + hindex);
		
		scanner.close();

	}

}
