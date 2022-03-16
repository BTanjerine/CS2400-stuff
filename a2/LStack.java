/*
Brayden Tanji 
march 15, 2022
CS 2400
Implementation of ADT stack using linked chain
*/


public class LStack<T> implements StackInterface<T>{
	private Node<T> topNode;

	/*
	* make a new linked chain to represent stack
	* @param: n/a
	* @return: void
	*/
	public LStack(){
		topNode = null;
	}

	/*
	* pushes value on to the stack
	* @param: value -> value being pushed into the stack, type T
	* @return: void
	*/
	public void push(T value){
		Node<T> newNode = new Node<T>(value,topNode);	//make new node and link chain to new node
		topNode = newNode;
	}

	/*
	* pops a value out of the stack and returns that value
	* @param: n/a
	* @return: T type -> value type that the class is
	*/
	public T pop(){
		T res = topNode.getData();		//save and output top of stack
		topNode = topNode.getNextNode();	//set next node to the top of the stack

		return res;
	}

	/*
	* return the value at the top of the
	* @param: n/a
	* @return: T type -> value type that the class is
	*/
	public T peek(){
		return topNode.getData();
	}

	/*
	* pops a value out of the stack and returns that value
	* @param: n/a
	* @return: boolean -> the stack is empty or not
	*/
	public boolean isEmpty(){
		return topNode == null;
	}

	/*
	* empties the whole array
	* @param: n/a
	* @return: void
	*/
	public void clear(){
		topNode = null;
	}
}
