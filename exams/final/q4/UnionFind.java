public class UnionFind {

	public static Node makeSet(Object data) {
		return new Node(data);
	}
	
	public static Node find(Node node) {
		if (node.getParent() == null)
			return node;
		else
			return find(node.getParent());
	}
	
	public static <T> void union(Node u, Node v) {
		Node ru = find(u);
		Node rv = find(v);
		if (ru.getRank() > rv.getRank())
			rv.setParent(ru);
		else if (ru.getRank() < rv.getRank())
			ru.setParent(rv);
		else {	// ru.getRank() == rv.getRank()
			ru.setParent(rv);
			rv.setRank(rv.getRank()+1);
		}
	}
	
}
