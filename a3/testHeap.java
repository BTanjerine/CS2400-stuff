/*
Brayden Tanji 
April 22, 2022
CS 2400
Driver test for heap
*/

import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class testHeap {
	public static void main(String[] args) throws FileNotFoundException {

		File f = new File("data.txt");			//file to read from
		PrintWriter pW = new PrintWriter("output.txt");	//file to write on

		Scanner scn = new Scanner(f);					//scanner to read file

		int[] dataArray = new int[100];					//array with data from file
		int[] OptimHeap;						//heap arrays
		int[] SequentialHeap;

		int i = 0; 
		int nextVal = 0;
		while(scn.hasNextInt()){
			nextVal = scn.nextInt();
			
			dataArray[i] = nextVal;					//add values into array for optimal method

			i++;
		}
		
		Heap optimal = new Heap(dataArray, 'o');				//make another heap using optimal method
		Heap sequential = new Heap(dataArray, 's'); 					// new heap for sequential construction

		OptimHeap = optimal.getHeapArray();				//get array from heap
		SequentialHeap = sequential.getHeapArray();

		pW.println("=====================================================================");

		pW.print("Heap built using sequential insertions: ");
		for (int k = 1; k <= 10; k++) 					// print sequential heap
		{
			pW.print(SequentialHeap[k] + ",");
		}
		pW.print("...\n");

		pW.println("Number of swaps in the heap creation: " + sequential.getNumberSwaps()); // number of swaps

		sequential.removeMax();						//remove 10 nodes from the heap
		sequential.removeMax();
		sequential.removeMax();
		sequential.removeMax();
		sequential.removeMax();
		sequential.removeMax();
		sequential.removeMax();
		sequential.removeMax();
		sequential.removeMax();
		sequential.removeMax();

		SequentialHeap = sequential.getHeapArray();

		pW.print("Heap after 10 removals: ");
		for (int k = 1; k <= 10; k++) 					// print sequential heap
		{
			pW.print(SequentialHeap[k] + ",");
		}
		pW.print("...\n");
		pW.println();

		pW.print("Heap built using optimal method: ");
		for (int j = 1; j <= 10; j++) 					// print optimal heap
		{
			pW.print(OptimHeap[j] + ",");
		}
		pW.print("...\n");

		pW.println("Number of swaps in the heap creation: " + optimal.getNumberSwaps());

		optimal.removeMax(); 						// remove 10 nodes from the heap
		optimal.removeMax();
		optimal.removeMax();
		optimal.removeMax();
		optimal.removeMax();
		optimal.removeMax();
		optimal.removeMax();
		optimal.removeMax();
		optimal.removeMax();
		optimal.removeMax();

		OptimHeap = optimal.getHeapArray(); 				// get array from heap

		pW.print("Heap after 10 removals: ");
		for (int j = 1; j <= 10; j++) 					// print optimal heap
		{
			pW.print(OptimHeap[j] + ",");
		}
		pW.print("...\n");

		pW.println("=====================================================================");

		pW.close();							//close file
		scn.close();							//close scanner
	}
}
