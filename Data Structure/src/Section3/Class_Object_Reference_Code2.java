package Section3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Class_Object_Reference_Code2 {
	Person1 [] members = new Person1[100];
	int n=0;

	public static void main(String[] args) {
		Class_Object_Reference_Code2 Main = new Class_Object_Reference_Code2();
		Main.start();
	}
	
	public void start() {
		solve();
		}
		  
	public void solve() {
		try {
			Scanner scan = new Scanner(new File("input.txt"));
			while(scan.hasNext()) {
				String nm = scan.next();
				String nb = scan.next();
				members[n] = new Person1();
				members[n].name = nm;
				members[n].number = nb;
				n++;
			}
		} catch (FileNotFoundException e) {
			System.out.print("No File");
		}
		
		for(int i = 0; i<n;i++) {
			System.out.println("name is: "+ members[i].name + " number: "+members[i].number);
		}

	}

}
