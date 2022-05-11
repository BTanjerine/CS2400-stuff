import java.util.Arrays;
import java.util.zip.Adler32;

/**
 * Brayden Tanji CS2400 May 5, 2022 Graph data structure class
 */

public class graph
{
	private Node<Integer>[] EdgeList;

	public graph()
	{
		@SuppressWarnings("unchecked")
		Node<Integer>[] tempArr = (Node<Integer>[]) new Object[1];	//make a new array of nodes that hold integers
		EdgeList = tempArr;
	}

	public void addNode(){
		Arrays.copyOf(EdgeList, EdgeList.length+1);

		//add edges associated with the node
		
	}

	public void addEdge(Node<Integer> newNode)
	{
		EdgeList[EdgeList.length + 1] = newNode;
	}

	public Node<Integer> removeNode()
	{

	}

	public Node<Integer> removeEdge()
	{

	}
}