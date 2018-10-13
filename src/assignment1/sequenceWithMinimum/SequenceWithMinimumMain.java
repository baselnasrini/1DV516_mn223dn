package assignment1.sequenceWithMinimum;

public class SequenceWithMinimumMain {

	public static void main(String[] args) {
		SequenceWithMinimum sequence = new SequenceWithMinimum();

		System.out.println(sequence.convertToString());

		System.out.println("insert right");
		sequence.insertRight(1);
		System.out.println(sequence.convertToString());
		System.out.println("insert right");
		sequence.insertRight(6);
		System.out.println(sequence.convertToString());
		System.out.println("insert right");
		sequence.insertRight(1);
		System.out.println(sequence.convertToString());
		System.out.println("insert right");
		sequence.insertRight(7);
		System.out.println(sequence.convertToString());
		
		System.out.println("insert left");
		sequence.insertLeft(3);
		System.out.println(sequence.convertToString());
		System.out.println("insert left");
		sequence.insertLeft(2);
		System.out.println(sequence.convertToString());
		System.out.println("insert left");
		sequence.insertLeft(4);
		System.out.println(sequence.convertToString());
		System.out.println("insert left");
		sequence.insertLeft(3);
		System.out.println(sequence.convertToString());
		System.out.println("insert left");
		sequence.insertLeft(4);
		System.out.println(sequence.convertToString());

		System.out.println("Remove right:" + sequence.removeRight());
		System.out.println(sequence.convertToString());
		System.out.println("Min: " + sequence.findMinimum());
		System.out.println("Remove right:" + sequence.removeRight());
		System.out.println(sequence.convertToString());
		System.out.println("Min: " + sequence.findMinimum());
		System.out.println("Remove right:" + sequence.removeRight());
		System.out.println(sequence.convertToString());
		System.out.println("Min: " + sequence.findMinimum());
		System.out.println("Remove right:" + sequence.removeRight());
		System.out.println(sequence.convertToString());
		System.out.println("Min: " + sequence.findMinimum());

		System.out.println("Remove left:" + sequence.removeLeft());
		System.out.println(sequence.convertToString());
		System.out.println("Min: " + sequence.findMinimum());
		System.out.println("Remove left:" + sequence.removeLeft());
		System.out.println(sequence.convertToString());
		System.out.println("Min: " + sequence.findMinimum());
		System.out.println("Remove left:" + sequence.removeLeft());
		System.out.println(sequence.convertToString());
		System.out.println("Min: " + sequence.findMinimum());
		System.out.println("Remove left:" + sequence.removeLeft());
		System.out.println(sequence.convertToString());
		System.out.println("Min: " + sequence.findMinimum());
		
		System.out.println("Remove left:" + sequence.removeLeft());
		System.out.println(sequence.convertToString());
		System.out.println("Min: " + sequence.findMinimum());
	}

}
