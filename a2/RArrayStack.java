import java.util.Arrays;

/*
Brayden Tanji 
march 15, 2022
CS 2400
implementation of ADT stack using a resizable array
*/


public class RArrayStack<T> implements StackInterface<T>{
	private T[] AStack;
	private int topIndex;
	private final int DEFAULT_CAPACITY = 25;

	/*
	* make new array to represent satck
	* @param: n/a
	* @return: void
	*/
	public RArrayStack(){
		topIndex = -1;						//top index for stack does not exist

		@SuppressWarnings("unchecked")				//make temporary array and set it to the stack array
		T[] tempArr = (T[]) new Object[DEFAULT_CAPACITY];
		AStack = tempArr;
	}

	/*
	* pushes value on to the stack
	* @param: value -> value being pushed into the stack, type T
	* @return: void
	*/
	public void push(T value){
		topIndex++;			//increase index value of the top of the bag

		if(checkCapacity()){		//check capacity to see if more space is needed
			doubleArraySize();
		}
		
		AStack[topIndex] = value;	//set top of the stack
		
	}

	/*
	* checks capacity of array and sees if full
	* @param: n/a
	* @return: boolean -> check if the array is filled
	*/
	private boolean checkCapacity(){
		return (topIndex+1) > AStack.length;
	}

	/*
	* double the size of the array to fit more
	* @param: n/a
	* @return: void
	*/
	private void doubleArraySize(){
		AStack = Arrays.copyOf(AStack, AStack.length*2);
	}

	/*
	* pops a value out of the stack and returns that value
	* @param: n/a
	* @return: T type -> value type that the class is
	*/
	public T pop(){
		T res = AStack[topIndex];	//save and output value of top of stack

		AStack[topIndex] = null;	//delete value at top of stack
		topIndex--;

		return res;
	}

	/*
	* return the value at the top of the
	* @param: n/a
	* @return: T type -> value type that the class is
	*/
	public T peek(){
		return AStack[topIndex];
	}

	/*
	* pops a value out of the stack and returns that value
	* @param: n/a
	* @return: boolean -> the stack is empty or not
	*/
	public boolean isEmpty(){
		return topIndex<0;	//check if top index is -1 
	}

	/*
	* empties the whole array
	* @param: n/a
	* @return: void
	*/
	public void clear(){
		topIndex = -1;		//reset the index value of the top of the stack
	}
}
