package Section0;

public class Hanoi_assignment { //201730198 김진우 과제.
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
		
		if(n==1) { //Basecase 재귀 탈출구간
			System.out.println(start+"원판  1를(을)"+target+"로 옮김");
		}else {
			hanoi(n-1,start,target,work);
			System.out.println(start+"원판 "+n+"를(을)"+target+"로 옮김");
			hanoi(n-1,work,start,target);
		}
	}
}
