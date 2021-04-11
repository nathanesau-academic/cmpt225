
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

		testSameSet(n1, n2);

		System.out.println("union(n1, n3)");
		UnionFind.union(n1, n3);

		System.out.println("union(n4, n5)");
		UnionFind.union(n4, n5);

		System.out.println("union(n2, n5)");
		UnionFind.union(n2, n5);

		testSameSet(n1, n2);

		System.out.println("union(n1, n4)");
		UnionFind.union(n1, n4);

		testSameSet(n1, n2);


	}	
}
