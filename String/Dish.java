import java.util.*;
import java.io.*;
public class Dish {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("");
		int n = input.length;
		
		
		int[] sum = new int[n];
		sum[0] = 10;
		for(int i=0;i<n-1;i++) {//i,i+1비교해서 같으면 i+1높이는 5, 다르면 10
			if(input[i].equals(input[i+1])) {
				sum[i+1] = 5;
			} else sum[i+1] = 10;
		}
		if(input[n-2].equals(input[n-1])) {
			sum[n-1] = 5;
		} else {
			sum[n-1] = 10;
		}
		int ans = 0;
		for(int i=0;i<n;i++) {
			ans+=sum[i];
		}
		System.out.println(ans);
	}

}