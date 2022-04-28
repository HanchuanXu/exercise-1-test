package exercise_1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HIndex303 {

	public static void main(String[] args) throws FileNotFoundException {
		// get inputs
		Scanner scanner = new Scanner(System.in);
		//int[] citations = new int[100];
		List<Integer> citations = new ArrayList<>();
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
				//citations[i] = Integer.parseInt(strs[i]);
				citations.add(Integer.parseInt(strs[i]));
			}
			if (!legalNumbers)
				continue;
			else {
				//看下转换后的引用结果是否正确
				printCitations(citations);
				System.out.println("\nThe h-index is: "+hindex(citations));

				break;
			}

		}
		scanner.close();

	}

	/**
	 * @param citations
	 * @return
	 */
	private static void printCitations(List<Integer> citations) {
		System.out.println();
		for (Integer citation : citations) {
			System.out.print(citation+" ");
		}
	}

	/**
	 * @param citations
	 */
	public static int hindex(List<Integer> citations) {
		//Integer[] array1 = (Integer[])citations.toArray();
		int[] array2 = new int[citations.size()];
		for(int i=0; i<citations.size(); i++)
			array2[i] = citations.get(i);

		// 冒泡排序
		sort(array2);

		// 计算h-index
		int hindex = 0;
		for (int j = 0; j < array2.length; j++) {
			if (array2[j] >= j + 1)
				hindex = j + 1;
			else
				break;
		}
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
