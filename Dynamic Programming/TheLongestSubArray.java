import java.io.*;
import java.util.*;
public class TheLongestSubArray {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		int[] a = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
        
		int ans = -1;
		int[] d = new int[n];
        
		for(int i=0;i<n;i++) {
			d[i] = 1;
			for(int j=0;j<i;j++) {//j~i
				if(a[j]<a[i] && d[i]<d[j]+1) {
					d[i] = d[j]+1;
				}
			}
		}
        
		for(int i=0;i<n;i++) ans = Math.max(ans,d[i]);
        
		System.out.println(ans);
	}

}

//		for(int i=0;i<n;i++) {
//			System.out.print(a[i]+" ");
//		}
//		System.out.println();