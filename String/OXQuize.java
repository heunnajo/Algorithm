import java.util.*;
import java.io.*;
public class OXQuize {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(t-- >0) {
			char[]  input = (br.readLine()).toCharArray();
			int sum = 0,ans = 0;
			for(int i=0;i<input.length;i++) {
				if(input[i]=='O') sum+=1;
				else sum = 0;
				ans += sum;
			}
			sb.append(ans+"\n");
		}
		System.out.print(sb);
	}

}
