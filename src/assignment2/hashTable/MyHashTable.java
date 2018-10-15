package assignment2.hashTable;

public class MyHashTable<T> implements A2HashTable<T> {
	private int arrSize;
	private double loadFactor;
	private int elementsNumber = 0;
	private Object[] arr;
	private final double DEFULT_LOAD_FACTOR = 0.5;
	private final int DEFULT_SIZE = 21;
	private static final Object DELETED = new Object();

	// Object[] arr;

	@SuppressWarnings("unchecked")
	public MyHashTable(int size, double loadFactor) {
		this.arrSize = size;
		this.arr = (T[]) new Object[arrSize];
		this.loadFactor = loadFactor;
		// arr = new Object[size];
	}

	@SuppressWarnings("unchecked")
	public MyHashTable(int size) {
		this.arrSize = size;
		this.arr = (T[]) new Object[arrSize];
		this.loadFactor = DEFULT_LOAD_FACTOR;
		// arr = new Object[size];
	}

	@SuppressWarnings("unchecked")
	public MyHashTable() {
		this.arrSize = DEFULT_SIZE;
		this.arr = (T[]) new Object[arrSize];
		this.loadFactor = DEFULT_LOAD_FACTOR;
		// arr = new Object[size];
	}

	@Override
	public void insert(T element) {
		if (highLoadFactor()) {
			rehash();
		}

		int index = hash(element);
		int i = 1;
		int probIndex = index;

//		if (this.arr[index] == null) {
//			this.arr[index] = element;
//			elementsNumber++;
//		} else {
			do {
				if (this.arr[probIndex] == null) {
					this.arr[probIndex] = element;
					elementsNumber++;
					return;
				}
				else if(this.arr[probIndex].equals(element)) {
					return;
				}
				else
					probIndex = findNextProbIndex(element, i++);

			} while (probIndex != index);
			if (probIndex == index) {
				rehash();
				insert(element);
			}
//		}
	}

	@SuppressWarnings("unchecked")
	private void rehash() {
		this.elementsNumber = 0;
		this.arrSize *= 2;
		T[] tempArr = (T[]) this.arr;
		this.arr = (T[]) new Object[this.arrSize];

		for (int i = 0; i < tempArr.length; i++) {
			if (tempArr[i] != null && !tempArr[i].equals(DELETED))
				insert(tempArr[i]);
		}
	}

	@Override
	public void delete(T element) {
		Integer pos = findElementIndex(element);
		if (pos != null)
			this.arr[pos] = DELETED;
		// else {
		// System.err.println("The array doesn't contain such element");
		// }
	}

	@Override
	public boolean contains(T element) {
		Integer pos = findElementIndex(element);
		if (pos != null)
			return true;
		return false;
		// int index = hash(element);
		//
		// if (this.arr[index] == null)
		// return false;
		// else if (this.arr[index] == element) {
		// deletedElementIndex = index;
		// return true;
		// } else {
		// Integer pos = findPos(element);
		// if (pos != null)
		// return true;
		// }
		// return false;
	}

	private Integer findElementIndex(T element) {
		int index = hash(element);
		int probIndex = index;
		int i = 1;

		// if (this.arr[index] == null)
		// return null;
		// else if (this.arr[index] == element) {
		// return index;
		// } else {
		do {
			if (this.arr[probIndex] == null) {
				return null;
			} else if (this.arr[probIndex].equals(element) ) {
				return probIndex;
			} else
				probIndex = findNextProbIndex(element, i++);

		} while (probIndex != index);
		// if (probIndex == index)
		// return -1;
		// }
		return null;
	}

	private int findNextProbIndex(T element, int i) {
		return (hash(element) + (int) Math.pow(i, 2)) % this.arrSize;
	}

	private boolean highLoadFactor() {
		return ((double) this.elementsNumber / this.arrSize) > this.loadFactor;
	}

	private int hash(T element) {
		int hash = element.hashCode();
		if (hash < 0)
			hash *= -1;
		return hash % this.arrSize;
	}

	public String convertToString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < this.arr.length; i++) {
			sb.append(i + " | ");
			sb.append(this.arr[i] + "\n");
		}

		return sb.toString();
	}
}
