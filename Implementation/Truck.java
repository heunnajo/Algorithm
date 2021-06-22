import java.io.*;
import java.util.*;


public class Truck {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int[] truck = new int[n];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {
			truck[i] = Integer.parseInt(st.nextToken());
		}
		
		Queue<int[]> q = new LinkedList<>();
		int idx = 1;int time = 1;
		l -= truck[0];//다리(큐)에 0번째 트럭 넣고 시작!
		q.add(new int[] {truck[0],0});
		while(!q.isEmpty()) {//BFS 느낌으로(?) 구현하면 된다. 조건 검사하면서 계속해서 다음 트럭좌표 넣는다.
			if(time - q.peek()[1] == w) {//큐에서 트럭 뺄 때!시간차 비교해서 빼고, 하중은 다시 늘려준다!
				l += q.poll()[0];
			}
			if(q.size()<w && idx<n && truck[idx] <= l) {
				q.add(new int[] {truck[idx],time});
				l-=truck[idx];//방문체크 느낌~!!!!깜빡하기 쉽지만 필수적인 부분!
				idx++;//다음에 넣을 트럭 인덱스 증가.
			}
			time++;
		}
		bw.write(time+"");
		bw.flush();
		br.close();
		bw.close();
	}

}
