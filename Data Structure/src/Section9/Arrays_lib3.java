package Section9;

import java.util.Arrays;

public class Arrays_lib3 {

	public static void main(String[] args) {
		String[] han1 = new String[]
				{"���","��´�","���ǰ�","�ڰ�ʹ�"};
		
		String[] han2 = Arrays.copyOf(han1, han1.length-1);
		String[] han3 = Arrays.copyOf(han1, han1.length-2);
		String[] han4 = Arrays.copyOf(han3, han3.length-1);
		
		System.out.println(Arrays.toString(han1));
		System.out.println(Arrays.toString(han2));
		System.out.println(Arrays.toString(han3));
		System.out.println(Arrays.toString(han4));
		System.out.println("ù ��°�� ������ ��Ҹ� �����ϰ� �����Ͽ� ��� ==");
		String[] cp = Arrays.copyOfRange(han1, 1, han1.length-1);
		System.out.println(Arrays.toString(cp));
		
	}

}
