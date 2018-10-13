package assignment1.binarySearchTreeADT;

public class BinarySearchTreeADT implements A1Tree {
	Node root;
	int size;

	public BinarySearchTreeADT() {
		size = 0;
	}

	@Override
	public void insert(Integer value) {
		size++;
		if (root == null) {
			root = new Node(value);
		} else
			root.addValue(value);
	}

	@Override
	public Integer mostSimilarValue(Integer value) {
		Integer result = null;
		if (root != null)
			result = findMostSimilar(value, root, result);
		return result;
	}

	private Integer findMostSimilar(Integer value, Node node, Integer result) {
		if (result == null || value == node.value) {
			result = node.value;
		} else {
			// Calculate the similarity between the given value and the current node.
			int currentSimilarity = value - node.value;

			// Calculate the similarity between the given value and the last result.
			int lastSimilarity = value - result;

			// Convert the negative values to positive
			if (currentSimilarity < 0)
				currentSimilarity = -currentSimilarity;
			if (lastSimilarity < 0)
				lastSimilarity = -lastSimilarity;

			// compare the similarity
			if (currentSimilarity < lastSimilarity)
				result = node.value;
			// Else if the two nodes have the same similarity, then return the smaller value
			// (of course it is my own decision)
			else if (currentSimilarity == lastSimilarity && node.value < result)
				result = node.value;
		}

		// Search in the children
		if (node.leftChild != null && value < node.value)
			result = findMostSimilar(value, node.leftChild, result);
		else if (node.rightChild != null && value > node.value)
			result = findMostSimilar(value, node.rightChild, result);

		return result;
	}

	@Override
	public void printByLevels() {
		if (root == null)
			return;
		// The array will be used as queue (FIFO)
		Node[] nodesArray = new Node[size];
		int insertIndex = 0;
		int getIndex = 0;
		// insert the root, then visit it as Level 0.
		nodesArray[insertIndex++] = root;
		visitLivel(nodesArray, insertIndex, getIndex, 0);
	}

	private void visitLivel(Node[] nodesArray, int insertIndex, int getIndex, int level) {
		System.out.print("Depth " + level + ":");
		int originalInsertIndex = insertIndex;
		for (int i = getIndex; i < originalInsertIndex; i++) {
			Node node = nodesArray[getIndex++];
			System.out.print(" " + node.value);

			// Insert the children in the array to read them in the next level
			if (node.leftChild != null)
				nodesArray[insertIndex++] = node.leftChild;
			if (node.rightChild != null)
				nodesArray[insertIndex++] = node.rightChild;
		}
		System.out.println("");

		// If there is no insertion has happened in the array, then there is no next
		// level.
		if (originalInsertIndex == insertIndex) {
			return;
		}

		// Visit the next level.
		level++;
		visitLivel(nodesArray, insertIndex, getIndex, level);
	}

	private class Node {
		Integer value;
		Node leftChild;
		Node rightChild;

		public Node(Integer value) {
			this.value = value;
		}

		public void addValue(int value) {
			if (value < this.value) {
				if (leftChild == null)
					leftChild = new Node(value);
				else
					leftChild.addValue(value);
			} else if (value > this.value) {
				if (rightChild == null)
					rightChild = new Node(value);
				else
					rightChild.addValue(value);
			}
		}
	}
}
