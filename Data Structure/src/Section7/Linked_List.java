package Section7;

public class Linked_List {
    //�ʿ��Ҷ����� �����͸� �߰��Ҽ��ִ� ���� :Linked_List , �迭�� ���� ����
	//Linked_List �⺻ ������ ��� : ��� : ������ ���� ����(�����Ͱ�, ������)�� ����
							//������ : �� ���ȿ��� , �����̳� ������ ������ ���� ������ ������ �ִ� ����
	// Linked_List ���� : �̸� ������ ������ �̸� �Ҵ����� �ʾƵ� ��. �迭�� �̸� ������ ������ �Ҵ� �ؾ���
	// Linked_List ���� : ������ ���� ���� ������ ������ �ʿ��Ͽ�, ������� ȿ���� ����, ���� �ӵ� ����.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Linked_List Main = new Linked_List();
		Main.start();
	}
	
	public void start() {
		solve();
	}
	
	public void solve() {
		LinkedList numbers = new LinkedList();
		numbers.addFirst(10); //2
		numbers.addFirst(30); //1
		numbers.addFirst(20); //0
		numbers.addLast(50); //3
		numbers.add(2, 25); // 2��° �ڸ��� 25����
		System.out.println(numbers.node(2));
		System.out.println(numbers);
		numbers.removeFirst();
		System.out.println(numbers);
		System.out.println(numbers.remove(1));
		System.out.println(numbers);
		System.out.println(numbers.removeLast());
		System.out.println(numbers);
		System.out.println(numbers.indexOf(30));
	}
}

 class LinkedList{
    private Node head;// ù��° ��带 ����Ű�� �ʵ�
    private Node tail;
    private int size = 0;
    private class Node{
        private Object data;  // �����Ͱ� ����� �ʵ�
        private Node next;    // ���� ��带 ����Ű�� �ʵ�
        public Node(Object input) {
            this.data = input;
            this.next = null;
        }
        public String toString(){ // ����� ������ ���� ����ؼ� Ȯ���غ� �� �ִ� ���
            return String.valueOf(this.data);
        }
    }
    public void addFirst(Object input) {
        Node newNode = new Node(input);// ��带 �����մϴ�.
        newNode.next = head; // ���ο� ����� ���� ���� �ص带 �����մϴ�.
        head = newNode;  // ���� ���ο� ��带 �����մϴ�.
        size++;
        if(head.next == null){
            tail = head;
        }
    }
    
    public void addLast(Object input) {
        Node newNode = new Node(input);// ��带 �����մϴ�.
        if(size == 0){// ����Ʈ�� ��尡 ���ٸ� ù��° ��带 �߰��ϴ� �޼ҵ带 ����մϴ�.
            addFirst(input);
        } else {
            tail.next = newNode; // ������ ����� ���� ���� ������ ��带 �����մϴ�.
            tail = newNode; // ������ ��带 �����մϴ�.
            size++; // ������Ʈ�� ������ 1 ���� ��ŵ�ϴ�.
        }
    }
    
    Node node(int index) { //Ư�� ��ġ�� ��带 ã�Ƴ��� �޼ҵ�
    	Node x = head;
    	for(int i=0;i<index;i++) {
    		x = x.next;
    	}
    	return x;
    }
    
    public void add(int k, Object input) { //node �޼ҵ带 �̿��Ͽ� Ư����ġ�� ��带 �߰��ϴ� �޼ҵ�
    	if(k==0) { // ���� k�� 0�̶�� ù��° ��忡 �߰��ϴ� ���̱� ������ addfirst ���
    		addFirst(input);
    	} else {
    		Node temp1 = node(k-1); 
    		Node temp2 = temp1.next; //k��° ��带 temp2�� ����
    		Node newNode = new Node(input); //���ο� ��带 ����
    		temp1.next = newNode; //tmpe1�� ���� ���� ���ο� ��带 ����
    		newNode.next = temp2; // ���ο� ����� ���� ���� temp2�� �����մϴ�.
    		size++;
    		if(newNode.next == null) {// ���ο� ����� ���� ��尡 ���ٸ� ���ο� ��尡 ������ ����̱� ������ tail�� �����մϴ�.
    			tail=newNode;
    		}
    	}
    }
    
    public String toString() {
    	if(head==null) { // ��尡 ���ٸ� []�� �����մϴ�.
    		return "[]";
    	}
    	
    	Node temp = head; // Ž���� �����մϴ�.
    	String str = "[";
    	
    	while(temp.next != null) {// ���� ��尡 ���� ������ �ݺ����� �����մϴ�.
    		str += temp.data +", ";
    		temp = temp.next;// ������ ���� ���� ��尡 ���� ������ �Ʒ��� ������ ������ ���� ���ܵ˴ϴ�.
    	}
    	str += temp.data;  // ������ ��带 ��°���� ���Խ�ŵ�ϴ�.
    	
    	return str+"]";
    }
    
    public Object removeFirst() {
    	Node temp = head; //ù��° ��带 temp�� �����ϰ� head�� ���� �ι�° ���� �����մϴ�.
    	head = temp.next; 
    	
    	Object returnData = temp.data; // �����͸� �����ϱ� ���� ������ ���� �ӽ� ������ ����ϴ�.
    	temp = null;
    	size--;
    	
    	return returnData;
    }
    
    public Object remove(int k) { //�߰��� ������ �����ϴ� �޼ҵ�
    	if(k==0) 
    		return removeFirst();
    	
    		Node temp = node(k-1); //k-1��° ��带 temp�� ������ ����
    		Node todoDeleted = temp.next; //���� ��带 todoDeleted�� ���, ������带 ���� �����ϸ� ���� �հ� �޳�带 ������ �Ұ���
    		temp.next = temp.next.next;// ���� �� ����� ���� ���� ������ ��带 ����
    		Object returnData = todoDeleted.data; //������ �����͸� �����ϱ����� �����͸� ����
    		if(todoDeleted == tail) {
    			tail = temp;
    		}
    		
    		todoDeleted = null;
    		size--;
    		
    		return returnData;
    }
    
    public Object removeLast() {
    	return remove(size-1);
    }
    
    public int size() {
    	return size;
    }
    
    public Object get(int k) {
    	Node temp = node(k);
    	return temp.data;
    }
    
    public int indexOf(Object data) {
    	Node temp = head; // Ž�� ����� �Ǵ� ��带 temp�� �����մϴ�.
    	int index = 0;// Ž�� ����� ���° ������Ʈ�� �ִ����� �ǹ��ϴ� ������ index�� ����մϴ�.
    	while(temp.data != data) {  // Ž�� ���� Ž�� ����� ���� ���մϴ�.
    		temp = temp.next;
    		index++;
    		if(temp == null) {// temp�� ���� null�̶�� ���� �� �̻� Ž�� ����� ���ٴ� ���� �ǹ��մϴ�.�� �� -1�� �����մϴ�.
    			return -1;
    		}
    	}
    	
    	return index; // Ž�� ����� ã�Ҵٸ� ����� �ε��� ���� �����մϴ�.
    }
    
    //todo Iterator
}
