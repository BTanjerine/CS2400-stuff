/**
 * Brayden Tanji 
 * CS2400 
 * May 15, 2022 
 * Graph data structure test to see if neighbor function works
 */


public class GraphDriver {
	public static void main(String[] args) {
		Graph test = new Graph(9);

		test.addVertex("A");					//setup vertices 
		test.addVertex("B");
		test.addVertex("C");
		test.addVertex("D");
		test.addVertex("E");
		test.addVertex("F");
		test.addVertex("G");
		test.addVertex("H");
		test.addVertex("I");

		int A = test.getIndexOfVertex("A");		//get the index values for each vertex
		int B = test.getIndexOfVertex("B");
		int C = test.getIndexOfVertex("C");
		int D = test.getIndexOfVertex("D");
		int E = test.getIndexOfVertex("E");
		int F = test.getIndexOfVertex("F");
		int G = test.getIndexOfVertex("G");
		int H = test.getIndexOfVertex("H");
		int I = test.getIndexOfVertex("I");

		test.addEdge(A, D);								//setup the edges for the 
		test.addEdge(A, E);
		test.addEdge(A, B);
		test.addEdge(B, E);
		test.addEdge(C, B);
		test.addEdge(D, G);
		test.addEdge(E, F);
		test.addEdge(E, H);
		test.addEdge(F, C);
		test.addEdge(F, H);
		test.addEdge(G, H);
		test.addEdge(H, I);
		test.addEdge(I, F);

		if(test.exists("E")){													//test exists finctions
			String[] testArray = test.neighbors(test.getIndexOfVertex("E"));		//make an array that holds the neighbors of E

			System.out.print("Neighbors of E are: ");
			if(testArray != null){
				for(String i: testArray){
					System.out.print(i + ", ");											//print out neighbors of vertex E
				}
			}
		}
	}
}
