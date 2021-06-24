import java.util.*;
import java.io.*;
public class GearWheel {
	static int[][] wheels;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		wheels = new int[4][8];
		for(int i=0;i<4;i++) {
			String[] input = br.readLine().split("");
			for(int j=0;j<8;j++) {
				wheels[i][j] = Integer.parseInt(input[j]);
			}
		}
		int k = Integer.parseInt(br.readLine());
		while(k-- >0) {//k번 회전하기 위한 톱니바퀴 인덱스, 방향 입력받는다!
			String[] input = br.readLine().split(" ");
			int idx = Integer.parseInt(input[0])-1;
			int dir = Integer.parseInt(input[1]);
			go(idx,dir,0);//재귀함수 구현.
		}
		int ans = 0;
		if(wheels[0][0] == 1) {ans+=1;}
		if(wheels[1][0] == 1) {ans+=2;}
		if(wheels[2][0] == 1) {ans+=4;}
		if(wheels[3][0] == 1) {ans+=8;}
		System.out.println(ans);
	}
	static void go(int idx,int dir,int d) {
		if(d==0) {//초기.
			//1.왼쪽톱니바퀴
			if(idx-1>=0 && wheels[idx-1][2] != wheels[idx][6]) {
				go(idx-1,-dir,1);
			}
			if(idx+1<4 && wheels[idx][2] != wheels[idx+1][6]) {
				go(idx+1,-dir,2);
			}
		}
		//왼쪽 톱니바퀴=>왼쪽 톱니바퀴의 왼쪽 톱니바퀴도 회전해야하는지 확인하고 회전해준다!
		else if(d==1) {
			if(idx-1>=0 && wheels[idx-1][2] != wheels[idx][6]) {
				go(idx-1,-dir,1);
			}
		}
		else if(d==2) {
			if(idx+1<4 && wheels[idx][2] != wheels[idx+1][6]) {
				go(idx+1,-dir,2);
			}
		}
		
		//시계방향 회전.
		if(dir == 1) {
			int tmp = wheels[idx][7];
			for(int i=7;i>=1;i--) {
				wheels[idx][i] = wheels[idx][i-1];
			}
			wheels[idx][0] = tmp;
		} else if(dir == -1) {
			int tmp = wheels[idx][0];
			for(int i=0;i<7;i++) {
				wheels[idx][i] = wheels[idx][i+1];
			}
			wheels[idx][7] = tmp;
		}
	}

}