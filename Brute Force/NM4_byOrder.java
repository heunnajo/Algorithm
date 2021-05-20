import java.util.*;
public class NM4_byOrder {
	//static boolean[] c = new boolean[10];
	static int[] a = new int[10];//111 112
	static void go(int index,int start,int n,int m) {
		if(index == m) {
			for(int i=0;i<m;i++) {
				System.out.print(a[i]);
				if(i!=m-1) System.out.print(' ');
			}
			System.out.println();
			return;
		}
		for(int i=start;i<=n;i++) {//111하고 나면 돌아와서 112를 해야한다!
			a[index] = i;//
			go(index+1,i,n,m);//현재 넣은 수가 다음수 시작이 된다.
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		//순서기법.어떻게 풀었지?중복 허용,오름차순!
		go(0,1,n,m);
	}

}
