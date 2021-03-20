package graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
		int total = 0;
		for (int k = 0; k < nvertex; k++) {
			total += adjMatrix[i][k];
		}
		return total;
	}
	
	/**
	 * The iterator must output the neighbors of i in the increasing order
	 * Assumption: the graph is not modified during the use of the iterator 
	 * @param i - a vertex in the graph
	 * @return an iterator that returns the neighbors of i
	 */
	public Iterator<Integer> neighboursIterator(int i) {
		
		class NeighboursIterator implements Iterator<Integer> {

			List<Integer> neighbors;

			int index;

			public NeighboursIterator(int[][] adjMatrix, int i, int nvertex) {
				this.neighbors = IntStream
						.range(0, adjMatrix[i].length)
						.filter(k -> adjMatrix[i][k] != 0)
						.boxed()
						.collect(Collectors.toList());
				this.index = 0;
			}

			@Override
			public boolean hasNext() {
				return index < neighbors.size();
			}

			@Override
			public Integer next() {
				Integer value = neighbors.get(index);
				index += 1;
				return value;
			}

		}

		return new NeighboursIterator(adjMatrix, i, nvertex);
	}

	/**
	 * @return number of vertices in the graph
	 */
	public int numberOfVertices() {
		return nvertex;
	}

	/**
	 * @return number of edges in the graph
	 */
	public int numberOfEdges() {
		int total = 0;
		for (int i = 0; i < nvertex; i++) {
			for (int j = 0; j < nvertex; j++) {
				total += adjMatrix[i][j];
			}
		}
		return total / 2;
	}

	/**
	 * @param i, j - vertices in the graph
	 * @return distance between i and j in the graph
	 */
	public int distance(int i, int j) {

		class QueueEntry implements Comparable<QueueEntry> {

			Integer dist;
			
			Integer node;

			public QueueEntry(Integer dist, Integer node) {
				this.dist = dist;
				this.node = node;
			}

			@Override
			public int compareTo(QueueEntry o) {
				return Integer.compare(dist, o.dist);
			}
			
		}

		PriorityQueue<QueueEntry> q = new PriorityQueue<>();
		q.add(new QueueEntry(0, i));

		int[] distances = new int[nvertex];
		Arrays.fill(distances, Integer.MAX_VALUE);

		while (!q.isEmpty()) {
			var entry = q.remove();
			if (entry.node == j) {
				return entry.dist;
			}

			for (int k = 0; k < nvertex; k++) {
				if (adjMatrix[entry.node][k] != 0) {
					Integer alt = entry.dist + 1;
					if (alt < distances[k]) {
						distances[k] = alt;
						q.add(new QueueEntry(alt, k));
					}
				}
			}
		}

		return 0;
	}

	/**
	 * @param n - number of vertices
	 * @param p - number between 0 and 1
	 * @return a random graph on n vertices, where each edge is added to the graph with probability p
	 */
	public static DenseGraph generateRandomGraph(int n, double p) {
		DenseGraph graph = new DenseGraph(n);
		int[][] generated = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (generated[i][j] == 0 && generated[j][i] == 0) {
					double r = Math.random();
					if (r < p) {
						graph.addEdge(i, j);
					}
					generated[i][j] = 1;
					generated[j][i] = 1;
				}
			}
		}
		return graph;
	}

}
