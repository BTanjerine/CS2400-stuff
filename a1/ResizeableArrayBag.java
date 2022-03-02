import java.util.Arrays;

/*
Brayden Tanji 
February 24, 2022
CS 2400
bag Data Structure class array version
*/

public class ResizeableArrayBag<T> implements BagInterface<T>{
	private final T[] bag;
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 25;


	/*
	input: integer capacity
	make a new bag array with a custom capacity
	*/
	public ResizeableArrayBag(int capacity){
		numberOfEntries = 0;

		@SuppressWarnings("unchecked")
		T[] tempbag = (T[]) new Object[capacity];
		bag = tempbag;
	}

	/*
	input: n/a
	make a new bag array with a capacity of 25
	*/
	public ResizeableArrayBag(){
		numberOfEntries = 0;

		@SuppressWarnings("unchecked")
		T[] tempbag = (T[]) new Object[DEFAULT_CAPACITY];
		bag = tempbag;
	}

	/*
	return: integer
	input: n/a 
	get the size of the bag (items it is holding)
	*/
	public int getCurrentSize(){
		return numberOfEntries;
	}

	/*
	return: boolean
	input: n/a
	check if the bag is empty (true/false)
	*/
	public boolean isEmpty(){
		return numberOfEntries == 0;
	}

	/*
	return: boolean
	input: T generic
	add an item to the bag
	*/
	public boolean add(T newEntry){
		if(isFull()){
			doubleSize(bag);		// increase size of bag when the item doesn't fit in the array
		}

		bag[numberOfEntries] = newEntry;	// add entry

		numberOfEntries++;			// increase count
		return true;
	}

	/*
	return: T array 
	input: T array
	doubles the size of the bag
	*/
	private T[] doubleSize(T[] oldArray){
		return Arrays.copyOf(oldArray, oldArray.length*2);
	}

	/*
	return: boolean 
	input: n/a
	check if the bag is full (true/false)
	*/
	private boolean isFull(){
		return numberOfEntries == bag.length;
	}

	/*
	return: T generic 
	input: n/a
	removes a random item from the list
	*/
	public T remove(){

		return removeEntry(numberOfEntries);
	}

	/*
	return: T generic 
	input: T generic Entry to remove
	removes a item from the list
	*/
	public T remove(T entryToRemove){
		int indexToRemove = getIndexOf(entryToRemove);		// find the index of the entry to remove
		return removeEntry(indexToRemove);			// remove entry and return the old value
	}

	/*
	return: int array index 
	input: T generic entry you are looking for
	finds the location of the item in the bag
	*/
	private int getIndexOf(T entry){
		int i = 0;

		while(bag[i] != entry && i < numberOfEntries){		// loop till entry is found in the bag array
			i++;
		}

		return i;
	}

	/*
	return: T generic entry you are looking for 
	input: int array index
	Removes a specific entry from the bag
	*/
	private T removeEntry(int index){
		T output = null;

		if(!isEmpty() && index != 0){
			output = bag[index];
			bag[index] = bag[numberOfEntries-1]; 	// move last entry to the area
			bag[numberOfEntries-1] = null;		// clear the last entry
			numberOfEntries--;			// decrease number of entries
		}

		return output;
	}

	/*
	return: void
	input: n/a
	empties the elements of the bag
	*/
	public void clear(){
		numberOfEntries = 0;
	}

	/*
	return: T generic
	input: int index position
	get the specific entry at the psoiton given in the bag
	
	public T getEntry(int index){
		return bag[index];
	}*/

	/*
	return: integer
	input: T generic
	return the number similar items there are in the bag
	*/
	public int getFrequencyOf(T entry){
		int i = 0;
		int count = 0;

		while(i < numberOfEntries){		// loop till the whole bag is checked
			if(bag[i] == entry)
				count++;		// count up the amount of similar items there are
			i++;
		}

		return count;				// return the number of similar items in the bag
	}

	/*
	return: boolean
	input: T generic
	check if a specific item exists in the bag
	*/
	public boolean contains(T entry){
		int i = 0;
		boolean found = false;

		while(i < numberOfEntries && !found){		// loop till item is found
			found = (bag[i] == entry);		// check the existence of the item in the bag
			i++;
		}

		return found;					// return the existence of the entry
	}

	/*
	return: T array
	input: n/a
	return a new array of the bag 
	*/
	public T[] toArray(){
		@SuppressWarnings("unchecked")				// make a new array to represent bag
		T[] finalArray = (T[]) new Object[numberOfEntries];

		for(int i=0; i<finalArray.length; i++){			// copy all of the items in bag to the new array
			finalArray[i] = bag[i];
		}

		return finalArray;					// return the array
	}

	/*
	return: resizeableArrayBagBag 
	input: resizeableArrayBagBag
	return a new bag with the elements of both bags combined together
	*/
	public BagInterface<T> union(BagInterface<T> bag1){
		ResizeableArrayBag<T> newBag = new ResizeableArrayBag<T>();

		T[] array1 = this.toArray();
		T[] array2 = bag1.toArray();

		for(int i=0; i<array1.length+array2.length-1; i++){	// loop till all the elements are added into the array
			if(i < array1.length)				// switch the bag you are adding from based on number of entries for this bag
				newBag.add(array1[i]);
			else						// adding items from bag1
				newBag.add(array2[i]);
		}

		return newBag;
	}

	/*
	return: resizeableArrayBagBag 
	input: resizeableArrayBagBag
	return a new bag with elements that are similar across both bags
	*/
	public BagInterface<T> intersection(BagInterface<T> bag1){
		ResizeableArrayBag<T> newBag = new ResizeableArrayBag<T>();

		T[] array1 = this.toArray();
		T[] array2 = bag1.toArray();

		return newBag;
	}

	/*
	return: resizeableArrayBagBag 
	input: resizeableArrayBagBag
	return a new bag with similar elements from both bags subtracted
	*/
	public BagInterface<T> difference(BagInterface<T> bag1){
		ResizeableArrayBag<T> newBag = new ResizeableArrayBag<T>();

		T[] array1 = this.toArray();
		T[] array2 = bag1.toArray();

		return newBag;
	}
}
