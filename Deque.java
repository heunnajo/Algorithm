package data_structures;
import java.util.*;
public class Deque {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		ArrayDeque deque = new ArrayDeque<>();
		while(n-- >0) {
			String[] line = sc.nextLine().split(" ");
			String cmd = line[0];
			
			if(cmd.equals("push_front")) {
				int num = Integer.parseInt(line[1]);
				deque.offerFirst(line);
			} else if(cmd.equals("push_back")) {
				int num = Integer.parseInt(line[1]);
				deque.offerLast(line);
			} else if(cmd.equals("front")) {
				if(deque.isEmpty()) System.out.println("-1");
				else {System.out.println(deque.peekFirst());}
			} else if(cmd.equals("back")) {
				if(deque.isEmpty()) System.out.println("-1");
				else {System.out.println(deque.peekLast());}
			} else if(cmd.equals("pop_front")) {
				if(deque.isEmpty()) System.out.println("-1");
				else {System.out.println(deque.pollFirst());}
			} else if(cmd.equals("pop_back")) {
				if(deque.isEmpty()) System.out.println("-1");
				else {System.out.println(deque.pollLast());}
			} else if(cmd.equals("size")) {
				System.out.println(deque.size());
			} else if(cmd.equals("empty")) {
				if(deque.isEmpty()) System.out.println("1");
				else System.out.println("0");
			}
		}
	}

}
