/*
Brayden Tanji 
April 22, 2022
CS 2400
Driver test for heap
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class testHeap {
	public static void main(String[] args) throws FileNotFoundException {

		File f = new File("data.txt");
		Scanner scn = new Scanner(f);
		int[] dataArray = new int[100];

		Heap sequential = new Heap();

		int i = 0; 
		int nextVal = 0;
		while(scn.hasNextInt()){
			nextVal = scn.nextInt();
			
			sequential.add(nextVal);						//add values to heap using sequential method
			dataArray[i] = nextVal;						//add values into array for optimal method

			i++;
		}
		
		Heap optimal = new Heap(dataArray);

		/*int[] heap = optimal.getHeapArray();

		for(int j=0;j<heap.length;j++){
			System.out.println(heap[j]);
		}*/

		scn.close();
	}
}
