package Section9;

import java.util.Arrays;

public class Arrays_lib5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] student = new String[] {
				"자자","침대가","널기다려","어서누워"
		};
	
		// 원하는 키워드를 검색
		String[] sortedStudents = Arrays.copyOf(student, student.length);
		Arrays.sort(sortedStudents);
		
		int idx = Arrays.binarySearch(sortedStudents, "자자");
		System.out.println(Arrays.toString(sortedStudents));
		System.out.printf("%d 번째에 %s가 위치합니다.",(idx+1), sortedStudents[idx]);
		
	}

}
