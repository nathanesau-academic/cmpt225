
public class TestUnionFind<T> {

	public static void testSameSet(Node n1, Node n2) {
		if (UnionFind.find(n1) == UnionFind.find(n2))
			System.out.println("n1 and n2 are in the same set");
		else
			System.out.println("n1 and n2 are in different sets");
	}

	public static void main(String[] args) {
		Node n1 = UnionFind.makeSet(1);
		Node n2 = UnionFind.makeSet(2);
		Node n3 = UnionFind.makeSet(3);
		Node n4 = UnionFind.makeSet(4);
		Node n5 = UnionFind.makeSet(5);
		Node n6 = UnionFind.makeSet(6);
		Node n7 = UnionFind.makeSet(7);
		Node n8 = UnionFind.makeSet(8);

		UnionFind.union(n1, n2);
		UnionFind.union(n3, n4);
		UnionFind.union(n3, n5);
		UnionFind.union(n1, n6);
		UnionFind.union(n1, n7);
		UnionFind.union(n8, n1);

		System.out.println("done");
	}	
}
