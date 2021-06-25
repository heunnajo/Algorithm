import java.util.*;
import java.io.*;
public class CountingAlphabet {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] alpha_idx = new int[26];//인덱스가 아니라 갯수를 저장.
		
		String input = br.readLine();
		for(int  i=0;i<input.length();i++) {
			char ch = input.charAt(i);
				alpha_idx[ch-'a']++;
		}
		for(int j=0;j<26;j++) {
			System.out.print(alpha_idx[j]+" ");
		}
		System.out.println();
	}

}