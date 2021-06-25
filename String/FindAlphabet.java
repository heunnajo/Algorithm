import java.util.*;
import java.io.*;
public class FindAlphabet {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] alpha_idx = new int[26];
		boolean[] check = new boolean[26];
		for(int j=0;j<26;j++) {
			alpha_idx[j] = -1;
		}
		String input = br.readLine();
		for(int  i=0;i<input.length();i++) {
			char ch = input.charAt(i);
			if(!check[ch-'a']) {//방문한적 없으면 값 업데이트.
				alpha_idx[ch-'a'] = i;
				check[ch-'a'] = true;
			}
		}
		for(int j=0;j<26;j++) {
			System.out.print(alpha_idx[j]+" ");
		}
		System.out.println();
	}

}