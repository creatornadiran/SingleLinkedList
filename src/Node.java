public class Node {
	private Node link;
	private Object data;
	public Node(Object data) {
		this.data = data;
		link = null;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object item) {
		data= item;
	}
	public Node getLink() {
		return link;
	}
	public void setLink(Node link) {
		this.link = link;
	}
}
