package Section9;

import java.util.Arrays;

public class Arrays_lib5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] student = new String[] {
				"����","ħ�밡","�α�ٷ�","�����"
		};
	
		// ���ϴ� Ű���带 �˻�
		String[] sortedStudents = Arrays.copyOf(student, student.length);
		Arrays.sort(sortedStudents);
		
		int idx = Arrays.binarySearch(sortedStudents, "����");
		System.out.println(Arrays.toString(sortedStudents));
		System.out.printf("%d ��°�� %s�� ��ġ�մϴ�.",(idx+1), sortedStudents[idx]);
		
	}

}
