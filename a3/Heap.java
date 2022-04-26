/*
Brayden Tanji 
April 16, 2022
CS 2400
Heap data structure 
*/

import java.util.Arrays;


public class Heap{

	private int[] heapArr;
	private int lastIndex;
	private int numSwaps;

	public Heap(){									//constructor with default array size
		int[] tempArray = new int[25];

		lastIndex = 0;
		heapArr = tempArray;
		numSwaps = 0;
	}

	public Heap(int capacity){							//constructor given capacity of array
		int[] tempArray = new int[capacity];

		lastIndex = 0;
		heapArr = tempArray;
		numSwaps = 0;
	}

	public Heap(int[] tempArray){ 							//optimal construction
		heapArr = new int[tempArray.length+1];
		numSwaps = 0;

		for(int i=0;i<tempArray.length;i++){					//place elements of array into heap
			lastIndex++;
			heapArr[i+1] = tempArray[i];
		}

		for(int j=(lastIndex/2);j > 0;j--){					//repeat reheap till heap is organized
			reheap(j);
		}
	}

	public void add(int newEntry){
		
		if(isFull()){
			heapArr = Arrays.copyOf(heapArr, 2*heapArr.length);
		}

		lastIndex++;

		heapArr[lastIndex] = newEntry;							//place new entry in last position of array

		int newIndex = lastIndex;							//the new entry's index
		int parentIndex = newIndex/2;							//parent of the new entry's index

		while(parentIndex > 0){								//loop till the parent index reeaches to the root

			if(heapArr[parentIndex] < heapArr[newIndex] && parentIndex > 0){	//check if the new entry is bigger than its parent
				int temp = heapArr[parentIndex];				//swap parent and new entry if it is bigger
				heapArr[parentIndex] = heapArr[newIndex];
				heapArr[newIndex] = temp;

				newIndex = parentIndex;						//change new and parent indexes for the next iteration
				parentIndex = newIndex/2;
				numSwaps++;
			}
			else{
				break;								//exit loop if no swap is needed
			}
		}
	}

	public int removeMax(){		
		int oldMax = -1;					//-1 represents empty 

		if(!isEmpty()){
			oldMax = heapArr[1];

			heapArr[1] = heapArr[lastIndex];		//replace root with last entry

			lastIndex--; 					// last index value goes down
			reheap(1);					//sort the tree (trickle to the leaf)
		}
		
		return oldMax;						 
	}

	public void reheap(int entryIndex){
		int parentIndex = entryIndex;
		int rightChildIndex;
		int leftChildIndex;

		int largestChildIndex;

		while(parentIndex <= lastIndex/2){								//repeat till last internal node is reached
			leftChildIndex = 2*parentIndex;
			rightChildIndex = leftChildIndex + 1;
			largestChildIndex = leftChildIndex;							//assume that the largest child is left for now

			if(rightChildIndex <= lastIndex && heapArr[leftChildIndex] < heapArr[rightChildIndex]){	//find the largest child's index
				largestChildIndex = rightChildIndex;
			}
			else{
				largestChildIndex = leftChildIndex;
			}

			if(heapArr[parentIndex] < heapArr[largestChildIndex]){					//compare the largest child to the parent node 
				int temp = heapArr[parentIndex];						//swap the parent node with the largest child
				heapArr[parentIndex] = heapArr[largestChildIndex];
				heapArr[largestChildIndex] = temp;
				parentIndex = largestChildIndex;						//next node to work with is the largest child
				numSwaps++;
			}
			else{
				break;										//end loop if no swaps can be done
			}
		}
	}

	public int getMax(){		
		return heapArr[1];			//max is located at the root of the tree 
	}

	public boolean isEmpty(){
		return lastIndex < 1;			//returns if the last index is past 
	}

	public int[] getHeapArray(){			//copy of heap array 
		int[] tempHeap = new int[heapArr.length];

		for(int i=0; i<heapArr.length;i++){
			tempHeap[i] = heapArr[i];
		}

		return tempHeap;
	}

	public boolean isFull(){			// check if array is full
		return (getSize() >= (heapArr.length-1));
	}

	public int getSize(){
		return lastIndex;			//size is equal to last index because 
	}

	public int getNumberSwaps(){			//return total number of swaps made when organizing heap
		return numSwaps;
	}

	public void clear(){
		lastIndex = 0;				//reset heap 
	}

}