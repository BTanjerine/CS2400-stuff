/*
Brayden Tanji 
March 16, 2022
CS 2400
Node class for handling nodes in linked chain 
*/


public class Vertex{
	private LinkedBag<String> edgeList;
	private String data;

	/*
	input: String label for the vertex
	setup new vertex with label data and a linked bag for edges 
	*/
	public Vertex(String d){
		edgeList = new LinkedBag<>();
		data = d;
	}

	/*
	return: string label data
	input: n/a
	get the value that the vertex holds
	*/
	public String getData(){
		return data;
	}

	/*
	return: void
	input: String new label data
	set the value of the vertex
	*/
	public void setData(String newData){
		data = newData;
	}

	/*
	return: boolean the vertex is an edge of this vertex
	input: String the vertex we are checking relations with
	check if the vertex given has a relationship with this vertex (Edge)
	*/
	public boolean hasEdge(String vertex){
		return edgeList.contains(vertex);
	}

	/*
	return: void
	input: String edge vertex
	add a vertex to the edge list
	*/
	public void addEdgeVertex(String adj){
		edgeList.add(adj);
	}

	/*
	return: void
	input: String edge vertex
	remove a vertex to the edge list
	*/
	public void removeEdgeVertex(String adj){
		edgeList.remove(adj);
	}
}
