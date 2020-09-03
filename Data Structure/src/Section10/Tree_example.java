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
		
		System.out.println("���1�� ���� �ڽ� ��� : " + node1.getLeftSubTree().getData());
		System.out.println("���1�� ���� �ڽ� ��� : " + node1.getRightSubTree().getData());
		System.out.println("���2�� ���� �ڽ� ��� : " + node2.getLeftSubTree().getData());
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
	
	// ���� �ڽ� ���� �������ִ� �޼ҵ�
	public void makeLeftSubTree(Node sub) {
		if(this.left != null) {
			this.left = null;
		}
		this.left = sub;
	}
	
	// ������ �ڽ� ���� �������ִ� �޼ҵ�
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
