package graph;

import java.util.Iterator;

public class DenseGraph {

	int nvertex;

	int[][] adjMatrix;

	/**
	 * creates an empty graph on n nodes
	 * the "names" of the vertices are 0,1,..,n-1 
	 * @param n - number of vertices in the graph
	 */
	public DenseGraph(int n) {
		this.nvertex = n;
		this.adjMatrix = new int[n][n];
	}


	/**
	 * @return the adjacency matrix representing the graph
	 */
	public int[][] getAdjacencyMatrix() {
		return adjMatrix;
	}

	/**
	 * adds the edge (i,j) to the graph  
	 * no effect if i and j were already adjacent
	 * @param i, j - vertices in the graph
	 */
	public void addEdge(int i, int j) {
		adjMatrix[i][j] = 1;
		adjMatrix[j][i] = 1;
	}

	/**
	 * removes the edge (i,j) from the graph
	 * no effect if i and j were not adjacent
	 * @param i, j - vertices in the graph
	 */
	public void removeEdge(int i, int j) {
		adjMatrix[i][j] = 0;
		adjMatrix[j][i] = 0;
	}

	/**
	 * @param i, j - vertices in the graph
	 * @return true if (i,j) is an edge in the graph, and false otherwise
	 */
	public boolean areAdjacent(int i, int j) {
		return adjMatrix[i][j] != 0;
	}

	/**
	 * @param i - a vertex in the graph
	 * @return the degree of i
	 */
	public int degree(int i) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * The iterator must output the neighbors of i in the increasing order
	 * Assumption: the graph is not modified during the use of the iterator 
	 * @param i - a vertex in the graph
	 * @return an iterator that returns the neighbors of i
	 */
	public Iterator<Integer> neighboursIterator(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return number of vertices in the graph
	 */
	public int numberOfVertices() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @return number of edges in the graph
	 */
	public int numberOfEdges() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @param i, j - vertices in the graph
	 * @return distance between i and j in the graph
	 */
	public int distance(int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @param n - number of vertices
	 * @param p - number between 0 and 1
	 * @return a random graph on n vertices, where each edge is added to the graph with probability p
	 */
	public static DenseGraph generateRandomGraph(int n, double p) {
		// TODO Auto-generated method stub
		return null;
	}

}
