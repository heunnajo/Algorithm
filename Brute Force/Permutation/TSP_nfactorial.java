import java.util.*;
public class TSP_nfactorial {
	public static boolean next_permutation(int[] a) {
		int i=a.length-1;
		while(i>0 && a[i-1]>=a[i]) {
			i--;
		}
		if(i<=0) {return false;}
		int j=a.length-1;
		while(j>=0 && a[j]<a[i-1]) {
			j--;
		}
		int tmp=a[i-1];
		a[i-1] = a[j];
		a[j] = tmp;
		j=a.length-1;
		while(i<j) {
			tmp=a[i];
			a[i]=a[j];
			a[j]=tmp;
			i++;j--;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//n=4->도시:0,1,2,3
		int[] d = new int[n];
		int[][] a = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				a[i][j] = sc.nextInt();
			}
		}
		for(int i=0;i<n;i++) {
			d[i] = i;
		}
		int ans=Integer.MAX_VALUE;
		do {
            //0123=1230=2301=3012
            //0213=2130=1302=3021
            //...
			if(d[0]!=0) break;
			int sum=0;
			boolean ok = true;
			for(int i=0;i<n-1;i++) {
				if(a[d[i]][d[i+1]]==0) {
					ok=false;
				}else {
					sum+=a[d[i]][d[i+1]];
				}
			}
			if(ok && a[d[n-1]][d[0]] != 0) {
				sum+=a[d[n-1]][d[0]];
				if(ans>sum) {ans=sum;}
			}
		}while(next_permutation(d));
		System.out.println(ans);
	}

}
