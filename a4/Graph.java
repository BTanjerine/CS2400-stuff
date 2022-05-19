/**
 * Brayden Tanji 
 * CS2400 
 * May 15, 2022 
 * Graph data structure class
 */


public class Graph{
	private Vertex[] vertexList;
	private int numVertices;

	public Graph(int size){
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
}