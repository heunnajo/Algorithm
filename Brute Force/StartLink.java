import java.util.*;
public class StartLink {
	static int n;
	static int[][] a;
	static int go(int index,ArrayList<Integer> f,ArrayList<Integer> s) {
		//정답인 경우. 조건 만족 체크
		if(index == n) {
			if(f.size() != n/2) return -1;
			if(s.size() != n/2) return -1;
			int t1=0,t2=0;
			for(int i=0;i<n/2;i++) {
				for(int j=0;j<n/2;j++) {
					if(i==j)continue;
					t1 += a[f.get(i)][f.get(j)];
					t2 += a[s.get(i)][s.get(j)];
				}
			}
			int diff = Math.abs(t1-t2);
			return diff;
		}
		//다음 경우 호출
		int ans = -1;//양수 능력치 차 비교하여 최솟값을 선택하기 위해
		//1.1번팀 선택
		f.add(index);
		int x = go(index+1,f,s);
		if(ans == -1 || x != -1 && ans>x) {ans = x;}//답을 구하고 
		f.remove(f.size()-1);//다시 삭제 
		
		//2.2번팀 선택
		s.add(index);
		int y = go(index+1,f,s);
		if(ans == -1 || y!=-1 && ans>y) {ans=y;}
		s.remove(s.size()-1);
		
		return ans;
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
		ArrayList<Integer> f = new ArrayList<>();
		ArrayList<Integer> s = new ArrayList<>();
		System.out.println(go(0,f,s));//i번째 사람을 f에 넣을지 s에 넣을지 결정.
	}

}
