package assignment2.hashTable;

public class MyHashTableMain {

	public static void main(String[] args) {

		MyHashTable<Object> table = new MyHashTable<Object> (7,0.5);
		table.insert(76);

		table.insert(40);
		table.insert(48);
		table.insert(5);
		table.insert(20);
		table.insert("asd");

		String c = "asd" ;
		System.out.println(table.convertToString());
		System.out.println(table.contains(c));

		table.delete(c);
		table.delete(40);

		System.out.println(table.convertToString());

		System.out.println(table.contains(c));
	}

}
