/**
 * Brayden Tanji 
 * CS2400 
 * May 5, 2022 
 * Graph data structure class
 */

import java.util.Arrays;


/******************************
 * make sure to change array to arrayList array to make your life easier!!!
 */

public class Graph{
	private Node<Integer>[] EdgeList;

	public Graph()
	{
		@SuppressWarnings("unchecked")
		Node<Integer>[] tempArr = (Node<Integer>[]) new Object[1];	//make a new array of nodes that hold integers
		EdgeList = tempArr;
	}

	public void addNode(){						
		Arrays.copyOf(EdgeList, EdgeList.length+1);
	}

	public void addEdge(Node<Integer> newNode){
		EdgeList[EdgeList.length] = newNode;
	}

	public Node<Integer> removeNode(int nodeInt){			//when removing nodes, do we remove edges that point to it?

		Node<Integer> res = EdgeList[0];

		for(int i=0; i<EdgeList.length; i++){			//find node to delete 
			if(EdgeList[i].getData() == nodeInt){
				res = EdgeList[i];			//save node to return
				EdgeList[i] = null;
				break;					//break out of loop
			}
		}

		return res;
	}

	public void removeEdge(Node<Integer> start, Node<Integer> destination){	
		Node<Integer> startNode = null;
		int nodeIndex = -1;

		for (int i = 0; i < EdgeList.length; i++){ // find node to delete
			if (EdgeList[i] == start){
				nodeIndex = i;
				startNode = EdgeList[i];
				break; // break out of loop
			}
		}
		
		while(nodeIndex != -1){
			if(startNode == destination){
				startNode.setData(EdgeList[0].getData());

			}	
		}

	}

	public int[] neighbors(Node<Integer> node){
		int[] res = new int[EdgeList.length];

		//traversal method

		return res;
	}
}