package graph;

import java.util.*;

public class Graph<T> {

	// an interface supporting the operations add, remove, contains
	// Three standard implementations are: HashSet, TreeSet, LinkedHashSet
	// HashSet implements all operations in O(1) **usually**
	// TreeSet implements all operations in O(log(n)) always: uses Red-Black Trees
	// LinkedHashSet implements all operations in O(1) **usually** 
	private Set<Vertex<T>> vertices;
	
	// The data structure is is also called Dictionary (but the class is obsolete in Java)
	// Has pairs of objects <Key, Value>
	// The interface supports the operations add, remove, contains
	// Three most useful operations are: add a pair, find by Key, remove by Key
	// The standard implementations are: HashMap, TreeMap, LinkedHashSet
	// here Key is a vertex and Value - set of neighbors
	private Map<Vertex<T>, Set<Vertex<T>>> edges;

	public Graph() {
		vertices = new HashSet<Vertex<T>>();
		edges = new HashMap<Vertex<T>, Set<Vertex<T>>>();
	}


	public Set<Vertex<T>> getVertices() {
		return vertices;
	}

	public Vertex<T> getVertexByName(T name) {
		for (Vertex<T> v : vertices)
			if (v.getName().equals(name))
				return v;

		return null;
	}


	public Set<Vertex<T>> getNeighbours(Vertex<T> v) {
		return edges.get(v);
	}

	public boolean addVertex(Vertex<T> v) {
		boolean newNode = vertices.add(v);
		if (newNode)
			edges.put(v, new HashSet<Vertex<T>>());
		return newNode;
	}

	public boolean addVertex(T data) {
		return addVertex(new Vertex<T>(data));
	}

	/** 
	 * returns true if the edge is new to this graph
	 * assume both u and v are already vertices in the graph
	 * @param v
	 * @param u
	 * @return
	 */
	public boolean addEdge(Vertex<T> v, Vertex<T> u) {
		if (vertices.contains(v) && vertices.contains(u))
			return (edges.get(v).add(u) && edges.get(u).add(v)); 
		else
			return false;
	}


	public boolean addEdge(T v, T u) {
		return addEdge(getVertexByName(v), getVertexByName(u));
	}

	public boolean removeEdge(Vertex<T> v, Vertex<T> u) {
		if (vertices.contains(v) && vertices.contains(u))
			return (edges.get(v).remove(u) && edges.get(u).remove(v)); 
		else
			return false;
	}
	

}
