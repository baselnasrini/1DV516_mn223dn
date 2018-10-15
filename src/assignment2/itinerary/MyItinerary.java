package assignment2.itinerary;

import assignment2.hashTable.MyHashTable;

public class MyItinerary implements A2Itinerary<A2Direction> {
	
	private A2Direction[] array;
	
	public MyItinerary(A2Direction[] array) {
		this.array =array;
	}
	
	@Override
	public A2Direction[] rotateRight() {
		A2Direction[] resultArray = new A2Direction[array.length];
		for (int i = 0; i<array.length; i++) {
			if (array[i] == A2Direction.LEFT)
				resultArray[i] = A2Direction.UP;
			else if (array[i] == A2Direction.UP)
				resultArray[i] = A2Direction.RIGHT;
			else if (array[i] == A2Direction.RIGHT)
				resultArray[i] = A2Direction.DOWN;
			else if (array[i] == A2Direction.DOWN)
				resultArray[i] = A2Direction.LEFT;
		}
		return resultArray;
	}

	@Override
	public int widthOfItinerary() {
		int minWidth =0;
		int maxWidth =0;
		int currentWidth = 0;
		
		for (A2Direction direction : array) {
			if (direction == A2Direction.LEFT) 
				currentWidth--;
			else if (direction == A2Direction.RIGHT)
				currentWidth++;
			
			if (currentWidth < minWidth)
				minWidth = currentWidth;
				
			if (currentWidth > maxWidth)
				maxWidth = currentWidth;
		}
		
		return (maxWidth - minWidth);
	}

	@Override
	public int heightOfItinerary() {
		int minHeight =0;
		int maxHeight =0;
		int currentHeight = 0;
		
		for (A2Direction direction : array) {
			if (direction == A2Direction.UP) 
				currentHeight--;
			else if (direction == A2Direction.DOWN)
				currentHeight++;
			
			if (currentHeight < minHeight)
				minHeight = currentHeight;
				
			if (currentHeight > maxHeight)
				maxHeight = currentHeight;
		}
		
		return maxHeight - minHeight;
	}

	

	@Override
	public int[] getIntersections() {
		int x =0;
		int y=0;
		int counter=0;
		int [] result = new int [array.length];
		MyHashTable <Position> table = new MyHashTable<Position>();
		
		for (int i = 0; i<array.length; i++) {
			if (array[i] == A2Direction.LEFT)
				x--;
			else if (array[i] == A2Direction.UP)
				y--;
			else if (array[i] == A2Direction.RIGHT)
				x++;
			else if (array[i] == A2Direction.DOWN)
				y++;
			
			Position point = new Position(x, y);
			if (table.contains(point)) 
				result[counter++] = i;
			else 
				table.insert(point);
			
		}
		int [] finalResult = new int [counter];
		for (int i=0; i< counter ; i++) {
			finalResult[i] = result[i];
		}
		return finalResult;
	}
	
	private class Position {
		int x =0;
		int y=0;
		public Position(int xp, int yp) {
			x = xp;
			y = yp;
		}
		
		@Override
		public boolean equals(Object o) {
			if (o instanceof Position) {
				Position p = (Position) o;
				return (x==p.x && y == p.y);
			}
			else
				return false;
		}
		
		@Override
		public int hashCode() {
			int hash = abs(x);
			hash = hash*10 + abs(y);
			if (x<0 && y<0)
				hash = hash *10 +2;
			else if (x<0 && y>-1)
				hash = hash *10 +1 ;
			else if (x>-1 && y<0)
				hash = hash *10 +3 ;
			else
				hash = hash *10 ;
			
			return hash;
		}
		
		public int abs(int num) {
			return num<0? -num : num;
		}
	}
    
}
