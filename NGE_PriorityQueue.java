package data_structures;
import java.util.*;
public class NGE {

	static int[] solve(int[] nums) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comp);
		int n = nums.length;
		int[] NGE = new int[n];//정답 담는 그릇!
		
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if(nums[i] < nums[j]) {
					pq.offer(j);//nums[i]보다 오른쪽에 있고, 큰 수중 index 작은 것부터 오름차순 정렬
				}
			}
			if(pq.isEmpty()) NGE[i] = -1;
			else {NGE[i] = nums[pq.poll()];}
			NGE[n-1] = -1;
		}
		return NGE;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		//1.수열 입력받는다.
		for(int i=0;i<n;i++) {
			nums[i] = sc.nextInt();
		}
		//2.solve함수 구현
		int[] ans = solve(nums);
		//3.결과 출력
		for(int  i=0;i<ans.length;i++) {
			System.out.print(ans[i]+" ");
		}
		
	}
	static Comparator<Integer> Comp = new Comparator<Integer>() {
		@Override
		public int compare(Integer a, Integer b) {
			return a-b;//오름차순 정렬.
		}
	};

}