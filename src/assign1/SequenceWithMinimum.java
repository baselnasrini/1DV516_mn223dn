package assign1;

public class SequenceWithMinimum implements A1SequenceWithMinimum {
	private Node tail, head;
	int seqMin = 0;
	int size = 0;

	public SequenceWithMinimum() {
		tail = null;
		head = null;
	}

	@Override
	public void insertRight(Integer value) {
		if (tail == null) {
			tail = new Node(value);
			head = tail;
			seqMin = value;
		} else {
			Node newNode = new Node(value);
			newNode.left = tail;
			tail.right = newNode;
			tail = newNode;
		}

		if (value < seqMin) {
			seqMin = value;
			tail.min = value;
		} else {
			tail.min = seqMin;
		}
	}

	@Override
	public Integer removeRight() {
		if (tail == null || head == null)
			return null;

		int temp = tail.value;
		if (size == 0) {
			tail = null;
			head = null;
		} else {
			tail = tail.left;
			tail.right = null;
		}

		if (head.min < tail.min) {
			seqMin = head.min;
		} else {
			seqMin = tail.min;
		}

		return temp;
	}

	@Override
	public void insertLeft(Integer value) {
		if (head == null) {
			head = new Node(value);
			tail = head;
			seqMin = value;
		} else {
			Node newNode = new Node(value);
			newNode.right = head;
			head.left = newNode;
			head = newNode;
		}

		if (value < seqMin) {
			seqMin = value;
			head.min = value;
		} else {
			head.min = seqMin;
		}
	}

	@Override
	public Integer removeLeft() {
		if (tail == null || head == null)
			return null;

		int temp = head.value;
		if (head.right == null) {
			tail = null;
			head = null;

		} else {
			head = head.right;
			head.left = null;
		}

		if (head.min < tail.min) {
			seqMin = head.min;
		} else {
			seqMin = tail.min;
		}
		return temp;
	}

	@Override
	public Integer findMinimum() {
		Node current = head;
		if (current == null)
			return null;

		int min = current.value;
		while (current.right != null) {
			current = current.right;
			if (current.value < min) {
				min = current.value;
			}
		}
		return min;
	}

	public String toString() {
		StringBuffer str = new StringBuffer();
		Node current = head;
		str.append("{ ");
		while (current != null) {
			str.append(current.value + " ");
			current = current.right;
		}
		str.append("}");
		return str.toString();
	}

	private class Node {
		int value;
		Node right = null;
		Node left = null;
		int min = 0;

		Node(int in) {
			value = in;
		}
	}

}
