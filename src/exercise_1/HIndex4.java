package exercise_1;

import java.util.ArrayList;
import java.util.List;

public class HIndex4 {

	private List<Integer> citations = new ArrayList<>();

	public HIndex4(String input) {
		if (input == null || input.length() == 0)
			throw new IllegalArgumentException("Empty");

		dealInput(input);
	}

	private void dealInput(String input) {

		String[] strs = input.split(",");

		for (int i = 0; i < strs.length; i++) {
			if (!strs[i].matches("[0-9]+"))
				throw new IllegalArgumentException(strs[i] + " is illegal");

			citations.add(Integer.parseInt(strs[i]));
		}
	}

	public static void main(String[] args) {
		
		String[] inputs = new String[] {"1,0","3,2,4,8"};
		for(int i=0;i<inputs.length;i++) {
			HIndex4 h = new HIndex4(inputs[i]);
			System.out.println(h.calcHIndex());
		}

	}

	/**
	 * @param
	 * @return
	 */
	public int calcHIndex() {
		// Integer[] array1 = (Integer[])citations.toArray();
		int[] array2 = new int[citations.size()];
		for (int i = 0; i < citations.size(); i++)
			array2[i] = citations.get(i);

		// ð������
		sort(array2);

		// ����h-index
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
	 */
	private static void sort(int[] citations) {
		// Bubble Sort
		int number = citations.length;
		for (int i = 0; i < number - 1; i++) {
			for (int j = 0; j < number - i - 1; j++) {
				if (citations[j] < citations[j + 1]) {
					int temp = citations[j + 1];
					citations[j + 1] = citations[j];
					citations[j] = temp;
				}
			}
		}
	}

}
