package Section4;

import java.util.Scanner;

public class method_constructor {

	Polynomial2[] polys = new Polynomial2[100];
	int n = 0;
	
	public static void main(String[] args) {
		method_constructor Main = new method_constructor();
		Main.start();
	}
	
	public void start() {
		solve();
		}
		  
	public void solve() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("$:");
			String command = scan.next();
			if(command.equals("create")) {
				char name = scan.next().charAt(0);
				polys[n] = new Polynomial2();
				polys[n].name = name;
				polys[n].terms = new Term2[100];
				polys[n].nTerms = 0;
				
				n++;
			}else if(command.equals("add")) { //add f 2 3
				char name = scan.next().charAt(0);
				int index = find(name);
				if(index == -1) {
					System.out.print("No such polynomial exists");
				}else {
					int c = scan.nextInt();
					int e = scan.nextInt();
					polys[index].addTerm(c, e);
				}
				
			}else if(command.equals("clac")) {
				char name = scan.next().charAt(0);
				int index = find(name);
				if(index == -1) {
					System.out.println("No such polynomial exists");
				}
				else {
					int x = scan.nextInt();
					int result = polys[index].calPolynomial(x);
					System.out.println(result);
				}
				
			}else if(command.equals("print")) {
				char name = scan.next().charAt(0);
				int index = find(name);
				if(index == -1) {
					System.out.println("No such polynomial exists");
				}
				else {
					polys[index].printPolynomial();
				}
				
			}else if(command.equals("exit")) {
				break;
			}
		}
		scan.close();
	}



	private int find(char name) {
		for(int i = 0; i<n; i ++) {
			if(polys[i].name == name)
				return i;
		}
		return -1;
	}
	
}
