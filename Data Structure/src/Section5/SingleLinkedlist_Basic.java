package Section5;
import java.util.Scanner;

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
		list.add(0, "Saturday");
		list.add(1, "Friday");
		list.add(0, "Monday"); //M,S,F
		list.add(2, "Tuesday"); // M,S,T,F
		
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
		
	}

	public void add(int index, T item) { //insert
		
	}
	
	public void remove(int index) { // delete
		
	}
	
	public int indexof(T item) {  // search
		return size;
		
	}
	public T get(int index) {
		return null;
	}
	
	

}
