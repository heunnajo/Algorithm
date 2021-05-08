import java.util.*;
public class PinaryNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] d = new long[n+1];
		d[1] = 1;
		if(n >= 2) d[2] = 1;//n=2 d[2]=1, n=3 d[2]=1, n=4 d[2]=2,n=5 d[2] = 1 
		for(int i=3;i<=n;i++) {
			d[i] = d[i-1] + d[i-2];//d[3]=d[2]+d[1],d[4]=d[3]+d[2],d[5]=d[4]+d[3]
		}
		System.out.println(d[n]);
	}

}
