package Section7;

import Section7.DoublyLinkedList.ListIterator;

public class Doubly_Linked_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Doubly_Linked_List Main = new Doubly_Linked_List();
		Main.start();
	}
	
	public void start() {
		solve();
	}
	
	public void solve() {
		DoublyLinkedList numbers = new DoublyLinkedList();
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		
		ListIterator i = numbers.listIterator();
		while(i.hasNext()) {
			int number = (int)i.next();
			if(number == 20) {
				i.remove();
			}
		}
	
	}
	

}

class DoublyLinkedList {
	
	private Node head;// ù��° ��带 ����Ű�� �ʵ�
	private Node tail;
	private int size=0;
	
	private class Node{
		private Object data;// �����Ͱ� ����� �ʵ�
		private Node next;// ���� ��带 ����Ű�� �ʵ�
		private Node prev;
		
		public Node(Object input) {
			this.data = input;
			this.next = null;
			this.prev = null;
		}
		
		public String toString() { // ����� ������ ���� ����ؼ� Ȯ���غ� �� �ִ� ���
			return String.valueOf(this.data);
		}
		
	}
	public void addFirst(Object input) {
	    Node newNode = new Node(input);// ��带 �����մϴ�.
	    newNode.next = head;// ���ο� ����� ���� ���� ��带 �����մϴ�.
	    if (head != null)  // ������ ��尡 �־��ٸ� ���� ����� ���� ���� ���ο� ��带 �����մϴ�.
	        head.prev = newNode;
	    head = newNode; // ���� ���ο� ��带 �����մϴ�.
	    size++;
	    if (head.next == null) {
	        tail = head;
	    }
	}

	public void addLast(Object input) {
	   
	    Node newNode = new Node(input); // ��带 �����մϴ�.
	  
	    if (size == 0) {  // ����Ʈ�� ��尡 ���ٸ� ù��° ��带 �߰��ϴ� �޼ҵ带 ����մϴ�.
	        addFirst(input);
	    } else {
	        tail.next = newNode;// tail�� ���� ���� ������ ��带 �����մϴ�.
	        newNode.prev = tail;// ���ο� ����� ���� ���� tail�� �����մϴ�.
	        tail = newNode;// ������ ��带 �����մϴ�.
	        size++;// ������Ʈ�� ������ 1 ���� ��ŵ�ϴ�.
	    }
	}
	
	Node node(int index) {
	    if (index < size / 2) {// ����� �ε����� ��ü ��� ���� �ݺ��� ū�� ������ ���
	        Node x = head; // head���� next�� �̿��ؼ� �ε����� �ش��ϴ� ��带 ã���ϴ�.
	        for (int i = 0; i < index; i++)
	            x = x.next;
	        return x;
	    } else {
	        Node x = tail;  // tail���� prev�� �̿��ؼ� �ε����� �ش��ϴ� ��带 ã���ϴ�.
	        for (int i = size - 1; i > index; i--)
	            x = x.prev;
	        return x;
	    }
	}
	
	public void add(int k, Object input) {
	   
	    if (k == 0) { // ���� k�� 0�̶�� ù��° ��忡 �߰��ϴ� ���̱� ������ addFirst�� ����մϴ�.
	        addFirst(input);
	    } else {
	        Node temp1 = node(k - 1);
	        Node temp2 = temp1.next;  // k ��° ��带 temp2�� �����մϴ�.
	        Node newNode = new Node(input);// ���ο� ��带 �����մϴ�.
	        temp1.next = newNode; // temp1�� ���� ���� ���ο� ��带 �����մϴ�.
	        newNode.next = temp2;// ���ο� ����� ���� ���� temp2�� �����մϴ�.
	        if (temp2 != null)// temp2�� ���� ���� ���ο� ��带 �����մϴ�.
	            temp2.prev = newNode;
	        newNode.prev = temp1;  // ���ο� ����� ���� ���� temp1�� �����մϴ�.
	        size++;
	        if (newNode.next == null) {  // ���ο� ����� ���� ��尡 ���ٸ� ���ο� ��尡 ������ ����̱� ������ tail�� �����մϴ�.
	            tail = newNode;
	        }
	    }
	}
	
	public Object removeFirst() {
	    Node temp = head;   // ù��° ��带 temp�� �����ϰ� head�� ���� �ι�° ���� �����մϴ�.
	    head = temp.next;
	    Object returnData = temp.data; // �����͸� �����ϱ� ���� ������ ���� �ӽ� ������ ����ϴ�.
	    temp = null;
	    if (head != null)	    // ����Ʈ ���� ��尡 �ִٸ� head�� ���� ��带 null�� �����մϴ�.
	        head.prev = null;
	    size--;
	    return returnData;
	}
	
	public Object remove(int k) {
	    if (k == 0)
	        return removeFirst();
	 
	    Node temp = node(k - 1); // k-1��° ��带 temp�� �����մϴ�.
	    Node todoDeleted = temp.next;// temp.next�� �����ϱ� ���� todoDeleted ������ �����մϴ�.
	    temp.next = temp.next.next;	    // ���� ��� ��带 ���ῡ�� �и��մϴ�.
	    if (temp.next != null) {
	        temp.next.prev = temp;	        // ������ ����� ���� ��带 �����մϴ�.
	    }
	    Object returnData = todoDeleted.data;	    // ������ ����� �����͸� �����ϱ� ���ؼ� returnData�� �����͸� �����մϴ�.
	    if (todoDeleted == tail) {	    // ������ ��尡 tail�̾��ٸ� tail�� ���� ��带 tail�� �����մϴ�.
	        tail = temp;
	    }
	    todoDeleted = null;	    // cur.next�� ���� �մϴ�.
	    size--;
	    return returnData;
	}
	
	public Object removeLast() {
	    return remove(size - 1);
	}
	
	public int size() {
    	return size;
    }
	
	public Object get(int k) {
	    Node temp = node(k);
	    return temp.data;
	}
	
	public int indexOf(Object data) {
	    Node temp = head;    // Ž�� ����� �Ǵ� ��带 temp�� �����մϴ�.
	    int index = 0; // Ž�� ����� ���° ������Ʈ�� �ִ����� �ǹ��ϴ� ������ index�� ����մϴ�.
	    while (temp.data != data) {  // Ž�� ���� Ž�� ����� ���� ���մϴ�.
	        temp = temp.next;
	        index++;
	        if (temp == null)   // temp�� ���� null�̶�� ���� �� �̻� Ž�� ����� ���ٴ� ���� �ǹ��մϴ�.�� �� -1�� �����մϴ�.
	            return -1;
	    }
	    return index;	    // Ž�� ����� ã�Ҵٸ� ����� �ε��� ���� �����մϴ�.

	}
	
	public ListIterator listIterator() {
    	return new ListIterator();
    }
	
	public class ListIterator {
	    private Node lastReturned;
	    private Node next;
	    private int nextIndex;
	    
	    ListIterator() {
	        next = head;
	        nextIndex = 0;
	    }
	 // �� �޼ҵ带 ȣ���ϸ� cursor�� �������� ���� cursor.next�� ����˴ϴ�.
	    public Object next() {
	        lastReturned = next;
	        next = next.next;
	        nextIndex++;
	        return lastReturned.data;
	    }
	     
	    // cursor�� ���� ���ٸ� �ٽ� ���ؼ� �� �̻� next�� ���ؼ� ������ ��尡 ���ٸ� false�� �����մϴ�.
	    // �̸� ���ؼ� next�� ȣ���ص� �Ǵ����� ������ �Ǵ��� �� �ֽ��ϴ�.
	    public boolean hasNext() {
	        return nextIndex < size();
	    }
	     
	    public boolean hasPrevious() {
	        return nextIndex > 0;
	    }
	     
	    public Object previous() {
	        if (next == null) {
	            lastReturned = next = tail;
	        } else {
	            lastReturned = next = next.prev;
	        }
	        nextIndex--;
	        return lastReturned.data;
	    }
	    
	    public void add(Object input) { //Ž�� �������� ����� ����, �߰��� ���õ� �۾�
	        Node newNode = new Node(input);
	        if (lastReturned == null) {
	            head = newNode;
	            newNode.next = next;
	        } else {
	            lastReturned.next = newNode;
	            newNode.prev = lastReturned;
	            if (next != null) {
	                newNode.next = next;
	                next.prev = newNode;
	            } else {
	                tail = newNode;
	            }
	        }
	        lastReturned = newNode;
	        nextIndex++;
	        size++;
	    }
	    
	    public void remove() {
	        if (nextIndex == 0) {
	            throw new IllegalStateException();
	        }
	        Node n = lastReturned.next;
	        Node p = lastReturned.prev;
	     
	        if (p == null) {
	            head = n;
	            head.prev = null;
	            lastReturned = null;
	        } else {
	            p.next = next;
	            lastReturned.prev = null;
	        }
	     
	        if (n == null) {
	            tail = p;
	            tail.next = null;
	        } else {
	            n.prev = p;
	        }
	     
	        if (next == null) {
	            lastReturned = tail;
	        } else {
	            lastReturned = next.prev;
	        }
	     
	        size--;
	        nextIndex--;
	     
	    }
	}
	
	
}
