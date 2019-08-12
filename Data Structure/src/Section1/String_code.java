package Section1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class String_code {
	
	String[] names = new String[1000];
	int[] number = new int[1000];
	int n = 0;
	
	public static void main(String[] args) {
		String_code Main = new String_code();
		Main.start();
	}
	
	public void start() {
		solve();
		}
		  
	public void solve() {
		Scanner scan;
		try {
			 scan = new Scanner(new File("input.txt"));
			 while(scan.hasNext()) {
				names[n] = scan.next();
				number[n] = scan.nextInt();
				n++;
			 }
			 scan.close();
		} catch (FileNotFoundException e) {
			System.out.print("No File");
			System.exit(1);
		}
		bubblesort();
		for(int i=0;i<n;i++) {
			System.out.println("Name: " + names[i] + " number : " +number[i]);
		}
	}
	
	public void bubblesort() {
		for(int i= n-1; i>0;i--) {
			for(int j = 0; j<i;j++) {
				if(names[j].compareTo(names[j+1])>0) {
					
					String tmpstr = names[j];
					names[j] = names[j+1];
					names[j+1] = tmpstr;
					
					int tmp = number[j];
					number[j] = number[j+1];
					number[j+1] = tmp;
					
				}
			}
		}
	}

}


