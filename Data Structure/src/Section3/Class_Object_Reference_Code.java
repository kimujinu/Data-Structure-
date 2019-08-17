package Section3;


public class Class_Object_Reference_Code {

	public static void main(String[] args) {
		Class_Object_Reference_Code Main = new Class_Object_Reference_Code();
		Main.start();
	}
	
	public void start() {
		solve();
		}
		  
	public void solve() {
		Person1 first = new Person1(); // Object
		first.name = "±è¤¤¤·";
		first.number = "010-1234-5678";
		
		Person1 [] members = new Person1[100];
		members[0] = first;
		members[1] = new Person1();
		members[1].name = "±è¤¸¤·";
		members[1].number = "010-1513-8846";
		
		System.out.println("First is: "+ first.name + " with number: "+ first.number);
		System.out.print("Second is: "+ members[1].name + " with number: "+ members[1].number);

	}
	
}
