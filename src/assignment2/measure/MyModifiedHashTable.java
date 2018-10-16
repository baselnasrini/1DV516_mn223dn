package assignment2.measure;

public class MyModifiedHashTable<K,V> {
	private int arrSize;
	private double loadFactor;
	private int elementsNumber = 0;
	private Object[] keyArr;
	private Object[] valueArr;
	private final double DEFULT_LOAD_FACTOR = 0.5;
	private final int DEFULT_SIZE = 21;
	private static final Object DELETED = new Object();

	// Object[] arr;

	@SuppressWarnings("unchecked")
	public MyModifiedHashTable(int size, double loadFactor) {
		this.arrSize = size;
		this.keyArr = (K[]) new Object[arrSize];
		this.valueArr = (V[]) new Object[arrSize];
		this.loadFactor = loadFactor;
		// arr = new Object[size];
	}

	@SuppressWarnings("unchecked")
	public MyModifiedHashTable(int size) {
		this.arrSize = size;
		this.keyArr = (K[]) new Object[arrSize];
		this.valueArr = (V[]) new Object[arrSize];
		this.loadFactor = DEFULT_LOAD_FACTOR;
		// arr = new Object[size];
	}

	@SuppressWarnings("unchecked")
	public MyModifiedHashTable() {
		this.arrSize = DEFULT_SIZE;
		this.keyArr = (K[]) new Object[arrSize];
		this.valueArr = (V[]) new Object[arrSize];
		this.loadFactor = DEFULT_LOAD_FACTOR;
		// arr = new Object[size];
	}

	
	public void insert(K key, V value) {
		if (highLoadFactor()) {
			rehash();
		}

		int index = hash(key);
		int i = 1;
		int probIndex = index;

//		if (this.arr[index] == null) {
//			this.arr[index] = element;
//			elementsNumber++;
//		} else {
			do {
				if (this.keyArr[probIndex] == null) {
					this.keyArr[probIndex] = key;
					this.valueArr[probIndex] = value;
					elementsNumber++;
					return;
				}
				else if(this.keyArr[probIndex].equals(key)) {
					// update the value of the existing key
					this.valueArr[probIndex] = value;
					return;
				}

				probIndex = findNextProbIndex(key, i++);

			} while (probIndex != index);
			
			// if we reached this point, it means the insertion has failed
			rehash();
			insert(key, value);
//		}
	}

	@SuppressWarnings("unchecked")
	private void rehash() {
		this.elementsNumber = 0;
		this.arrSize *= 2;
		K[] tempKeyArr = (K[]) this.keyArr;
		V[] tempValueArr = (V[]) this.valueArr;

		this.keyArr = new Object[this.arrSize];
		this.valueArr = new Object[this.arrSize];


		for (int i = 0; i < tempKeyArr.length; i++) {
			if (tempKeyArr[i] != null && !tempKeyArr[i].equals(DELETED))
				insert(tempKeyArr[i], tempValueArr[i]);
		}
	}

	
	public void delete(K element) {
		Integer pos = findElementIndex(element);
		if (pos != null) {
			this.keyArr[pos] = DELETED;
			this.valueArr[pos] = DELETED;
		}
		// else {
		// System.err.println("The array doesn't contain such element");
		// }
	}

	@SuppressWarnings("unchecked")
	public V get(K element) {
		Integer pos = findElementIndex(element);
		if (pos != null)
			return (V) this.valueArr[pos];
		else
			return null;
	}
	
	public boolean contains(K element) {
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

	private Integer findElementIndex(K element) {
		int index = hash(element);
		int probIndex = index;
		int i = 1;

		// if (this.arr[index] == null)
		// return null;
		// else if (this.arr[index] == element) {
		// return index;
		// } else {
		do {
			if (this.keyArr[probIndex] == null) {
				return null;
			} else if (this.keyArr[probIndex].equals(element) ) {
				return probIndex;
			} else
				probIndex = findNextProbIndex(element, i++);

		} while (probIndex != index);
		// if (probIndex == index)
		// return -1;
		// }
		return null;
	}

	private int findNextProbIndex(K element, int i) {
		return (hash(element) + (i*i)) % this.arrSize;
	}

	private boolean highLoadFactor() {
		return ((double) this.elementsNumber / this.arrSize) > this.loadFactor;
	}

	private int hash(K element) {
		int hash = element.hashCode();
		if (hash < 0)
			hash *= -1;
		return hash % this.arrSize;
	}

	public String convertToString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < this.keyArr.length; i++) {
			sb.append(i + " | ");
			sb.append(this.keyArr[i] + "\n");
		}

		return sb.toString();
	}
}
