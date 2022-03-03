/*
Brayden Tanji 
February 24, 2022
CS 2400
bag Data Structure class linked chain version
*/

public class LinkedBag<T> implements BagInterface<T>{
	private Node<T> firstNode;
	private int numberOfEntries;

	/*
	return: n/a
	input: n/a 
	constructor, set entries to 0 and define firstNode to null
	*/
	public LinkedBag(){
		numberOfEntries = 0;
		firstNode = null;
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
	check if the bag is empty 
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
		Node<T> newNode = new Node<T>(newEntry);	// make a new node with given value and link new node to the chain
		newNode.setNextNode(firstNode);

		firstNode = newNode;				// make the first node the new node

		numberOfEntries++;				//increment number of entries

		return true;
	}

	/*
	return: T generic 
	input: n/a
	removes a random item from the list
	*/
	public T remove(){
		T result = firstNode.getData();
		if(getCurrentSize() > 0 || firstNode != null){		// check if array is empty to make sure that there is a removable entry 
			firstNode = firstNode.getNextNode();
		}

		numberOfEntries--;					// decrement number of entries
		return result;						// return value of removed data
	}

	/*
	return: T generic 
	input: T generic Entry to remove
	removes a item from the list
	*/
	public T remove(T entryToRemove){
		Node<T> nodeToRemove = getReferenceTo(entryToRemove);	// find the node we need to remove

		nodeToRemove.setData(firstNode.getData());		// set that node to the first node's value

		remove();						// remove the first node

		return entryToRemove;
	}


	/*
	return: Node 
	input: T generic entry you are looking for
	finds the location of the item in the bag linked chain
	*/
	private Node<T> getReferenceTo(T entry){
		Node<T> currentNode = firstNode;			// start with first node
		for(int i=0; i<numberOfEntries; i++){ 			// loop till the current node has the data we are looking for
			if(currentNode.getData() == entry){
				break;
			}
			currentNode = currentNode.getNextNode();	// if not move to the next node
		}
		return currentNode;					// return node with same value as one being searched
	}

	/*
	return: n/a
	input: n/a
	empties the elements of the bag
	*/
	public void clear(){
		firstNode = null;					// set first node null == all nodes deleted
		numberOfEntries = 0;					// reset entry value
	}

	/*
	return: integer
	input: T generic
	return the number similar items there are in the bag
	*/
	public int getFrequencyOf(T entry){
		Node<T> currentNode = firstNode;			// start with first node
		int count = 0;

		for(int i=0; i<numberOfEntries; i++){ 			// loop till the current node has the data we are looking for
			if(currentNode.getData() == entry){
				count++;				// increment count ofthat item
			}
			currentNode = currentNode.getNextNode();	// move to the next node
		}

		return count;						// return frequency of that entry
	}

	/*
	return: boolean
	input: T generic
	check if a specific item exists in the bag
	*/
	public boolean contains(T entry){
		Node<T> currentNode = firstNode;			// start with first node
		boolean found = false;

		for(int i=0; i<numberOfEntries; i++){ 			// loop till the current node has the data we are looking for
			found = currentNode.getData() == entry;
			if(found)
				break;					

			currentNode = currentNode.getNextNode();	// move to the next node
		}

		return found;
	}

	/*
	return: T array
	input: n/a
	return an array of the bag 
	*/
	public T[] toArray(){
		@SuppressWarnings("unchecked")
		T[] newArray = (T[]) new Object[numberOfEntries];

		Node<T> currentNode = firstNode;			// start with first node

		for(int i=0; i<numberOfEntries; i++){ 			// loop till the current node has the data we are looking for
			
			newArray[i] = currentNode.getData();		// copy values of chain to array

			currentNode = currentNode.getNextNode();	// move to the next node
		}

		return newArray;
	}

	/*
	return: bag (of any type)
	input: bag (of any type)
	return a new bag with the elements of both bags combined together
	*/
	public BagInterface<T> union(BagInterface<T> bag1){
		LinkedBag<T> newBag = new LinkedBag<T>();

		T[] array1 = this.toArray();
		T[] array2 = bag1.toArray();

		for(int i=0; i<array1.length+array2.length; i++){	// loop till all the elements are added into the array
			if(i < array1.length)				// switch the bag you are adding from based on number of entries for this bag
				newBag.add(array1[i]);
			else						// adding items from bag1
				newBag.add(array2[i-array1.length]);
		}

		return newBag;
	}

	/*
	return: bag (of any type)
	input: bag (of any type)
	return a new bag with elements that are similar across both bags
	*/
	public BagInterface<T> intersection(BagInterface<T> bag1){
		LinkedBag<T> newBag = new LinkedBag<T>();

		T[] array1 = this.toArray();
		T[] array2 = bag1.toArray();

		for(int i=0;i<array1.length;i++){			//compare value from both arrays and find similarities
			for(int j=0;j<array2.length;j++){		
				if(array1[i] == array2[j]){
					newBag.add(array1[i]);		//put similar vlaues into new bag
					array2[j] = null;		//disregard the number we found this pair
					break;				//break for when there isnt an even number of similar elements
				}
			}
		}
		
		return newBag;
	}

	/*
	return: bag (of any type)
	input: bag (of any type)
	return a new bag with similar elements from both bags subtracted
	*/
	public BagInterface<T> difference(BagInterface<T> bag1){
		LinkedBag<T> newBag = new LinkedBag<T>();
		boolean isSimilar = false;

		T[] array1 = this.toArray();
		T[] array2 = bag1.toArray();

		for(int i=0;i<array1.length;i++){			//compare value from both arrays and find similarities
			for(int j=0;j<array2.length;j++){		
				if(array1[i] == array2[j]){
					array2[j] = null;		//disregard the number we found this pair
					isSimilar = true;
					break;				//break for when there isnt an even number of similar elements
				}
			}
			if(!isSimilar)					//make sure that intersectable values dont make it to the bag
				newBag.add(array1[i]);

			isSimilar = false;				// reset for next iteration
		}

		return newBag;
	}
}
