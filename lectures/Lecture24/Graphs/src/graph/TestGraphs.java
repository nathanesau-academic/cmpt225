package graph;

public class TestGraphs<T> {

	public static Graph<String> createGraph() {
		//
		//
		//
		//   A --- B --- C ------ J ----- I
		//   |     | \   |                |
		//   |     |   \ |                |
		//   D --- E --- F --- Target --- H
		//
		Graph<String> graph = new Graph<String>();
		graph.addVertex(new Vertex<String>("A"));
		// more convenient
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("Target");
		graph.addVertex("H");
		graph.addVertex("I");
		graph.addVertex("J");

		graph.addEdge("A","B");
		graph.addEdge("A","D");
		graph.addEdge("B","C");
		graph.addEdge("B","E");
		graph.addEdge("B","F");
		graph.addEdge("C","F");
		graph.addEdge("D","E");
		graph.addEdge("E","F");
		graph.addEdge("Target","F");
		graph.addEdge("Target","H");
		graph.addEdge("C","J");
		graph.addEdge("I","J");
		graph.addEdge("I","H");

		return graph;
	}
	
	public static void setHequalDist(Graph<String> G) {
		G.getVertexByName("A").setH(3);
		G.getVertexByName("B").setH(2);
		G.getVertexByName("C").setH(2);
		G.getVertexByName("D").setH(3);
		G.getVertexByName("E").setH(2);
		G.getVertexByName("F").setH(1);
		G.getVertexByName("H").setH(1);
		G.getVertexByName("I").setH(2);
		G.getVertexByName("J").setH(3);
	}

	public static void setHrand(Graph<String> G) {
		G.getVertexByName("A").setH(2);
		G.getVertexByName("B").setH(3);
		G.getVertexByName("C").setH(1);
		G.getVertexByName("D").setH(2);
		G.getVertexByName("E").setH(1);
		G.getVertexByName("F").setH(1);
		G.getVertexByName("H").setH(4);
		G.getVertexByName("I").setH(2);
		G.getVertexByName("J").setH(1);
	}

	public static void testBFS(Graph<String> G, String name) {
		System.out.print("BFS on G starting from " + name + ": ");
		GraphTraversals.BreadthFirstSearch(G, G.getVertexByName(name));
		System.out.println("");

		// Here the parents of the vertices are the BFS tree starting from the source 
		System.out.print("The path from " + name + " to Target: ");
		GraphTraversals.printPath(G.getVertexByName("Target"));
	}


	public static void testDFS(Graph<String> G, String name, int i) {
		if (i==1) {
			System.out.print("DFS *mark visited at push() on G starting from " + name + ": ");
			GraphTraversals.DepthFirstSearch1(G, G.getVertexByName(name));
		}
		else {
			System.out.print("DFS *mark visited at pop() on G starting from " + name + ": ");
			GraphTraversals.DepthFirstSearch2(G, G.getVertexByName(name));
		}
		System.out.println("");

		// Here the parents of the vertices are the DFS tree starting from the source 
		System.out.print("The path from G to " + name + " : ");
		GraphTraversals.printPath(G.getVertexByName("Target"));
	}


	public static void testAstar(Graph<String> G, String name) {
		setHrand(G);

		System.out.print("A* on G starting from " + name + ": ");
		GraphTraversals.Astar(G, G.getVertexByName(name));
	}


	public static void main(String[] args) {
		Graph<String> G = createGraph();

//		testBFS(G,"A");
//		System.out.println("--------");
//
//		testBFS(G,"B");
//		System.out.println("--------");
//
//		testDFS(G,"E",1);
//		System.out.println("--------");
//
//		testDFS(G,"E",2);
//		System.out.println("--------");

		testAstar(G,"E");

	}
}
