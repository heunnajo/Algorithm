import java.util.*;
public class StartLink_BitMasking_BackTracking {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        //비트마스킹.모든 부분집합 다 구한다.
        int ans = -1;
        for(int i=0;i<(1<<n);i++) {
        	int cnt=0;
        	for(int j=0;j<n;j++) {//각각의 부분집합에 대해 j번째가 0의 갯수 카운팅!
        		if((i&(1<<j))==0) {cnt++;}
        	}
        	if(cnt != n/2) continue;//갯수가 조건에 부합하는 부분수열들만 f 또는 s팀에 추가해준다.
        	ArrayList<Integer> f = new ArrayList<>();
        	ArrayList<Integer> s = new ArrayList<>();
        	for(int j=0;j<n;j++) {//각각의 부분집합에 대해 j번째가 0의 갯수 카운팅!
        		if((i&(1<<j))==0) {
        			f.add(j);
        		} else {s.add(j);}
        	}
        	int t1=0,t2=0;
            for(int l1=0;l1<n/2;l1++) {
            	for (int l2=0; l2<n/2; l2++) {
                    if (l1 == l2) continue;
                    t1 += a[f.get(l1)][f.get(l2)];
                    t2 += a[s.get(l1)][s.get(l2)];
                }
            }
            int diff = Math.abs(t1-t2);
            if(ans == -1||ans>diff) {
            	ans = diff;
            }
        }
        System.out.println(ans);
	}

}
