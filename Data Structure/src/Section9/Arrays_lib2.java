package Section9;

import java.util.Arrays;

public class Arrays_lib2 {

	public static void main(String[] args) {
		int[] correct = {1,2,3,4,5,6};
		
		int[][] answer = {{1,1,3,4,5,6},{1,2,3,4,5,6},{1,2,1,4,5,6},{1,2,3,1,5,6}};
		
		int no = 0;
		
		for(int[] anwsers : answer) {
			no++;
			if(Arrays.equals(correct, anwsers)) {
				System.out.printf("%d�� �л��� ������ �Դϴ�.\n", no);
			}else {
				System.out.printf("%d�� �л��� �����ڰ� �ƴմϴ�. \n", no);
			}
		}

	}

}
