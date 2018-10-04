package sequenceWithMinimum;

public class SequenceWithMinimum implements A1SequenceWithMinimum {
	private Node head, tail;

	public SequenceWithMinimum() {
		head = null;
		tail = null;
	}

	@Override
	public void insertRight(Integer value) {
		if (head == null) {
			head = new Node(value);
			tail = head;
		} else {
			Node newNode = new Node(value);
			newNode.left = tail;
			tail.right = newNode;
			tail = newNode;
		}
	}

	@Override
	public Integer removeRight() {
		if (head == null)
			return null;

		int temp = tail.value;
		if (tail.left == null) {
			tail = null;
			head = null;
		} else {
			tail = tail.left;
			tail.right = null;
		}
		return temp;
	}

	@Override
	public void insertLeft(Integer value) {
		if (head == null) {
			head = new Node(value);
			tail = head;
		} else {
			Node newNode = new Node(value);
			newNode.right = head;
			head.left = newNode;
			head = newNode;
		}
	}

	@Override
	public Integer removeLeft() {
		if (head == null)
			return null;

		int temp = head.value;
		if (head.right == null) {
			tail = null;
			head = null;
		} else {
			head = head.right;
			head.left = null;
		}
		return temp;
	}

	@Override
	public Integer findMinimum() {
		Node current = head;
		if (current == null) {
			return null;
		}
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
			str.append(current.value + ",");
			current = current.right;
		}
		str.deleteCharAt(str.length() - 1);
		str.append(" }");
		return str.toString();
	}

	private class Node {
		int value;
		Node right, left = null;

		Node(int in) {
			value = in;
		}
	}

}
