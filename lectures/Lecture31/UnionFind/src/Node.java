
public class Node {
	
	private Object data;
	private Node parent;
	private int rank;
	
	
	public Node(Object data) {
		this.data = data;
		this.parent = null;
		this.rank = 0;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
}
