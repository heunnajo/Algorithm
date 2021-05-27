import java.util.*;
public class StartLink_BitMasking {
	static ArrayList<Integer> f = new ArrayList<>();
	static ArrayList<Integer> s = new ArrayList<>();
	static int n;
	static int a[][];
	static int gap(ArrayList<Integer> f,ArrayList<Integer> s) {
		int diff=0,t1 = 0,t2 = 0;
		for(int i=0;i<n/2;i++) {
			for(int j=0;j<n/2;j++) {
				if(i==j) continue;
				t1 += a[f.get(i)][f.get(j)];
				t2 += a[s.get(i)][s.get(j)];
			}
		}
		diff = Math.abs(t1-t2);
		return diff;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				a[i][j] = sc.nextInt();
			}
		}
		for(int i=0;i<(1<<n);i++) {//모든 부분집합 다 구한다.
			for(int j=0;j<n;j++) {//j번째가 0번팀인지 1번팀인지 검사.
				if((i&(1<<j)) != 0) {//1이라는 뜻=>1번팀에 넣고. 아니면 2번팀에 넣고.
					f.add(j);
				} else {s.add(j);}//f와 s에 j번째 사람 다 추가한다.
			}
		}
		//f와 s가 크기가 n/2이면 능력치합의 차이를 구한다!
		int ans = -1;
		if((f.size()==n/2) && (s.size()==n/2)) {
			ans = gap(f,s);//최솟값을 저장!
			System.out.println(ans);
		}
	}

}
