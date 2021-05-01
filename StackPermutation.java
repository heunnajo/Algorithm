package data_structures;
import java.util.*;

public class StackPermutation {

    public static void solve(int[] nums){
		int n = nums.length;
		Stack<Integer> st = new Stack<>();
		int st_num = 1;
        StringBuilder sb = new StringBuilder();//StringBuilder에 정답을 차곡차곡 넣고 마지막에 한번에 출력하면 더 효율적이다!
		for(int x : nums) {//i번째 변수를 따로 생성, 저장하지 않고  한 줄로 해결가능하다!
			if(st_num < x) {//1 < 4
                while(st_num < x+1) {
                    st.push(st_num);//1,2,3,4
                    st_num++;//st_num:2,3,4,5.
                    sb.append("+\n");
                }
                st.pop();//다 넣었으면 pop한다!  4까지 완료.
                sb.append("-\n");
            } else {//x:3, st_num:5
                if(x != st.peek()) {//st.peek()은 4.
                    System.out.println("NO");
                    return;
                }
                st.pop();//st.peek()와 x가 같은 경우!
                sb.append("-\n");
            }
		}
        System.out.println(sb);//한번에 출력할 수 있다.
        
    }
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        int[] nums = new int[n];
        for(int  i=0;i<n;i++) {
			nums[i] = sc.nextInt();
		}
        solve(nums);

	}

}
