package graph;

import java.util.*;

public class GraphTraversals {

	public static <T> void setAllUnvisited(Graph<T> G) {
		for (Vertex<T> v : G.getVertices()) {
			v.setVisited(false);
			v.setParent(null);
		}
	}


	private static <T> void printPathRec(Vertex<T> target) {
		if (target.getParent() == null) {
			System.out.print(target.getName());
		}
		else {
			printPathRec(target.getParent());
			System.out.print(" -> " + target.getName());
		}
	}

	public static <T> void printPath(Vertex<T> target) {
		printPathRec(target);
		System.out.println();
	}

	/**
	 * runs a BFS traversal
	 * 
	 * @param <T>
	 * @param G - graph
	 * @param source - starting vertex. Assumption: source is a vertex in G.
	 */
	public static <T> void BreadthFirstSearch(Graph<T> G, Vertex<T> source) {
		setAllUnvisited(G);

		LinkedList<Vertex<T>> queue = new LinkedList<Vertex<T>>();
		queue.addLast(source);
		source.setVisited(true);

		while (!queue.isEmpty()) {
			Vertex<T> v = queue.removeFirst();
			System.out.print(v.getName() + " ");
			Set<Vertex<T>> Nv = G.getNeighbours(v);
			for (Vertex<T> u : Nv) {
				if (!u.isVisited()) {
					queue.addLast(u);
					u.setVisited(true);
					u.setParent(v);
				}
			}  
		}
	}

	/**
	 * runs a DFS traversal with u.setVisited(true) when vertex added to the stack
	 * 
	 * @param <T>
	 * @param G - graph
	 * @param source - starting vertex. Assumption: source is a vertex in G.
	 */
	public static <T> void DepthFirstSearch1(Graph<T> G, Vertex<T> source) {
		setAllUnvisited(G);

		Stack<Vertex<T>> stack = new Stack<Vertex<T>>();
		stack.push(source);
		source.setVisited(true);

		while (!stack.isEmpty()) {
			Vertex<T> v = stack.pop();
			System.out.print(v.getName() + " ");
			Set<Vertex<T>> Nv = G.getNeighbours(v);
			for (Vertex<T> u : Nv) {
				if (!u.isVisited()) {
					stack.push(u);
					u.setVisited(true);
					u.setParent(v);
				}
			}  
		}
	}


	/**
	 * runs a DFS traversal with u.setVisited(true) when vertex is removed from the stack
	 * 
	 * @param <T>
	 * @param G - graph
	 * @param source - starting vertex. Assumption: source is a vertex in G.
	 */
	public static <T> void DepthFirstSearch2(Graph<T> G, Vertex<T> source) {
		setAllUnvisited(G);

		Stack<Vertex<T>> stack = new Stack<Vertex<T>>();
		stack.push(source);

		while (!stack.isEmpty()) {
			Vertex<T> v = stack.pop();
			if (!v.isVisited())
				System.out.print(v.getName() + " ");
			v.setVisited(true);
			Set<Vertex<T>> Nv = G.getNeighbours(v);
			for (Vertex<T> u : Nv) {
				if (!u.isVisited()) {
					stack.push(u);
					u.setParent(v);
				}
			}  
		}
	}

	/**
	 * runs a A* on G
	 * 
	 * @param <T>
	 * @param G - graph
	 * @param source - starting vertex. Assumption: source is a vertex in G.
	 */
	public static <T> void Astar(Graph<T> G, Vertex<T> source) {
		
		PriorityQueue<Vertex<T>> openQueue = new PriorityQueue<Vertex<T>>(
				new Comparator<Vertex<T>>() {
					public int compare(Vertex<T> v1, Vertex<T> v2) {
						return v1.getF() - v2.getF();
					}
				});

		Map<Vertex<T>, Integer> closedSet = new HashMap<Vertex<T>, Integer>();

		source.setG(0);
		source.setParent(null);
		openQueue.add(source);
		while (!openQueue.isEmpty()) {
			Vertex<T> v = openQueue.remove();
			Set<Vertex<T>> Nv = G.getNeighbours(v); // in the project generateAllNeighbours(v)
			for (Vertex<T> u : Nv) {
				if (u.getName().equals("Target")) { // check if u is a solved state
					u.setG(v.getG()+1);
					u.setParent(v);
					printPath(u);
					return;
				}
				else if (!openQueue.contains(u) && !closedSet.containsKey(u)) {
					u.setG(v.getG()+1);
					u.setParent(v);
					openQueue.add(u);
				}
				// can make it more sophisticated: 
				// e.g. check if u is in openQueue with a higher value - update the value of u
				// or move from closedSet to openQueue
			}
			closedSet.put(v, v.getF()); // here could use a set, no need to use a Map
		}


	}



}
