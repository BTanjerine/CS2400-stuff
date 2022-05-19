import java.util.Stack;

/**
 * Brayden Tanji 
 * CS2400 
 * May 15, 2022 
 * Graph data structure class
 */


public class VertexGraph{
	private Vertex[] vertexList;
	private int numVertices;

	public VertexGraph(int size){
		vertexList = new Vertex[size];						//constructor: init veretx array
		numVertices = 0;									//reset numbers of 
	}

	public void addVertex(String vertex){
		if(numVertices >= vertexList.length){							//check size of the vertex list 
			System.out.println("ERROR: cannot add anymore vertices, exceed max vertice count");
			return;														//exit if there is no space
		}
		vertexList[numVertices]	= new Vertex(vertex);					//place in array
		numVertices++;														
	}

	public void addEdge(int start, int destination){
		vertexList[start].addEdgeVertex(vertexList[destination].getData());	//add vertex to edge list 
	}

	public void removeVertex(int vertexIndex){			

		for(int i=0; i<vertexList.length; i++){				//find node to delete 
			if(i == vertexIndex){
				vertexList[i] = null;						//delete the vertex from the list of vertices
			}

			removeEdge(i, vertexIndex);						//remove any edges with this node
		}

		numVertices--;	
	}

	public void removeEdge(int start, int destination){
		if(vertexList[start].hasEdge(vertexList[destination].getData())){								//if no relationship skip
			vertexList[start].removeEdgeVertex(vertexList[destination].getData());						//remove from list if there is 
		}
	}

	public int getIndexOfVertex(String label){
		int res = -1; 											//default value for when no match is found

		for(int i=0; i<numVertices; i++){						//loop through every vertice to find the one we looking for
			if(label == vertexList[i].getData()){
				res = i;										//save index when found
			}
		}

		return res;
	}

	public String[] neighbors(int vertex){
		int sizeCount = 0;
		String[] res;

		for(int i=0;i<numVertices;i++){
			if(isAdjacent(i, vertex)){	
				sizeCount++;												//count up when there is an adjacent veretx
			}
		}

		if(sizeCount > 0){													//check if there are any neihbors that exist
			res = new String[sizeCount];									//make a new array for output
			sizeCount = 0;

			for(int j=0;j<numVertices;j++){
				if(isAdjacent(j, vertex)){
					res[sizeCount] = vertexList[j].getData();				//copy data that is adjacent into array 
					sizeCount++;
				}
			}
		}
		else{
			res = null;														//give null if there are no neighbors
		}
		

		return res;
	}

	public boolean exists(String vertex){	
		boolean res = false;												//false if nothing matches
		for(int i=0;i<numVertices;i++){										//loop through vertice list 
			res = (vertexList[i].getData() == vertex);						//become true if vertex is found
			if(res) break;													//break when found
		}
		return res;
	}

	public boolean isAdjacent(int start, int destination){
		return (vertexList[start].hasEdge(vertexList[destination].getData()));	//check if the 2 nodes are adjacent to each other
	}

	public Queue BFS(int origin){
		Queue visitedQ = new Queue();
		Queue traversalQ = new Queue();
		int frontVertex = -1;
		int nextNeighbor = -1;

		vertexList[origin].visited();
		visitedQ.enqueue(vertexList[origin].getData());
		traversalQ.enqueue(vertexList[origin].getData());

		System.out.print("_\t_\t");
		System.out.print(vertexList[origin].getData()+ "\t");
		System.out.print(visitedQ + "\t");

		System.out.println();

		while(!visitedQ.isEmpty()){
			frontVertex = getIndexOfVertex(visitedQ.dequeue());
			int i = 0;

			System.out.print(vertexList[frontVertex].getData() + "\t");
			System.out.print("_\t_\t");
			System.out.print(visitedQ + "\t");
			System.out.println();

			while(vertexList[frontVertex].edgesExist()){
				nextNeighbor = getIndexOfVertex(vertexList[frontVertex].getNeighbor(i));
				if(nextNeighbor < 0) break;

				if(!vertexList[nextNeighbor].checkVisited()){
					vertexList[nextNeighbor].visited();
					traversalQ.enqueue(vertexList[nextNeighbor].getData());
					visitedQ.enqueue(vertexList[nextNeighbor].getData());

					System.out.print("_\t");
					System.out.print(vertexList[nextNeighbor].getData()+ "\t");
					System.out.print(vertexList[nextNeighbor].getData()+ "\t");
					System.out.print(visitedQ + "\t");
					System.out.println();
				}

				i++;
			}
		}

		return traversalQ;
	}

	private boolean vertexHasVisitedNeighbors(int index){
		boolean res = true;

		Vertex currentV = vertexList[index];
		int i = 0;

		while(i < currentV.getNumEdges()){
			res = (res && vertexList[getIndexOfVertex(currentV.getNeighbor(i))].checkVisited());
			i++;
		}
		return res;
	}

	public int getUnvisitedNeighbor(int index){
		int res = -1;

		Vertex currentV = vertexList[index];
		int i = 0;

		while(i < currentV.getNumEdges()){
			int neighborIndex = getIndexOfVertex(currentV.getNeighbor(i));
			if(!vertexList[neighborIndex].checkVisited()){
				res = i;
				break;
			}
			i++;
		}

		return res;
	}

	public Queue DFS(int origin){
		Queue traversalQ = new Queue();
		LStack<String> visitedStack = new LStack<>();
		int topVertex = -1;
		int nextNeighbor = -1;

		vertexList[origin].visited();
		System.out.print("_\t");
		visitedStack.push(vertexList[origin].getData());
		System.out.print(vertexList[origin].getData()+ "\t");
		traversalQ.enqueue(vertexList[origin].getData());
		System.out.print(vertexList[origin].getData()+ "\t");
		System.out.print(visitedStack + "\t");

		System.out.println();

		while(!visitedStack.isEmpty()){
			topVertex = getIndexOfVertex(visitedStack.peek());
			System.out.print(vertexList[topVertex].getData() + "\t_\t_\t");
			System.out.print(visitedStack + "\t");
			System.out.println();

			if(vertexList[topVertex].edgesExist() && !vertexHasVisitedNeighbors(topVertex)){
				nextNeighbor = getIndexOfVertex(vertexList[topVertex].getNeighbor(getUnvisitedNeighbor(topVertex)));

				vertexList[nextNeighbor].visited();
				System.out.print("_\t");
				visitedStack.push(vertexList[nextNeighbor].getData());
				System.out.print(vertexList[nextNeighbor].getData()+ "\t");
				traversalQ.enqueue(vertexList[nextNeighbor].getData());
				System.out.print(vertexList[nextNeighbor].getData()+ "\t");
				System.out.print(visitedStack + "\t");
				System.out.println();
			}
			else{
				visitedStack.pop();
			}
		}

		return traversalQ;
	}
}