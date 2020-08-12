package Section9;

import java.util.Arrays;

public class Arrays_lib3 {

	public static void main(String[] args) {
		String[] han1 = new String[]
				{"라면","잠온다","개피곤","자고싶다"};
		
		String[] han2 = Arrays.copyOf(han1, han1.length-1);
		String[] han3 = Arrays.copyOf(han1, han1.length-2);
		String[] han4 = Arrays.copyOf(han3, han3.length-1);
		
		System.out.println(Arrays.toString(han1));
		System.out.println(Arrays.toString(han2));
		System.out.println(Arrays.toString(han3));
		System.out.println(Arrays.toString(han4));
		System.out.println("첫 번째와 마지막 요소를 제거하고 복사하여 출력 ==");
		String[] cp = Arrays.copyOfRange(han1, 1, han1.length-1);
		System.out.println(Arrays.toString(cp));
		
	}

}
