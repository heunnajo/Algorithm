package java_basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementinArray {

	public static void main(String[] args) {
		KthLargestElementinArray a = new KthLargestElementinArray();
		int[] nums = {3,2,1,5,6,4};
		int length = nums.length;
		int k =2;
		System.out.println(a.solve(nums , k));
		System.out.println(a.solve_pq(nums , k));
	}
	public int solve(int[] nums, int k) {
		int length = nums.length;
		if(length < k) return 0;
		Arrays.sort(nums);
		return nums[length-k];
	}
	public int solve_pq(int[] nums, int k) {
		//0. 담을 그릇 생성
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comp);
		int length = nums.length;
		//1. 기저 사례 제외 
		if(length < k) return 0;
		
		//put data into queue
		for(int i : nums) {
			pq.offer(nums[i]);
			if(pq.size() > k) {
				pq.poll();
			}
		}
		return pq.peek();
	}
	Comparator<Integer> Comp = new Comparator<Integer>() {

		@Override
		public int compare(Integer a, Integer b) {
			return a - b;//sort by ascending order
		}
	};

	

}
