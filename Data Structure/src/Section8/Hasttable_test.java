package Section8;

public class Hasttable_test {

	public static void main(String[] args) {
		Hash_table hs = new Hash_table(3);
		hs.put("�ڴ�", "���־�");
		hs.put("����", "����");
		hs.put("�ܿ�", "���Ѵ�.");
		
		
		System.out.println(hs.get("�ڴ�"));
		System.out.println(hs.get("����"));
		System.out.println(hs.get("�ܿ�"));
	}

}
