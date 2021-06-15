import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
public class Hide_Seek4_2nd {
	public static final int max = 1000000;
	public static int n,k;
	public static int[] time = new int[max];
	public static int[] from = new int[max];
	public static void print(int x) {
		if(x == n) {
			System.out.print(x+" ");
			return;
		}
		else {
			print(from[x]);
			System.out.print(x+" ");
		}
	}
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		time[n] = 0;//첫 시작점은 0.
		while(!q.isEmpty()) {
			int x = q.remove();
			if(0<=x-1) {
				if(time[x-1]==-1) {
					q.add(x-1);
					time[x-1] = time[x]+1;
					from[x-1] = x;
				}
			}
			if(x+1<max) {
				if(time[x+1]==-1) {
					q.add(x+1);
					time[x+1] = time[x]+1;
					from[x+1] = x;
				}
			}
			if(2*x<max) {
				if(time[2*x]==-1) {
					q.add(2*x);
					time[2*x] = time[x]+1;
					from[2*x] = x;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		n = Integer.parseInt(input[0]);
		k = Integer.parseInt(input[1]);
		for(int  i=0;i<time.length;i++) {
			time[i] = -1;
		}
		bfs();
		int ans = time[k];
		System.out.println(ans);
		print(k);
//		Stack<Integer> st = new Stack<>();//from의 크기만큼 from 배열값들 스택에 넣어야한다!
//		for(int i=k;i==n;i=from[i]) {
//			st.push(i);//from[i]를 넣는 것이기 때문에 from[10]==5==n일 때 종료. i=from[10]
//		}
//		st.push(n);
//		System.out.println(st.pop());
	}

}
