package assignment2.measure;

public class MyMeasureMain {

	public static void main(String[] args) {
		MyMeasure myMeasure = new MyMeasure();
		System.out.println("Test isSameCollection():");
		{
			int[] array1 = { 10, 1, 7, 10 };
			int[] array2 = { 1, 10, 7, 10 };

			System.out.println(myMeasure.isSameCollection(array1, array2));
		}

		{
			int[] array1 = { 10, 1, 7, 9 };
			int[] array2 = { 1, 10, 7, 10 };

			System.out.println(myMeasure.isSameCollection(array1, array2));
		}

		{
			int[] array1 = { 1, 7, 10 };
			int[] array2 = { 1, 10, 7, 7 };

			System.out.println(myMeasure.isSameCollection(array1, array2));
		}
		
		{
			int[] array1 = { 1, 10, 7, 7 };
			int[] array2 = { 1,7,10 };

			System.out.println(myMeasure.isSameCollection(array1, array2));
		}
		
		{
			int[] array1 = { 1, 10, 7, 9 };
			int[] array2 = { 1,7,10 };

			System.out.println(myMeasure.isSameCollection(array1, array2));
		}
		
		System.out.println("");
		System.out.println("Test minDifferences():");

		{
			int[] array1 = { 2,5,3,9 };
			int[] array2 = { 15,12,1,3 };

			System.out.println(myMeasure.minDifferences(array1, array2));
		}
		
		System.out.println("");
		System.out.println("Test getPercentileRange():");

		
		{
			System.out.println("Test1:");

			int[] arr = { 20, 16, 2, 4, 10, 6, 12, 8, 14, 18 };

			printArray(myMeasure.getPercentileRange(arr, 0, 10));
			printArray(myMeasure.getPercentileRange(arr, 10, 20));
			printArray(myMeasure.getPercentileRange(arr, 10, 50));
			printArray(myMeasure.getPercentileRange(arr, 60, 70));
			printArray(myMeasure.getPercentileRange(arr, 0, 100));

		}	
		
		{
			System.out.println("Test2:");

			int[] arr = { 20, 1, 3};

			printArray(myMeasure.getPercentileRange(arr, 0, 50));

		}
	}
	
	
	private static void printArray(int[] arr) {
		System.out.print("Array: ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}

}
