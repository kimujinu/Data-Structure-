package Section3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Class_Object_Reference_Code6 {
	
	Polynomial[] polys = new Polynomial[100];
	int n = 0;
	
	public static void main(String[] args) {
		Class_Object_Reference_Code6 Main = new Class_Object_Reference_Code6();
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
				polys[n] = new Polynomial();
				polys[n].name = name;
				polys[n].terms = new Term[100];
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
					addTerm(polys[index],c,e);
				}
				
			}else if(command.equals("clac")) {
				char name = scan.next().charAt(0);
				int index = find(name);
				if(index == -1) {
					System.out.println("No such polynomial exists");
				}
				else {
					int x = scan.nextInt();
					int result = calPolynomial(polys[index],x);
					System.out.println(result);
				}
				
			}else if(command.equals("print")) {
				char name = scan.next().charAt(0);
				int index = find(name);
				if(index == -1) {
					System.out.println("No such polynomial exists");
				}
				else {
					printPolynomial(polys[index]);
				}
				
			}else if(command.equals("exit")) {
				break;
			}
		}
		scan.close();
	}

	

	private int calPolynomial(Polynomial p, int x) {
		int result = 0;
		for(int i =0; i<p.nTerms;i++) 
			result += calcTerm(p.terms[i],x);
		
		return result;
	}

	private int calcTerm(Term term, int x) {
		return (int) (term.coef * Math.pow(x, term.expo));
	}

	private void printPolynomial(Polynomial p) {
		for(int i =0; i<p.nTerms;i++) {
			printTerm(p.terms[i]);
			System.out.print("+");
		}
		System.out.println();
		
	}

	private void printTerm(Term term) {
		System.out.print(term.coef + "x^" +term.expo);
		
	}

	private void addTerm(Polynomial p, int c, int e) {
		int index = findTerm(p,e);
		if(index != -1) {
			p.terms[index].coef += c;
			
		}else {
			int i = p.nTerms-1;
			while(i>=0 && p.terms[i].expo < e) {
				p.terms[i+1] = p.terms[i];
				i--;
			}
			p.terms[i+1] = new Term();
			p.terms[i+1].coef = c;
			p.terms[i+1].expo = e;
			p.nTerms++;
		}
	}

	private int findTerm(Polynomial p, int e) {
		for(int i=0; i<p.nTerms && p.terms[i].expo >= e; i++) {
			if(p.terms[i].expo == e)
					return i;
		}
		return -1;
	}

	private int find(char name) {
		for(int i = 0; i<n; i ++) {
			if(polys[i].name == name)
				return i;
		}
		return -1;
	}
	
	


}
