package assignment2.hashTable;

public class MyHashTable<T> implements A2HashTable<T> {
	int arrSize;
	double loadFactor;
	int elementsNumber = 0;
	T[] arr;
	final double DEFULT_LOAD_FACTOR = 0.5;
//	Object[] arr;

	@SuppressWarnings("unchecked")
	public MyHashTable(int size, double loadFactor) {
		this.arrSize = size;
		this.arr = (T[]) new Object[size];
		this.loadFactor = loadFactor;
//		arr = new Object[size];
	}

	@SuppressWarnings("unchecked")
	public MyHashTable(int size) {
		this.arrSize = size;
		this.arr = (T[]) new Object[size];
		this.loadFactor = DEFULT_LOAD_FACTOR;
//		arr = new Object[size];
	}

	@Override
	public void insert(T element) {
		int index = hash(element);
		int i = 1;
		int probIndex = 0;

		if (highLoadFactor()) {
			rehash();
		}
		if (this.arr[index] == null) {
			this.arr[index] = element;
			elementsNumber++;
		} else {
			probIndex = findProbPos(element, i++, this.arrSize);
			while (probIndex != index) {
				if (this.arr[probIndex] == null) {
					this.arr[probIndex] = element;
					elementsNumber++;
					break;
				}
				probIndex = findProbPos(element, i++, this.arrSize);
			}
			if (probIndex == index) {
				rehash();
				insert(element);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void rehash() {
		this.elementsNumber = 0;
		this.arrSize *= 2;
		T[] tempArr = this.arr;
		this.arr = (T[]) new Object[this.arrSize];

		for (int i = 0; i < tempArr.length; i++) {
			if (tempArr[i] != null)
				insert(tempArr[i]);
		}
	}

	@Override
	public void delete(T element) {
		Integer pos = findPos(element);
		if (pos != null)
			this.arr[pos] = null;
		else {
			System.err.println("The array doesn't contain such element");
		}
	}

	@Override
	public boolean contains(T element) {
		Integer pos = findPos(element);
		if (pos != null)
			return true;
		return false;
//		int index = hash(element);
//
//		if (this.arr[index] == null)
//			return false;
//		else if (this.arr[index] == element) {
//			deletedElementIndex = index;
//			return true;
//		} else {
//			Integer pos = findPos(element);
//			if (pos != null)
//				return true;
//		}
//		return false;
	}

	private Integer findPos(T element) {
		int index = hash(element);
		int probIndex = 0;
		int i = 1;

		if (this.arr[index] == null)
			return null;
		else if (this.arr[index] == element) {
			return index;
		} else {
			probIndex = findProbPos(element, i++, this.arrSize);
			while (probIndex != index) {
				if (this.arr[probIndex] == null) {
					return null;
				} else if (this.arr[probIndex] == element) {
					return probIndex;
				}
				probIndex = findProbPos(element, i++, this.arrSize);
			}
//			if (probIndex == index) 
//				return -1;
		}
		return null;
	}

	private int findProbPos(T element, int i, int size) {
		return (hash(element) + (int) Math.pow(i++, 2)) % size;
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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < this.arr.length; i++) {
			sb.append(i + " | ");
			sb.append(this.arr[i] + "\n");
		}

		return sb.toString();
	}
}
