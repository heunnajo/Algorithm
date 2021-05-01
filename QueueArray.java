package data_structures;
import java.util.*;

//1차원 배열로 큐 생성,메섣드 구현해보자!
public class Queue2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();//개행문자 제거하는 목적!
		int[] queue = new int[n];//정적  자료구조 배열 크기 어떻게 잡아야 하나!
		int begin = 0, end = 0;
		
		while(n-- >0) {
			//명령어  입력받는따!
			
			String line = sc.nextLine();
			String[] str = line.split(" ");//공백문자로 구분한다.
			String cmd = str[0];
			if(cmd.equals("push")) {
				int num = Integer.parseInt(str[1]);
				queue[end] = num;
				end++;
			} else if(cmd.equals("pop")) {
				if(begin == end) System.out.println("-1");
				else {
					System.out.println(queue[begin]);
					queue[begin] = 0;
					begin++;
				}
			} else if(cmd.equals("size")) {
				System.out.println(end-begin);
			} else if(cmd.equals("empty")) {
				if(begin == end) System.out.println("1");
				else System.out.println("0");
			} else if(cmd.equals("front")) {
				System.out.println(queue[begin]);
			} else if(cmd.equals("back")) {
				System.out.println(queue[end-1]);
			}
		}
	
		
	}

}
