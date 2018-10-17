package assignment2.hashTable;

public class MyHashTable<T> implements A2HashTable<T> {
	private int arrSize;
	private double loadFactor;
	private int elementsNumber = 0;
	private Object[] arr;
	private final double DEFULT_LOAD_FACTOR = 0.5;
	private final int DEFULT_SIZE = 21;
	private static final Object DELETED = new Object();

	@SuppressWarnings("unchecked")
	public MyHashTable(int size, double loadFactor) {
		this.arrSize = size;
		this.arr = (T[]) new Object[arrSize];
		this.loadFactor = loadFactor;
	}

	@SuppressWarnings("unchecked")
	public MyHashTable(int size) {
		this.arrSize = size;
		this.arr = (T[]) new Object[arrSize];
		this.loadFactor = DEFULT_LOAD_FACTOR;
	}

	@SuppressWarnings("unchecked")
	public MyHashTable() {
		this.arrSize = DEFULT_SIZE;
		this.arr = (T[]) new Object[arrSize];
		this.loadFactor = DEFULT_LOAD_FACTOR;
	}

	@Override
	public void insert(T element) {
		if (highLoadFactor())
			rehash();
		int index = hash(element);
		int i = 1;
		int probIndex = index;

		do {
			if (this.arr[probIndex] == null) { // add new element
				this.arr[probIndex] = element;
				elementsNumber++;
				return;
			} else if (this.arr[probIndex].equals(element)) { // the element is already exists
				return;
			}
			probIndex = findNextProbIndex(element, i++); // find the next element's index depending on the quadratic
															// probing
		} while (probIndex != index);

		// reaching this point means the insertion has failed
		rehash();
		insert(element);
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
		Integer pos = findElementIndex(element); // find the element's index depending on the quadratic probing
		if (pos != null)
			this.arr[pos] = DELETED;
	}

	@Override
	public boolean contains(T element) {
		Integer pos = findElementIndex(element); // find the element's index depending on the quadratic probing
		if (pos != null)
			return true;
		return false;
	}

	private Integer findElementIndex(T element) {
		int index = hash(element);
		int probIndex = index;
		int i = 1;
		do {
			if (this.arr[probIndex] == null) {
				return null;
			} else if (this.arr[probIndex].equals(element)) {
				return probIndex;
			} else
				probIndex = findNextProbIndex(element, i++); // find the next element's index depending on the quadratic
																// probing
		} while (probIndex != index);
		return null;
	}

	// A method finds the index of the element depends on the quadratic probing
	private int findNextProbIndex(T element, int i) {
		return (hash(element) + (int) Math.pow(i, 2)) % this.arrSize;
	}

	// A method keeps track if the load factor value reaches the max load factor
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
			if (this.arr[i] == DELETED)
				sb.append("DELETED\n");
			else if (this.arr[i] == null){
				sb.append("\n");
			}
			else {
				sb.append(this.arr[i] + "\n");
			}
		}
		return sb.toString();
	}
}
