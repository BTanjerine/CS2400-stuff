/*
Brayden Tanji 
April 16, 2022
CS 2400
Heap data structure 
*/


public class Heap{

	private int[] heapArr;
	private int lastIndex;

	public Heap(){
		int[] tempArray = new int[25];

		lastIndex = 0;
		heapArr = tempArray;
	}

	public Heap(int capacity){
		int[] tempArray = new int[capacity];

		lastIndex = 0;
		heapArr = tempArray;
	}

	public Heap(int[] tempArray){ //new construction

		for(int i=0; i<tempArray.length; i++){
			lastIndex++;
			heapArr[lastIndex] = tempArray[i];
		}

		lastIndex = 0;
		heapArr = tempArray;
	}

	public void add(int newEntry){
		lastIndex++;

		heapArr[lastIndex] = newEntry;							//place new entry in last position of array

		int newIndex = lastIndex;								//the new entry's index
		int parentIndex = newIndex/2;							//parent of the new entry's index

		while(parentIndex > 0){									//loop till the parent index reeaches to the root

			if(heapArr[parentIndex] < heapArr[newIndex]){		//check if the new entry is bigger than its parent
				int temp = heapArr[parentIndex];				//swap parent and new entry if it is bigger
				heapArr[parentIndex] = heapArr[newIndex];
				heapArr[newIndex] = temp;

				newIndex = parentIndex;							//change new and parent indexes for the next iteration
				parentIndex = newIndex/2;
			}
			else{
				break;											//exit loop if no swap is needed
			}
		}
	}

	public void addSubTree(Heap newTree){

	}

	public int removeMax(){		
		int oldMax = -1;							//-1 represents empty 

		if(!isEmpty()){
			oldMax = heapArr[1];

			heapArr[1] = heapArr[lastIndex];		//replace root with last entry

			reheap(1);						//sort the tree (trickle to the leaf)

			lastIndex--;							//last index value goes down
		}
		
		return oldMax;								//return 
	}

	public void reheap(int entryIndex){
		int parentIndex = entryIndex;
		int rightChildIndex;
		int leftChildIndex;

		int largestChildIndex;

		while(parentIndex < lastIndex/2){								//repeat till last internal node is reached
			rightChildIndex = (2*parentIndex)+1;
			leftChildIndex = 2*parentIndex;
			largestChildIndex = heapArr[leftChildIndex];				//assume that the largest child is left for now

			if(heapArr[leftChildIndex] > heapArr[rightChildIndex]){		//find the largest child's index
				largestChildIndex = leftChildIndex;
			}
			else{
				largestChildIndex = rightChildIndex;
			}

			if(heapArr[parentIndex] < heapArr[largestChildIndex]){		//compare the largest child to the parent node 
				int temp = heapArr[parentIndex];						//swap the parent node with the largest child
				heapArr[parentIndex] = heapArr[largestChildIndex];
				heapArr[largestChildIndex] = temp;
				parentIndex = largestChildIndex;						//next node to work with is the largest child
			}
			else{
				break;													//end loop if no swaps can be done
			}
		}
	}

	public int getMax(){		
		return heapArr[1];			//max is located at the root of the tree 
	}

	public boolean isEmpty(){
		return lastIndex < 1;		//returns if the last index is past 
	}

	public int getSize(){
		return lastIndex;			//size is equal to last index because 
	}

	public void clear(){
		lastIndex = 0;				//reset heap 
	}

}