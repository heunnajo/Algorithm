import java.util.*;
public class TSP_nxnfactorial {
	public static boolean next_permutation(int[] a) {
		int i=a.length-1;//끝에서부터 시작!a[i-1]<a[i]인 i를 끝에서부터 찾는다!
		while(i>0 && a[i-1]>=a[i]) {
			i--;
		}
		if(i<=0) {return false;}//54321이면 마지막 순열이므로 다음 순열은 존재하지 않는다!
		int j=a.length-1;//i-1과 바꿀 j를 찾는다!
		while(j>=0 && a[j]<a[i-1]) {
			j--;
		}
		//a[i-1] <=> a[j] swap
		int tmp=a[i-1];
		a[i-1] = a[j];
		a[j] = tmp;
		
		//swap한 후 재정렬.
		j=a.length-1;//i,j가 같으면 안바꿔도 되지만
		while(i<j) {//현재 i<j인 상황.i++,j-- => j<i 가 되면 종료!
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
			int sum=0;
			boolean ok = true;
			for(int i=0;i<n-1;i++) {//비용 계산!
				if(a[d[i]][d[i+1]]==0) {
					ok=false;
				}else {
					sum+=a[d[i]][d[i+1]];
				}
			}
			if(ok && a[d[n-1]][d[0]] != 0) {
				sum+=a[d[n-1]][d[0]];
				//System.out.println("sum: "+sum);
				if(ans>sum) {ans=sum;}
			}
		}while(next_permutation(d));
		System.out.println(ans);
	}

}
