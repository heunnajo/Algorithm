package data_structures;
import java.util.*;

public class StackPermutation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		Stack<Integer> st = new Stack<>();
		
		for(int  i=0;i<n;i++) {
			nums[i] = sc.nextInt();
		}
		
		int st_num = 1;
		for(int  i=0;i<n;i++) {
			int num = nums[i];
			
			while(st_num < num+1) {
				st.push(st_num);//1,2,3,4
				st_num++;//st_num:2,3,4,5.
				System.out.println("+");
			}
			if(num != st.peek()) {//st.peek()은 4.
				System.out.println("-1");
			} else {//
				st.pop();
				System.out.println("-");
			}
		}
	}

}
