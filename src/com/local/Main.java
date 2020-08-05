package com.local;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> elements = new ArrayList<>(Arrays.asList("Мама", "Мыла", "Раму"));
		if (elements.size() > 10) {
			System.out.println("Sorry, we are not working with more, than 10 elements.");
			System.exit(1);
		}
		long numberOfResults = factorialCount(elements.size());
		long repeatedNumbers = factorialCount(elements.size() - 1);
		String[][] array = new String[(int) (repeatedNumbers * elements.size())][elements.size()];
		// System.out.println("Number of combinations: " + numberOfResults);
		for (int i = 0; i < elements.size(); ++i) {
			int pos = 0;
			int index = 0;
			for (int j = 0; j < (repeatedNumbers * elements.size()); ++j) {

				while (!uniqueCheck(array, j, elements.get(pos))) {
					++pos;
					if (pos >= elements.size()) {
						pos = 0;
					}
				}
				++index;
				array[j][i] = elements.get(pos);

				long counter = factorialCount((elements.size() - 1) - i) - index;

				if (counter == 0) {
					++pos;
					if (pos >= elements.size()) {
						pos = 0;
					}
					index = 0;
				}

			}
		}
		printArray(elements, repeatedNumbers, array);
	}

	private static long factorialCount(long n) {
		if (n <= 2) {
			return n;
		}
		return n * factorialCount(n - 1);
	}

	private static void printArray(List<String> elements, long repeatedElements, String[][] array) {
		for (int i = 0; i < (repeatedElements * elements.size()); ++i) {
			for (int j = 0; j < elements.size(); ++j) {
				System.out.print(array[i][j]);

			}
			System.out.println();
		}

	}

	private static boolean uniqueCheck(String[][] array, int j, String elementToCheck) {
		String toCheck = "";
		for (int i = 0; i < array[j].length; ++i) {
			toCheck = toCheck.concat((String.valueOf(array[j][i])));
		}
		if (toCheck.contains(String.valueOf(elementToCheck))) {
			return false;
		}
		return true;
	}
}