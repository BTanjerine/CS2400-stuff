/*
Brayden Tanji 
march 2, 2022
CS 2400
Driver test code for Linked Chain bag DS
*/


public class LinkedBagTest {
	public static void main(String[] args) {
		LinkedBag<String> bag1 = new LinkedBag<String>();		//make 2 bags wit different values
		LinkedBag<String> bag2 = new LinkedBag<String>();

		bag1.add("a");							//add bag 1 contents
		bag1.add("b");
		bag1.add("c");

		bag2.add("b");							//add bag 2 contents
		bag2.add("b");
		bag2.add("d");
		bag2.add("e");

		Object[] array1 = bag1.toArray();				//make the bags into arrays
		Object[] array2 = bag2.toArray();

		System.out.println("bag size 1: " + bag1.getCurrentSize());	//print the size of bag1

		for(int i=0;i<bag1.getCurrentSize();i++){			//print the values of bag1 
			System.out.println(array1[i]);
		}

		System.out.println();

		System.out.println("bag size 2: " + bag2.getCurrentSize());	//print the size of bag2

		for(int i=0;i<bag2.getCurrentSize();i++){			//print the values of bag2
			System.out.println(array2[i]);
		}

		System.out.println("\nUnion of bag1 and bag2");
		
		BagInterface<String> bag3 = bag2.union(bag1);			//make a third bag that is the union of bag1 and bag2

		Object[] array3 = bag3.toArray();				//turn bag into array

		for(int i=0;i<bag3.getCurrentSize();i++){			//print values of bag 3
			System.out.println(array3[i]);
		}

		System.out.println("\nintersection of bag1 and bag2");

		BagInterface<String> bag4 = bag2.intersection(bag1);		//make a third bag that is the intersection of bag1 and bag2

		Object[] array4 = bag4.toArray();				//turn bag into array

		for(int i=0;i<bag4.getCurrentSize();i++){			//print values of bag 4
			System.out.println(array4[i]);
		}

		System.out.println("\ndifference of bag2 and bag1");

		BagInterface<String> bag5a = bag2.difference(bag1);		//make a third bag that is the difference of bag2 and bag1

		Object[] array5a = bag5a.toArray();				//turn bag into array

		for(int i=0;i<bag5a.getCurrentSize();i++){			//print values of bag 5a
			System.out.println(array5a[i]);
		}

		System.out.println("\ndifference of bag1 and bag2");

		BagInterface<String> bag5b = bag2.difference(bag1);		//make a third bag that is the difference of bag1 and bag2

		Object[] array5b = bag5a.toArray();				//turn bag into array

		for(int i=0;i<bag5b.getCurrentSize();i++){			//print values of bag 5b
			System.out.println(array5b[i]);
		}
	}
}
