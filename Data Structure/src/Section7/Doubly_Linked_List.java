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
	
	private Node head;// 첫번째 노드를 가리키는 필드
	private Node tail;
	private int size=0;
	
	private class Node{
		private Object data;// 데이터가 저장될 필드
		private Node next;// 다음 노드를 가리키는 필드
		private Node prev;
		
		public Node(Object input) {
			this.data = input;
			this.next = null;
			this.prev = null;
		}
		
		public String toString() { // 노드의 내용을 쉽게 출력해서 확인해볼 수 있는 기능
			return String.valueOf(this.data);
		}
		
	}
	public void addFirst(Object input) {
	    Node newNode = new Node(input);// 노드를 생성합니다.
	    newNode.next = head;// 새로운 노드의 다음 노드로 헤드를 지정합니다.
	    if (head != null)  // 기존에 노드가 있었다면 현재 헤드의 이전 노드로 새로운 노드를 지정합니다.
	        head.prev = newNode;
	    head = newNode; // 헤드로 새로운 노드를 지정합니다.
	    size++;
	    if (head.next == null) {
	        tail = head;
	    }
	}

	public void addLast(Object input) {
	   
	    Node newNode = new Node(input); // 노드를 생성합니다.
	  
	    if (size == 0) {  // 리스트의 노드가 없다면 첫번째 노드를 추가하는 메소드를 사용합니다.
	        addFirst(input);
	    } else {
	        tail.next = newNode;// tail의 다음 노드로 생성한 노드를 지정합니다.
	        newNode.prev = tail;// 새로운 노드의 이전 노드로 tail을 지정합니다.
	        tail = newNode;// 마지막 노드를 갱신합니다.
	        size++;// 엘리먼트의 개수를 1 증가 시킵니다.
	    }
	}
	
	Node node(int index) {
	    if (index < size / 2) {// 노드의 인덱스가 전체 노드 수의 반보다 큰지 작은지 계산
	        Node x = head; // head부터 next를 이용해서 인덱스에 해당하는 노드를 찾습니다.
	        for (int i = 0; i < index; i++)
	            x = x.next;
	        return x;
	    } else {
	        Node x = tail;  // tail부터 prev를 이용해서 인덱스에 해당하는 노드를 찾습니다.
	        for (int i = size - 1; i > index; i--)
	            x = x.prev;
	        return x;
	    }
	}
	
	public void add(int k, Object input) {
	   
	    if (k == 0) { // 만약 k가 0이라면 첫번째 노드에 추가하는 것이기 때문에 addFirst를 사용합니다.
	        addFirst(input);
	    } else {
	        Node temp1 = node(k - 1);
	        Node temp2 = temp1.next;  // k 번째 노드를 temp2로 지정합니다.
	        Node newNode = new Node(input);// 새로운 노드를 생성합니다.
	        temp1.next = newNode; // temp1의 다음 노드로 새로운 노드를 지정합니다.
	        newNode.next = temp2;// 새로운 노드의 다음 노드로 temp2를 지정합니다.
	        if (temp2 != null)// temp2의 이전 노드로 새로운 노드를 지정합니다.
	            temp2.prev = newNode;
	        newNode.prev = temp1;  // 새로운 노드의 이전 노드로 temp1을 지정합니다.
	        size++;
	        if (newNode.next == null) {  // 새로운 노드의 다음 노드가 없다면 새로운 노드가 마지막 노드이기 때문에 tail로 지정합니다.
	            tail = newNode;
	        }
	    }
	}
	
	public Object removeFirst() {
	    Node temp = head;   // 첫번째 노드를 temp로 지정하고 head의 값을 두번째 노드로 변경합니다.
	    head = temp.next;
	    Object returnData = temp.data; // 데이터를 삭제하기 전에 리턴할 값을 임시 변수에 담습니다.
	    temp = null;
	    if (head != null)	    // 리스트 내에 노드가 있다면 head의 이전 노드를 null로 지정합니다.
	        head.prev = null;
	    size--;
	    return returnData;
	}
	
	public Object remove(int k) {
	    if (k == 0)
	        return removeFirst();
	 
	    Node temp = node(k - 1); // k-1번째 노드를 temp로 지정합니다.
	    Node todoDeleted = temp.next;// temp.next를 삭제하기 전에 todoDeleted 변수에 보관합니다.
	    temp.next = temp.next.next;	    // 삭제 대상 노드를 연결에서 분리합니다.
	    if (temp.next != null) {
	        temp.next.prev = temp;	        // 삭제할 노드의 전후 노드를 연결합니다.
	    }
	    Object returnData = todoDeleted.data;	    // 삭제된 노드의 데이터를 리턴하기 위해서 returnData에 데이터를 저장합니다.
	    if (todoDeleted == tail) {	    // 삭제된 노드가 tail이었다면 tail을 이전 노드를 tail로 지정합니다.
	        tail = temp;
	    }
	    todoDeleted = null;	    // cur.next를 삭제 합니다.
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
	    Node temp = head;    // 탐색 대상이 되는 노드를 temp로 지정합니다.
	    int index = 0; // 탐색 대상이 몇번째 엘리먼트에 있는지를 의미하는 변수로 index를 사용합니다.
	    while (temp.data != data) {  // 탐색 값과 탐색 대상의 값을 비교합니다.
	        temp = temp.next;
	        index++;
	        if (temp == null)   // temp의 값이 null이라는 것은 더 이상 탐색 대상이 없다는 것을 의미합니다.이 때 -1을 리턴합니다.
	            return -1;
	    }
	    return index;	    // 탐색 대상을 찾았다면 대상의 인덱스 값을 리턴합니다.

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
	 // 본 메소드를 호출하면 cursor의 참조값이 기존 cursor.next로 변경됩니다.
	    public Object next() {
	        lastReturned = next;
	        next = next.next;
	        nextIndex++;
	        return lastReturned.data;
	    }
	     
	    // cursor의 값이 없다면 다시 말해서 더 이상 next를 통해서 가져올 노드가 없다면 false를 리턴합니다.
	    // 이를 통해서 next를 호출해도 되는지를 사전에 판단할 수 있습니다.
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
	    
	    public void add(Object input) { //탐색 과정에서 노드의 삭제, 추가와 관련된 작업
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
