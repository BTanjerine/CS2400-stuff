/*
Brayden Tanji 
march 15, 2022
CS 2400
interface for all stack classes
*/


public interface StackInterface<T>{
	/*
	* pushes value on to the stack
	* @param: value -> value being pushed into the stack, type T
	* @return: void
	*/
	public void push(T value);

	/*
	* pops a value out of the stack and returns that value
	* @param: n/a
	* @return: T type -> value type that the class is
	*/
	public T pop();

	/*
	* return the value at the top of the
	* @param: n/a
	* @return: T type -> value type that the class is
	*/
	public T peek();

	/*
	* pops a value out of the stack and returns that value
	* @param: n/a
	* @return: boolean -> the stack is empty or not
	*/
	public boolean isEmpty();

	/*
	* empties the whole array
	* @param: n/a
	* @return: void
	*/
	public void clear();
}