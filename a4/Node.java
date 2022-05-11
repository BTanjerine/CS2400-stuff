/*
Brayden Tanji 
March 1, 2022
CS 2400
Node class for handling nodes in linked chain 
*/


public class Node<T>{
	private Node<T> nextNode;
	private T data;

	/*
	input: T generic 
	make a new node with a soecific data value
	*/
	public Node(T d){
		nextNode = null;
		data = d;
	}

	/*
	input: T generic data, Node the next node
	make a new node with given data and node
	*/
	public Node(T d, Node<T> next){
		nextNode = next;
		data = d;
	}

	/*
	return: T generic
	input: n/a
	get the value that the node holds
	*/
	public T getData(){
		return data;
	}

	/*
	return: void
	input: T generic
	set the value of the node
	*/
	public void setData(T newData){
		data = newData;
	}

	/*
	return: Node 
	input: n/a
	get the next node that this node is linked to
	*/
	public Node<T> getNextNode(){
		return nextNode;
	}

	/*
	return: void
	input: Node 
	set the next node that this node is linked to
	*/
	public void setNextNode(Node<T> node){
		nextNode = node;
	}
}
