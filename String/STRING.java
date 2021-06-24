import java.util.*;
import java.io.*;
public class STRING {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t  = Integer.parseInt(br.readLine());
		while(t-->0) {
			char[] input = br.readLine().toCharArray();
			System.out.printf("%c%c",input[0],input[input.length-1]);
			System.out.println();
		}
	}

}
