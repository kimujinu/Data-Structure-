package Section5;

public class SingleLinkedlist_Basic<T> {

	public Node<T> head;
	public int size = 0;

	public static void main(String[] args) {
		SingleLinkedlist_Basic Main = new SingleLinkedlist_Basic();
		Main.start();
	}

	public void start() {
		solve();
		}

	public void solve() {
		SingleLinkedlist_Basic<String> list = new SingleLinkedlist_Basic<String>();
		list.addFirst("Monday");
		list.addFirst("Sunday");
		list.add(2,"Saturday");
		list.add(2, "Friday");
		list.remove("Friday");
		int index = list.indexof("Saturday");

	
		String str = list.get(2);
		list.remove(2);
		int pos = list.indexof("Friday"); // pos = 2;

	}

	

	public SingleLinkedlist_Basic() {
		head = null;
		size = 0;
	}

	public void addFirst(T item) {

		Node<T> newNode = new Node<T>(item); // T : type parameter
		newNode.next = head;
		head = newNode;
		size++;

	}

	

	public void addAfter(Node<T> before, T item){
		
		Node<T> temp = new Node<T>(item);
		temp.next = before.next;
		before.next = temp;
		size++;

	}

	

	public T removeFirst(){
		if(head == null){
			return null;
		}else {
			Node<T> temp = head;
			head = head.next;
			size--;
			return temp.data;
		}
	}

	

	public T removeAfter(Node<T> before){

		Node<T> temp = before.next;
		if(temp == null){
			return null;
		}else{
			before.next = temp.next;
			size--;
			return temp.data;
		}
	}

 

	public void add(int index, T item) { //insert

		if(index<0 || index>size){
			return;
		}
		if(index == 0){
			addFirst(item);
		}
		else {
		Node<T> q = getNode(index-1);
		addAfter(q,item);
		}
	}

	

	public T remove(int index) { // delete

		if(index <0 || index >= size){
			return null;
		}
		if(index == 0){
			return removeFirst();
		}
		Node<T> prev = getNode(index-1);
		return removeAfter(prev);
	}

	
	public T remove(T item){
		Node<T> p = head, q =null;
		while(p!=null && !p.data.equals(item)){
			q=p;
			p=p.next;
		}

		if(p==null){
			return null;
		}
		if(q==null){
			return removeFirst();
		}
		else{
			return removeAfter(q);
		}

	}

	

	public int indexof(T item) {  // search

		Node<T> p = head;
		int index = 0;
		while(p!=null){
			if(p.data.equals(item)){
				return index;
			}
			p=p.next;
			index++;
		}
		return -1;
	}

	

	public Node<T> getNode(int index){

		if(index<0 || index>=size){
			return null;
		}
		Node<T> p = head;
		for(int i=0;i<index;i++){
			p = p.next;	
		}
		return p;
	}

	public T get(int index) {

		if(index<0 || index>=size){
			return null;
		}
//		Node<T> p = head;
//		for(int i=0;i<index;i++){
//			p = p.next;
//		}
//		return p.data;
		return getNode(index).data;
	}

}