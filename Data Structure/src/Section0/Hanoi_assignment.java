package Section0;

public class Hanoi_assignment { //201730198 ������ ����.
	String start;
	String work;
	String target;
	
	public static void main(String[] args) {
		Hanoi_assignment Main = new Hanoi_assignment();
		Main.start();
	}
	
	public void start() {
		solve();
		}
		  
	public void solve() {
		start = "A";
		work = "B";
		target = "C";
		
		hanoi(5,start,work,target);
	}
	
	public void hanoi(int n,String start,String work,String target) {
		
		if(n==1) { //Basecase ��� Ż�ⱸ��
			System.out.println(start+"����  1��(��)"+target+"�� �ű�");
		}else {
			hanoi(n-1,start,target,work);
			System.out.println(start+"���� "+n+"��(��)"+target+"�� �ű�");
			hanoi(n-1,work,start,target);
		}
	}
}
