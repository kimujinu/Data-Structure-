package Section0;

import java.util.Scanner;

public class Data_Structure_assignment { //201730198 김진우
	Scanner scan = new Scanner(System.in);
	int[] xa = {2,4,6,8,10};
	String str = "Data structure !!";
	
	
	public static void main(String[] args) {
		Data_Structure_assignment Main = new Data_Structure_assignment();
		Main.start();
	}
	public void start() {
		solve();
		}
	public void solve() {
		print();
		reverse();
		insert();
		delete();
		
	}
	public void insert() { 
		int[] as = new int[7];
		int[] array2 = {10,20,40,50,60,70};
		int insertnumber = scan.nextInt();
		for(int i=0;i<array2.length;i++) {
			as[i] = array2[i];
		}
		 for(int i=as.length-1;i>=1;i--) {
		     as[i] = as[i-1];
		     if(as[i]<insertnumber) {
		    	 as[i] = insertnumber;
		    	 break;
		     }
		 }
		for(int i=0;i<as.length;i++) {
			System.out.print(as[i]+" ");
		}
		System.out.println();
	}
	public void delete() {
		int[] array = {10,20,30,40,50,60,70};
		
		int len = array.length;
		int deletenumber = scan.nextInt();
		for(int i=0;i<array.length;i++) {
			if(array[i]==deletenumber) {
				for(int j = i;j<array.length-1;j++) {
					array[j] = array[j+1];
				}
				array[len-1]=0;
				break;
			}
		}
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	public void print() {
		System.out.println("xa배열 주소값 : "+xa.toString());
		for(int i=0;i<xa.length;i++) {
			System.out.print(xa[i]+" ");
		}
		System.out.println();
	}
	public void reverse() {
		for(int i=str.length()-1;i>=0;i--) {
			System.out.print(str.charAt(i));
		}
		System.out.println();
	}
	
}
