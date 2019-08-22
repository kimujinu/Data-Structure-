package Section3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Class_Object_Reference_Code5 {
	
	MyRectangle1[] rects = new MyRectangle1[100];
	int n = 0;
	
	public static void main(String[] args) {
		Class_Object_Reference_Code5 Main = new Class_Object_Reference_Code5();
		Main.start();
	}
	
	public void start() {
		solve();
		}
		  
	public void solve() {
	
		try {
			Scanner scan = new Scanner(new File("sample.txt"));
			while(scan.hasNext()) {
			rects[n] = new MyRectangle1();
			rects[n].lu = new MyPoint1();
			rects[n].lu.x =  scan.nextInt();
			rects[n].lu.y = scan.nextInt();
			rects[n].width = scan.nextInt();
			rects[n].height = scan.nextInt();
			
			n++;
			}
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("No File");
			System.exit(1);
		}
		bubblesort();
		for(int i=0;i<n;i++) {
			System.out.println(rects[i].lu.x + " " + rects[i].lu.y + " " + rects[i].width+ " " + rects[i].height);
		}
	}
	public void bubblesort() {
		for(int i= n-1; i>0;i--) {
			for(int j = 0; j<i;j++) {
				if(cal(rects[j]) > cal(rects[j+1])) {
					MyRectangle1 tmp = rects[j];
					rects[j] = rects[j+1];
					rects[j+1]  = tmp;
				}
			}
		}
	}
	public int cal(MyRectangle1 r) {
		return r.width * r.height;
	}
	
	
}
