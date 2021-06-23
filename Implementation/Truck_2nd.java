import java.util.*;
import java.io.*;
public class Truck_2nd {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int[] t = new int [n];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {
			t[i] = Integer.parseInt(st.nextToken());
		}
		
		//Queue<Integer> q = new LinkedList<>();
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{t[0],0});
		
		int weight = t[0];//현재 다리 위의 트럭 무게 합.
		int idx = 1,time = 1;//다음에 넣을 트럭 인덱스!
		//현재 다리 위 : _7, time = 1.
		//다리위 :7_,time=2 =>7 빼고 다음 트럭 넣는다!
		while(!q.isEmpty()) {
			//다리에서 트럭 뺄 때 : 트럭이 하나만 들어가있는 경우 큐사이즈는 w보다 작지만 다리에서 나가야한다.
			//해결방법 : 증가하는 time으로 큐 탈출조건을 걸든지, 트럭이 들어간시간 개념을 도입해서 하던지 해야한다!
			if(time-q.peek()[1] == w) {
				weight -= q.remove()[0];
			}
			if(idx<n && weight+t[idx]<=l) {//현재 트럭무게합 weight+ 다음트럭무게 <=l이면 넣는다! 
				q.add(new int[] {t[idx],time});
				weight += t[idx];
				idx++;
			}
			time++;//7은 1칸 이동한다.
		}
		System.out.println(time);
	}

}
