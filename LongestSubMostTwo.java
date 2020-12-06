package java_basic;
import java.util.*;

public class LongestSubMostTwo {

	public static void main(String[] args) {
		String s = "ccaabbb";
		System.out.println(solve(s));
	}

	private static int solve(String s) {
		//1. 그릇 생성 
		Map<Character, Integer> map = new HashMap<>();//(c,2) (a,2) (b,3)
		int start = 0, end = 0, count = 0, leng = 0;
		
		//2. 반복문 돌린다.
		while(end < s.length()) {
			char c = s.charAt(end);
			map.put(c, map.getOrDefault(c, 0)+1);//(c,2) (a,2)
			if(map.get(c) == 1) count++;//new char, count는 2가 된다. 
			end++;
			
			while(count > 2) {//문자 갯수가 2보다 많으면! 
				char tmp = s.charAt(start);
				map.put(tmp,map.get(tmp)-1);
				if(map.get(tmp) == 0) { 
					count--;
				}
				start++;
			}
			//3. leng 리턴
			leng = Math.max(leng, end-start);
		}
		return leng;
		
	}

}
