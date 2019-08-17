package Section3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Class_Object_Reference_Code3 {
	Person1 [] members = new Person1[100];
	int n=0;

	public static void main(String[] args) {
		Class_Object_Reference_Code3 Main = new Class_Object_Reference_Code3();
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
			System.exit(1);
		}
		
		bubblesort();
		
		for(int i = 0; i<n;i++) {
			System.out.println("name is: "+ members[i].name + " number: "+members[i].number);
		}

	}

	public void bubblesort() {
		for(int i= n-1; i>0;i--) {
			for(int j = 0; j<i;j++) {
				if(members[j].name.compareToIgnoreCase(members[j+1].name)>0) {
					
					Person1 tmp = members[j];
					members[j] = members[j+1];
					members[j+1] = tmp;
				}
			}
		}
	}
	  

}
