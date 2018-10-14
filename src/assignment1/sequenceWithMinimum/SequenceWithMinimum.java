package assignment1.sequenceWithMinimum;

public class SequenceWithMinimum implements A1SequenceWithMinimum {
	private Node head, tail;
	Integer min = null;
	int occurrenceOfMin = 0;

	public SequenceWithMinimum() {
		head = null;
		tail = null;
	}

	@Override
	public void insertRight(Integer value) {
		if (value == null)
			return;
		
		// if the sequence is empty
		if (head == null) {
			head = new Node(value);
			tail = head;
			min = value;
			occurrenceOfMin = 1;

		} else {
			Node newNode = new Node(value);
			newNode.left = tail;
			tail.right = newNode;
			tail = newNode;

			// update min information
			if (min == null || value < min) {
				min = value;
				occurrenceOfMin = 1;
			}
			// if the inserted value = min, then record additional occurrence to the min
			else if (value == min) {
				occurrenceOfMin++;
			}
		}
	}

	@Override
	public Integer removeRight() {
		// if the sequence is empty
		if (head == null)
			return null;

		Integer temp = tail.value;
		// if the sequence has just one node
		if (tail.left == null) {
			tail = null;
			head = null;
		} else {
			tail = tail.left;
			tail.right = null;
		}

		// update min information
		// if the deleted value = min, then decrease the occurrence of the min
		if (temp == min) {
			occurrenceOfMin--;
			// if all occurrence of the min were deleted, then make min = null. This will let
			// the method findMinimum() to do a new search for the min when we called it.
			if (occurrenceOfMin == 0) {
				min = null;
			}
		}
		return temp;
	}

	@Override
	public void insertLeft(Integer value) {
		if (value == null)
			return;
		
		// if the sequence is empty
		if (head == null) {
			head = new Node(value);
			tail = head;
			min = value;
			occurrenceOfMin = 1;
		} else {
			Node newNode = new Node(value);
			newNode.right = head;
			head.left = newNode;
			head = newNode;

			// update min information
			if (min == null || value < min) {
				min = value;
				occurrenceOfMin = 1;
			}
			// if the inserted value = min, then record additional occurrence to the min
			else if (value == min) {
				occurrenceOfMin++;
			}
		}
	}

	@Override
	public Integer removeLeft() {
		// if the sequence is empty
		if (head == null)
			return null;

		Integer temp = head.value;
		// if the sequence has just one node
		if (head.right == null) {
			tail = null;
			head = null;
		} else {
			head = head.right;
			head.left = null;
		}

		// if the deleted value = min, then decrease the occurrence of the min
		if (temp == min) {
			occurrenceOfMin--;
			// if all occurrence of the min were deleted, then make min = null. This will let
			// the method findMinimum() to do a new search for the min when we called it.
			if (occurrenceOfMin == 0) {
				min = null;
			}
		}
		return temp;
	}

	@Override
	public Integer findMinimum() {
		if (min != null) {
			return min;
		} else if (head != null) {
			// New search will happen only if all occurrences for the previous min were
			// removed. Therefore, it is rarely happens
			searchNewMin();
		}
		return min;
	}

	// Search for the min value, and records the number of its occurrence
	private void searchNewMin() {
		if (head != null) {
			Node current = head;
			min = current.value;
			occurrenceOfMin = 1;
			while (current.right != null) {
				current = current.right;
				if (current.value < min) {
					min = current.value;
					occurrenceOfMin = 1;
				} else if (current.value == min) {
					occurrenceOfMin++;
				}
			}
		}
	}

	public String convertToString() {
		StringBuffer str = new StringBuffer();
		Node current = head;
		str.append("{ ");
		while (current != null) {
			str.append(current.value + ",");
			current = current.right;
		}
		str.deleteCharAt(str.length() - 1);
		str.append(" }");
		return str.toString();
	}

	private class Node {
		Integer value;
		Node right, left = null;

		public Node(Integer in) {
			value = in;
		}
	}

}
