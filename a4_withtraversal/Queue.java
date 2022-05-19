public class Queue {
	
	private Node<String> frontNode;
	private Node<String> backNode;
	private int numEntries;

	public Queue(){
		frontNode = null;
		backNode = null;
		numEntries = 0;
	}

	public void enqueue(String newEntry){
		Node<String> newNode = new Node<>(newEntry);		//make new node
		
		if(isEmpty()){										//if entry is the first entry
			frontNode = newNode;
		}
		else{	
			backNode.setNextNode(newNode);					//if there were more entries before this entry
		}

		backNode = newNode;									//place node in queue
		numEntries++;
	}

	public String dequeue(){
		String res = frontNode.getData();

		frontNode.setData(null);					//unreference to delete
		frontNode = frontNode.getNextNode();

		if(frontNode == null){								//set both null if the queue is empty
			backNode = null;
		}

		numEntries--;
		return res;
	}

	public String getFront(){
		return frontNode.getData();
	}

	public boolean isEmpty(){
		return ((frontNode == null) || (backNode == null));
	}

	public void clear(){
		frontNode = null;
		backNode = null;
	}

	public int getNumEntries(){
		return numEntries;
	}

	public String toString(){
		String res = new String();
		Node<String> currentNode = frontNode;

		if(currentNode == null){
			res = "empty";
		}
		else{
			while(currentNode != null){
				res += currentNode.getData();
				currentNode = currentNode.getNextNode();
			}
		}
		
		return res;
	}

}
