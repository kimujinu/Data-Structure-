package Section6;

import java.util.ArrayList;
import java.util.List;

public class Stack {
	//리스트를 이용한 pop, push 기능 구현 LIFO 
	List data_stack = new ArrayList();
	
	public static void main(String[] args) {
		Stack Main = new Stack();
		Main.start();
	}
	
	public void start() {
		solve();
	}
	
	public void solve() {
		for(int i=0;i<10;i++) {
			push(i);
		}
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
	}
	
	public void push(int data) {
		data_stack.add(data);
	}
	
	public int pop() {
		int data = (int) data_stack.get(data_stack.size()-1);
		data_stack.remove(data_stack.size()-1);
		return data;
	}

}
