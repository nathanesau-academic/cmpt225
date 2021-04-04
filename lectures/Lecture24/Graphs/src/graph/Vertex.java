package graph;

public class Vertex<T> {
	
	private T name;
	private int hash;

	// used for graph traversals only
	private boolean visited;
	private Vertex<T> parent;

	// used for A*
	private int g; // number of steps so far
	private int h; // heuristic value - estimated distance to target 
	private int f; // g+h

	public Vertex(T name) {
		this.name = name;
		hash = computeHashCode();
	}

	public void setName(T name) {
		this.name = name;
		hash = computeHashCode();
	}
	
	public T getName() {
		return name;
	}

	public void setVisited(boolean flag) {
		visited = flag;
	}

	public boolean isVisited() {
		return visited;
	}
	
	public void setParent(Vertex<T> parent) {
		this.parent = parent;
	}
	
	public Vertex<T> getParent() {
		return parent;
	}

	public int getF() {
		return f;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
		this.f = this.g + this.h;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
		this.f = this.g + this.h;
	}

	
	@Override
	public boolean equals(Object other) {
		
		// skipping all these for sake of efficiency
		//if (other == null)
		//	return false;
		//if (!(other instanceof Vertex<?>))
		//	return false;
		
		if (this.hashCode() != other.hashCode())
			return false;
		
		T otherName = ((Vertex<T>) other).getName();
		return this.getName().equals(otherName);
	}

	
	@Override
	public int hashCode() {
		return hash;
	}
	
	
	// this is ours
	public int computeHashCode() {
		final int prime = 1733;
		return prime * ((name == null) ? 0 : name.hashCode());
		// adding a field hash, compute it in the constructor,
		// and then hashCode() simply return it
		// useful if we compare objects often
	}


}
