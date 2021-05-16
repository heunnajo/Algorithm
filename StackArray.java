package data_structures;

import java.util.*;
import java.io.*;
public class StackArray {
	static int idx = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = Integer.parseInt(s);
		int[] st = new int[n+1];
		
		while(n-- >0) {//n개의 명령어 입력받는다.
			String str = br.readLine();
			String[] line = str.split(" ");
			String cmd = line[0];
			if(cmd.equals("push")) {
				st[idx] = Integer.parseInt(line[1]);
				//System.out.printf("st[%d] : %d",idx,st[idx]);
				//System.out.println();
				idx++;
				//System.out.printf(" 다음 idx : %d",idx);
				
			} else if(cmd.equals("pop")) {
				if(idx == 0) {
					System.out.println(-1);
				}
				else {
					//System.out.printf("st[%d] : %d",idx-1,st[idx-1]);
					System.out.println(st[idx-1]);//정답 출력 
					//System.out.println();
					st[idx-1] = -1;//pop연산을 -1값으로 초기화.
					idx--;
				}
			} else if(cmd.equals("size")) {
				System.out.println(idx);
			} else if(cmd.equals("empty")) {
				if(idx == 0) System.out.println(1);
				else System.out.println(0);
			} else if(cmd.equals("top")) {
				if(idx == 0 || st[idx-1] == -1) System.out.println(-1);
				else System.out.println(st[idx-1]);
			}
		}
	}

}
