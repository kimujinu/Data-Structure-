package Section3;

public class Class_Object_Reference_Code1_2 {

	public static void main(String[] args) {
		Class_Object_Reference_Code1_2 Main = new Class_Object_Reference_Code1_2();
		Main.start();
	}
	
	public void start() {
		solve();
		}
		  
	public void solve() {
		Person1 first = new Person1(); // Object
		first.name = "±è¤¤¤·";
		first.number = "010-1234-5678";
		System.out.println("First is: "+ first.name + " with number: "+ first.number);
		
		Person1 second = first;
		second.name = "Tom";
		System.out.println(first.name);
		
		Person1 [] members = new Person1[100];
		members[0] = first;
		members[1] = second;
	
		System.out.println("Second is: "+ members[0].name + " with number: "+ members[0].number);
		System.out.print("Second is: "+ members[1].name + " with number: "+ members[1].number);
		
		members[2] = new Person1();
		members[2].name = "David";
		members[2].number = "010-1231-4612";
		
		System.out.print("name is: "+ members[2].name + " with number: "+ members[2].number);


	}
	
}
