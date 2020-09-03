package Section10;

public class Tree_example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node("Zzz");
		Node node4 = new Node("Jinwoo");
		
		node1.makeLeftSubTree(node2);
		node1.makeRightSubTree(node3);
		node2.makeLeftSubTree(node4);
		
		System.out.println("노드1의 왼쪽 자식 노드 : " + node1.getLeftSubTree().getData());
		System.out.println("노드1의 왼쪽 자식 노드 : " + node1.getRightSubTree().getData());
		System.out.println("노드2의 왼쪽 자식 노드 : " + node2.getLeftSubTree().getData());
	}

}

class Node {

	private Node left;
	private Node right;
	private Object data;
	
	public Node(Object data) {
		left = null;
		right = null;
		this.data = data;
	}
	
	// 왼쪽 자식 노드와 연결해주는 메소드
	public void makeLeftSubTree(Node sub) {
		if(this.left != null) {
			this.left = null;
		}
		this.left = sub;
	}
	
	// 오른쪽 자식 노드와 연결해주는 메소드
	public void makeRightSubTree(Node sub) {
		if(this.right != null) {
			this.right = null;
		}
		this.right = sub;
	}
	
	public Object getData() {
		return this.data;
	}
	
	public Node getLeftSubTree() {
		return this.left;
	}
	
	public Node getRightSubTree() {
		return this.right;
	}
}
