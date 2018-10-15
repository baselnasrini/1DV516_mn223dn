package assignment2.hashTable;

public class MyHashTableMain {

	public static void main(String[] args) {

		A2HashTable<Object> table = new MyHashTable<Object> (7);
		table.insert(76);

		table.insert(40);
		table.insert(48);
		table.insert(5);
		table.insert(20);
		table.insert("asd");

		boolean b = true;
		String c = "asd" ;
		System.out.println(table.toString());
		System.out.println(table.contains(c));

		table.delete(c);
		System.out.println(table.toString());

		System.out.println(table.contains(c));
	}

}
