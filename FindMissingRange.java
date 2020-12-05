package java_basic;

import java.util.*;
public class FindMissingRange {

	public static void main(String[] args) {
		int[] nums = {2,3,5,50,75};
		int lower=0, upper=99;
		System.out.println(solve(nums, lower, upper));
//		[0->1, 4, 6->49, 51->74, 76->99]
	}

	public static List<String> solve(int[] nums, int lower, int upper) {
		//0. 그릇 생성
		List<String> result = new ArrayList<>();
		//1. 기저사례 제외 
		if(nums == null || nums.length == 0) {
			result.add(getRange(lower,upper));
			return result;
		}
		//2. case#1 
		if(lower < nums[0]) {
			result.add(getRange(lower, nums[0]-1));
		}
		// case#2
		for(int i=0; i< nums.length;i++) {
			if(nums[i] != nums[i+1] && nums[i]+1 < nums[i+1]) {
				result.add(getRange(nums[i]+1, nums[i+1]-1));
			}
		}
		// case#3
		if(nums[nums.length-1] < upper) {
			result.add(getRange(nums[nums.length-1]+1, upper));
		}
		return result;
	}

	public static String getRange(int lower, int upper) {
		return lower == upper ? String.valueOf(lower) : (lower+"->"+upper);
	}

}
