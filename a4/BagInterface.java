/*
Brayden Tanji 
February 24, 2022
CS 2400
bag ADT interface
*/

public interface BagInterface<T>{
	/*
	return: integer
	input: n/a 
	get the size of the bag (items it is holding)
	*/
	public int getCurrentSize();

	/*
	return: boolean
	input: n/a
	check if the bag is empty 
	*/
	public boolean isEmpty();

	/*
	return: boolean
	input: T generic
	add an item to the bag
	*/
	public boolean add(T newEntry);

	/*
	return: T generic 
	input: n/a
	removes a random item from the list
	*/
	public T remove();

	/*
	return: n/a
	input: n/a
	empties the elements of the bag
	*/
	public void clear();

	/*
	return: integer
	input: T generic
	return the number similar items there are in the bag
	*/
	public int getFrequencyOf(T entry);

	/*
	return: boolean
	input: T generic
	check if a specific item exists in the bag
	*/
	public boolean contains(T entry);

	/*
	return: T array
	input: n/a
	return an array of the bag 
	*/
	public T[] toArray();

	/*
	return: bag (of any type)
	input: bag (of any type)
	return a new bag with the elements of both bags combined together
	*/
	public BagInterface<T> union(BagInterface<T> bag1);

	/*
	return: bag (of any type)
	input: bag (of any type)
	return a new bag with elements that are similar across both bags
	*/
	public BagInterface<T> intersection(BagInterface<T> bag1);

	/*
	return: bag (of any type)
	input: bag (of any type)
	return a new bag with similar elements from both bags subtracted
	*/
	public BagInterface<T> difference(BagInterface<T> bag1);
}