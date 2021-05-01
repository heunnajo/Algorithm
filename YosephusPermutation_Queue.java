package data_structures;
import java.util.*;

public class Josephus {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> myq = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		for(int i=1;i<=m;i++) {
			myq.offer(i);
		}
		sb.append("<");
		for(int j=0;j<m-1;j++) {//마지막 원소 하나 남겨두고 이중 for문 종료 
			for(int k=0;k<n-1;k++) {
				myq.offer(myq.poll());
			}
			sb.append(myq.poll()+",");//3,6,2,7,5,1,
		}
		sb.append(myq.poll()+">\n");
        System.out.println(sb);
	}

}
