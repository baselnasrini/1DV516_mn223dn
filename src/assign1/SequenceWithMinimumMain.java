package assign1;

public class SequenceWithMinimumMain {

	public static void main(String[] args) {
		SequenceWithMinimum sequence = new SequenceWithMinimum();
		
		sequence.insertLeft(1);
		System.out.println(sequence.findMinimum());
		sequence.insertLeft(6);
		System.out.println(sequence.findMinimum());
		sequence.insertLeft(2);
		System.out.println(sequence.findMinimum());
		sequence.insertLeft(7);
		System.out.println(sequence.findMinimum());
		sequence.insertRight(5);
		System.out.println(sequence.findMinimum());
		sequence.insertRight(1);
		System.out.println(sequence.findMinimum());
		sequence.insertRight(3);
		System.out.println(sequence.findMinimum());
		sequence.insertLeft(7);
		System.out.println(sequence.findMinimum());
		System.out.println(sequence);

		System.out.println("Remove " );
		sequence.removeLeft();
		System.out.println(sequence);
		System.out.println(sequence.findMinimum());
		sequence.removeRight();
		System.out.println(sequence);
		System.out.println(sequence.findMinimum());

		sequence.removeRight();
		System.out.println(sequence);
		System.out.println(sequence.findMinimum());
		sequence.removeRight();
		System.out.println(sequence);
		System.out.println(sequence.findMinimum());
		sequence.removeLeft();
		System.out.println(sequence);
		System.out.println(sequence.findMinimum());
		sequence.removeRight();
		System.out.println(sequence);
		System.out.println(sequence.findMinimum());


		
		
		
//		System.out.println("insert right");
//		sequence.insertRight(1);
//		System.out.println(sequence);
//		System.out.println("insert right");
//		sequence.insertRight(2);
//		System.out.println(sequence);
//		System.out.println("insert right");
//		sequence.insertRight(3);
//		System.out.println(sequence);
//
//		System.out.println("Remove right:" + sequence.removeRight());
//		System.out.println(sequence);
//		System.out.println("Remove right:" + sequence.removeRight());
//		System.out.println(sequence);
//		System.out.println("Remove right:" + sequence.removeRight());
//		System.out.println(sequence);
//
//		System.out.println("insert left");
//		sequence.insertLeft(3);
//		System.out.println(sequence);
//		System.out.println("insert left");
//		sequence.insertLeft(2);
//		System.out.println(sequence);
//		System.out.println("insert left");
//		sequence.insertLeft(1);
//		System.out.println(sequence);
//
//		System.out.println("Remove left:" + sequence.removeLeft());
//		System.out.println(sequence);
//		System.out.println("Remove left:" + sequence.removeLeft());
//		System.out.println(sequence);
//		System.out.println("Remove left:" + sequence.removeLeft());
//		System.out.println(sequence);

		
		
	}

}
