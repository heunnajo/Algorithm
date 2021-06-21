import java.util.*;
import java.io.*;
public class Ciphertext_2nd {
	public static int L,C;
	public static char[] input;
	public static StringBuilder sb;
	public static boolean check(String str) {
		int mo = 0, ja = 0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) =='o' || str.charAt(i) == 'u') {
				mo++;
			} else ja++;
		}
		if(mo >= 1 && ja >=2) return true;
		else return false;
	}
	public static void go(int index,int selected,String str) {
		if(index==L) {
			if(check(str)) {
				sb.append(str+"\n");
				return;
			}
		}
		if(index>L) return;
		for(int i=selected;i<C;i++) {
			go(index+1,i+1,str+input[i]);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		input = new char[C];
		String[] str = br.readLine().split(" ");
		for(int i=0;i<C;i++) {
			input[i] = str[i].charAt(0);
		}
		Arrays.sort(input);
		
		go(0,0,"");
		System.out.print(sb);
		br.close();
	}

}