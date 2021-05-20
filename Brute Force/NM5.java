import java.util.*;
public class NM5 {
	static int[] a = new int[10];
	static boolean[] c = new boolean[10];//중복 체크
 	static void go(int[] num,int index,int n,int m) {
 		if(index == m) {
			for(int i=0;i<m;i++) {
				System.out.print(a[i]);
				if(i!=m-1) System.out.print(' ');
			}
			System.out.println();
			return;
		}
		for(int i=0;i<n;i++) {
			if(c[i]) continue;
			c[i] = true;a[index] = num[i];
			go(num,index+1,n,m);
			c[i] = false;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] num = new int[n];
		for(int i=0;i<n;i++) {
			num[i] = sc.nextInt();
		}
		Arrays.sort(num);
		go(num,0,n,m);
	}

}
