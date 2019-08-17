package Section3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Class_Object_Reference_Code4 {

	Scanner scan = new Scanner(System.in);
	Item [] item = new Item[100000];
//	String[] words = new String[100000];
//	int[] count = new int[100000];
	int n = 0;
	
	public static void main(String[] args) {
		Class_Object_Reference_Code4 Main = new Class_Object_Reference_Code4();
		Main.start();
	}
	
	public void start() {
		solve();
		}
		  
	public void solve() {
		
		while(true) { //대화식 인터페이스를 가지는 프로그램을작성할때 쓰임  
			System.out.print("$: ");
			String command = scan.next();
			if(command.equals("read")) {
				String fileName = scan.next();
				makeIndex(fileName);
			}
			else if(command.equals("find")) {
				String str = scan.next();
				int index = findword(str);
				if(index > -1) {
					System.out.println("The word "+ item[index].word + " appears "+ item[index].count+ " times");
				}else {
					System.out.println("The word "+ str + " does not appear");
				}
			}
			else if(command.equals("saveas")) {
				String fileName = scan.next();
				saveas(fileName);
			}
			else if(command.equals("exit")) {
				break;
			}
		}
		scan.close();
		
	}
	public void makeIndex(String fileName) {
		try {
			Scanner inFile = new Scanner(new File(fileName));
			while(inFile.hasNext()) {
				String str = inFile.next();
				String trimmed = trimming(str);
				if(trimmed != null) {
					String t = trimmed.toLowerCase();
					addword(t);
				}
			}
			inFile.close();
		} catch (FileNotFoundException e) {
			System.out.print("No File");
			return;
		}
	}
	public void addword(String str) {
		int index = findword(str); //return -1 if not found
		if(index != -1) { //found word[index] == str
			item[index].count++;
		}else { //not found
			int i =n-1;
			while(i>=0 && item[i].word.compareToIgnoreCase(str)>0) {
				item[i+1] = item[i];
				i--;
			}
			item[i+1] = new Item();
			item[i+1].word = str;
			item[i+1].count = 1;
			n++;
		}
		
	}
	public int findword(String str) {
		for(int i = 0;i<n;i++) {
			if(item[i].word.equalsIgnoreCase(str)) {
				return i;
			}
		}
		return -1;
	}
	public void saveas(String FileName) {
		PrintWriter outFile;
		try {
			 outFile = new PrintWriter(new FileWriter(FileName));
			for(int i=0;i<n;i++) {
				outFile.println(item[i].word+" "+item[i].count);
			}
			outFile.close();
		} catch (IOException e) {
			System.out.println("Save failed");
			return;
		}
	}
	public String trimming(String str) {
		int i =0;
		int j =str.length()-1 ;
		while(i < str.length() && !Character.isLetter(str.charAt(i))) { //while i-th character is not letter
			i++;
		}
		while(j >= 0 && !Character.isLetter(str.charAt(j))) {
			j--;
		}
		if(i > j) {
			return null;
		}
		return str.substring(i,j+1);
	}
}
