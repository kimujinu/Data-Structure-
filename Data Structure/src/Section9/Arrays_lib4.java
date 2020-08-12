package Section9;

import java.util.Arrays;

public class Arrays_lib4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] han1 = new String[] 
				{"피곤","잠","쿨쿨..","자자","Zzz.."};
		System.out.println("정렬전 : "+Arrays.toString(han1));
		
		
		String[] han2 = Arrays.copyOf(han1, han1.length);
		String[] han3 = Arrays.copyOf(han1, han1.length);
		
		Arrays.sort(han2);
		Arrays.sort(han3,2,5);
		
		System.out.println("전체 정렬후 : "+ Arrays.toString(han2));
		System.out.println("범위 정렬후 : "+ Arrays.toString(han3));
	}

}
