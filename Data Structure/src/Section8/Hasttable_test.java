package Section8;

public class Hasttable_test {

	public static void main(String[] args) {
		Hash_table hs = new Hash_table(3);
		hs.put("자누", "멋있어");
		hs.put("진우", "존잘");
		hs.put("잔우", "잘한다.");
		
		
		System.out.println(hs.get("자누"));
		System.out.println(hs.get("진우"));
		System.out.println(hs.get("잔우"));
	}

}
