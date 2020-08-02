package Section6;

import java.util.ArrayList;
import java.util.List;

public class Queue {
	//리스트를 이용한 enqueue, dequeue 간단한 기능 구현 FIFO
	List queue_list = new ArrayList();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue Main = new Queue();
		Main.start();
	}
	
	public void start() {
		solve();
	}
	
	public void solve() {
		for(int i=0;i<10;i++) {
			enqueue(i);
		}
		System.out.println(queue_list.size());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
	}
	
	public void enqueue(int data) {
		queue_list.add(data);
	}
	
	public int dequeue() {
		int data = (int) queue_list.get(0);
		queue_list.remove(0);
	
		return data;
	}

}
