package assignment2.measure;

//import java.util.Hashtable;

public class MyMeasure implements A2Measure {

	public MyMeasure() {

	}

	@Override
	public boolean isSameCollection(int[] array1, int[] array2) {
		if (array1.length != array2.length)
			return false;

		MyModifiedHashTable<Integer, Integer> hashtable = new MyModifiedHashTable<Integer, Integer>();
		int count = 0;
		for (int i = 0; i < array1.length; i++) {
			if (hashtable.get(array1[i]) == null)
				hashtable.insert(array1[i], 1);
			else {
				count = hashtable.get(array1[i]) + 1;
				hashtable.insert(array1[i], count);
			}
		}

		for (int i = 0; i < array1.length; i++) {
			if (!hashtable.contains(array2[i]))
				return false;

			if (hashtable.get(array2[i]) == 0)
				return false;

			count = hashtable.get(array2[i]) - 1;
			hashtable.insert(array2[i], count);
		}

		for (int i = 0; i < array1.length; i++) {
			count = hashtable.get(array1[i]);
			if (count > 0)
				return false;
		}
		return true;
	}

	// public boolean isSameCollection0(int[] array1, int[] array2) {
	// if(array2.length > array1.length)
	// return false;
	//
	// int[] sortedArray1 = mergeSort(array1);
	// int[] sortedArray2 = mergeSort(array2);
	// int arr2Index = 0;
	// for (int i = 0 ; i< sortedArray1.length; i++) {
	// if (sortedArray2[arr2Index] < sortedArray1[i]) {
	// return false;
	// }
	// else if (sortedArray2[arr2Index] == sortedArray1[i]) {
	// arr2Index++;
	// if (arr2Index == sortedArray2.length)
	// return true;
	// }
	// }
	// return false;
	// }

	// public boolean isSameCollection2(int[] array1, int[] array2) {
	// if(array2.length > array1.length)
	// return false;
	//
	// int[] sortedArray1 = mergeSort(array1);
	// int[] sortedArray2 = mergeSort(array2);
	// int arr1Index = 0;
	// for (int i = 0 ; i< sortedArray2.length; i++) {
	// int num = sortedArray2[i];
	// boolean numIsFound = false;
	// while (arr1Index<sortedArray1.length && sortedArray1[arr1Index]<=num &&
	// !numIsFound) {
	// if (sortedArray1[arr1Index++] == num) {
	// numIsFound = true;
	// }
	// }
	// if (!numIsFound)
	// return false;
	// }
	//
	// return true;
	// }

	@Override
	public int minDifferences(int[] array1, int[] array2) {
		if (array2.length != array1.length)
			return 0;

		int[] sortedArray1 = mergeSort(array1);
		int[] sortedArray2 = mergeSort(array2);
		int totalDiff = 0;
		for (int i = 0; i < sortedArray1.length; i++) {
			totalDiff += (sortedArray1[i] - sortedArray2[i]) * (sortedArray1[i] - sortedArray2[i]);
		}
		return totalDiff;
	}

	@Override
	public int[] getPercentileRange(int[] arr, int lower, int upper) {
		int[] sortedArr = mergeSort(arr);
		int lowIndex = lower * sortedArr.length / 100;
		int highIndex = (upper * sortedArr.length / 100);
		int[] result = new int[highIndex - lowIndex];
		for (int i = lowIndex; i < highIndex; i++)
			result[i - lowIndex] = sortedArr[i];

		return result;
	}

	public int[] mergeSort(int[] in) {
		if (in.length < 2) // if empty or one element; no need to sorting
			return in;
		else {
			int[] left = new int[in.length / 2];
			int[] right = new int[in.length - left.length];
			for (int i = 0; i < in.length; i++) { // Divide the array into two parts
				if (i < left.length)
					left[i] = in[i];
				else
					right[i - left.length] = in[i];
			}

			left = mergeSort(left); // sort the first part
			right = mergeSort(right); // sort the second part

			return merge(left, right); // merge the two parts in one array
		}
	}

	// method to merge two array in one array, with maintaining the ascending order
	private int[] merge(int[] left, int[] right) {
		int[] tmp = new int[left.length + right.length]; // new integer array
		int indexLeft = 0, indexRight = 0, indexTmp = 0; // Indexes

		while (indexLeft < left.length && indexRight < right.length && left.length > 0 && right.length > 0) { // first
																												// "while"
																												// to
																												// copy
																												// the
																												// elements
																												// from
																												// the
																												// tow
																												// arrays
																												// to
																												// the
																												// final
																												// array
																												// "tmp"
																												// (after
																												// compare
																												// them)
			if (left[indexLeft] < right[indexRight])
				tmp[indexTmp++] = left[indexLeft++];
			else
				tmp[indexTmp++] = right[indexRight++];
		}

		while (indexLeft < left.length && left.length > 0) // second "while" to copy all the remaining elements in the
															// first array "left" to the final array "tmp".
			tmp[indexTmp++] = left[indexLeft++];

		while (indexRight < right.length && right.length > 0) // third "while" to copy all the remaining elements in the
																// second array "right" to the final array "tmp".
			tmp[indexTmp++] = right[indexRight++];

		return tmp;

	}

}
