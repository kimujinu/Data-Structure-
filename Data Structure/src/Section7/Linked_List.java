package Section7;

public class Linked_List {
    //필요할때마다 데이터를 추가할수있는 구조 :Linked_List , 배열의 단점 보완
	//Linked_List 기본 구조와 용어 : 노드 : 데이터 저장 단위(데이터값, 포인터)로 구성
							//포인터 : 각 노드안에서 , 다음이나 이전의 노드와의 연결 정보를 가지고 있는 공간
	// Linked_List 장점 : 미리 데이터 공간을 미리 할당하지 않아도 됨. 배열은 미리 데이터 공간을 할당 해야함
	// Linked_List 단점 : 연결을 위한 별도 데이터 공간이 필요하여, 저장공간 효율이 낮음, 접근 속도 느림.
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
		numbers.add(2, 25); // 2번째 자리에 25삽입
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
    private Node head;// 첫번째 노드를 가리키는 필드
    private Node tail;
    private int size = 0;
    private class Node{
        private Object data;  // 데이터가 저장될 필드
        private Node next;    // 다음 노드를 가리키는 필드
        public Node(Object input) {
            this.data = input;
            this.next = null;
        }
        public String toString(){ // 노드의 내용을 쉽게 출력해서 확인해볼 수 있는 기능
            return String.valueOf(this.data);
        }
    }
    public void addFirst(Object input) {
        Node newNode = new Node(input);// 노드를 생성합니다.
        newNode.next = head; // 새로운 노드의 다음 노드로 해드를 지정합니다.
        head = newNode;  // 헤드로 새로운 노드를 지정합니다.
        size++;
        if(head.next == null){
            tail = head;
        }
    }
    
    public void addLast(Object input) {
        Node newNode = new Node(input);// 노드를 생성합니다.
        if(size == 0){// 리스트의 노드가 없다면 첫번째 노드를 추가하는 메소드를 사용합니다.
            addFirst(input);
        } else {
            tail.next = newNode; // 마지막 노드의 다음 노드로 생성한 노드를 지정합니다.
            tail = newNode; // 마지막 노드를 갱신합니다.
            size++; // 엘리먼트의 개수를 1 증가 시킵니다.
        }
    }
    
    Node node(int index) { //특정 위치의 노드를 찾아내는 메소드
    	Node x = head;
    	for(int i=0;i<index;i++) {
    		x = x.next;
    	}
    	return x;
    }
    
    public void add(int k, Object input) { //node 메소드를 이용하여 특정위치에 노드를 추가하는 메소드
    	if(k==0) { // 만약 k가 0이라면 첫번째 노드에 추가하는 것이기 때문에 addfirst 사용
    		addFirst(input);
    	} else {
    		Node temp1 = node(k-1); 
    		Node temp2 = temp1.next; //k번째 노드를 temp2로 지정
    		Node newNode = new Node(input); //새로운 노드를 생성
    		temp1.next = newNode; //tmpe1의 다음 노드로 새로운 노드를 지정
    		newNode.next = temp2; // 새로운 노드의 다음 노드로 temp2로 지정합니다.
    		size++;
    		if(newNode.next == null) {// 새로운 노드의 다음 노드가 없다면 새로운 노드가 마지막 노드이기 때문에 tail로 지정합니다.
    			tail=newNode;
    		}
    	}
    }
    
    public String toString() {
    	if(head==null) { // 노드가 없다면 []를 리턴합니다.
    		return "[]";
    	}
    	
    	Node temp = head; // 탐색을 시작합니다.
    	String str = "[";
    	
    	while(temp.next != null) {// 다음 노드가 없을 때까지 반복문을 실행합니다.
    		str += temp.data +", ";
    		temp = temp.next;// 마지막 노드는 다음 노드가 없기 때문에 아래의 구문은 마지막 노드는 제외됩니다.
    	}
    	str += temp.data;  // 마지막 노드를 출력결과에 포함시킵니다.
    	
    	return str+"]";
    }
    
    public Object removeFirst() {
    	Node temp = head; //첫번째 노드를 temp로 지정하고 head의 값을 두번째 노드로 변경합니다.
    	head = temp.next; 
    	
    	Object returnData = temp.data; // 데이터를 삭제하기 전에 리턴할 값을 임시 변수에 담습니다.
    	temp = null;
    	size--;
    	
    	return returnData;
    }
    
    public Object remove(int k) { //중간의 데이터 삭제하는 메소드
    	if(k==0) 
    		return removeFirst();
    	
    		Node temp = node(k-1); //k-1번째 노드를 temp의 값으로 지정
    		Node todoDeleted = temp.next; //삭제 노드를 todoDeleted에 기록, 삭제노드를 지금 제거하면 삭제 앞과 뒷노드를 연결이 불가능
    		temp.next = temp.next.next;// 삭제 앞 노드의 다음 노드로 삭제뒤 노드를 지정
    		Object returnData = todoDeleted.data; //삭제된 데이터를 리턴하기위해 데이터를 저장
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
    	Node temp = head; // 탐색 대상이 되는 노드를 temp로 지정합니다.
    	int index = 0;// 탐색 대상이 몇번째 엘리먼트에 있는지를 의미하는 변수로 index를 사용합니다.
    	while(temp.data != data) {  // 탐색 값과 탐색 대상의 값을 비교합니다.
    		temp = temp.next;
    		index++;
    		if(temp == null) {// temp의 값이 null이라는 것은 더 이상 탐색 대상이 없다는 것을 의미합니다.이 때 -1을 리턴합니다.
    			return -1;
    		}
    	}
    	
    	return index; // 탐색 대상을 찾았다면 대상의 인덱스 값을 리턴합니다.
    }
    
    //todo Iterator
}
