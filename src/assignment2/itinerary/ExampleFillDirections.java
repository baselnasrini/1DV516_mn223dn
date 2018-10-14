package assignment2.itinerary;

public class ExampleFillDirections {

	private A2Direction[] array;

	public static void main(String[] args) {

		ExampleFillDirections example = new ExampleFillDirections();
		example.fillSix();

		MyItinerary myItinerary = new MyItinerary(example.array);
		System.out.println("Width: " + myItinerary.widthOfItinerary());
		System.out.println("Height: " + myItinerary.heightOfItinerary());
		System.out.println("");
		example.printDirections(myItinerary.rotateRight());
		System.out.println("");
		example.printIntersections(myItinerary.getIntersections());

	}
	
	private void printIntersections(int[] intersections) {
		System.out.print("Intersections: ");
		for (int i : intersections) {
			System.out.println(i + " ");
		}
	}

	private void printDirections(A2Direction[] array) {
		System.out.println("Directions: ");
		for (A2Direction direction : array) {
			System.out.println(direction);
		}
	}

	private void fillSix() {
		array = new A2Direction[6];

		array[0] = A2Direction.LEFT;
		array[1] = A2Direction.DOWN;
		array[2] = A2Direction.DOWN;
		array[3] = A2Direction.RIGHT;
		array[4] = A2Direction.UP;
		array[5] = A2Direction.LEFT;

		// array[0] = A2Direction.UP;
		// array[1] = A2Direction.LEFT;
		// array[2] = A2Direction.LEFT;
		// array[3] = A2Direction.DOWN;
		// array[4] = A2Direction.RIGHT;
		// array[5] = A2Direction.UP;

		//// ---------------------------
		// array = new A2Direction[10];
		//
		// array[0] = A2Direction.LEFT;
		// array[1] = A2Direction.DOWN;
		// array[2] = A2Direction.RIGHT;
		// array[3] = A2Direction.DOWN;
		// array[4] = A2Direction.LEFT;
		// array[5] = A2Direction.UP;
		//
		// array[6] = A2Direction.LEFT;
		// array[7] = A2Direction.UP;
		// array[8] = A2Direction.RIGHT;
		// array[9] = A2Direction.UP;

	}

}
