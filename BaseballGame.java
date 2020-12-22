package stack;

import java.util.Arrays;
import java.util.Stack;

public class BaseballGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] ops = {"5","-2","4","C","D","9","+","+"};
		System.out.println("Input :"+Arrays.toString(ops));
		System.out.println("정답:"+solve(ops));
	}

	public static int solve(String[] ops) {
		//1.자료구조 생성 
		Stack<Integer> stack = new Stack<Integer>();
		int sum = 0;
		
		//2.stack에 데이터 넣는다.
		//숫자일 때, 문자일 때 다르게 처리한다.
		for(String op : ops) {
			switch(op) {
				case "+" :
					int x = stack.pop();//System.out.println("x : "+x);
					int y = stack.pop();//System.out.println("y : "+y);System.out.println("x+y : " +(x+y));
					stack.push(y);
					stack.push(x);
					stack.push(x+y);
					break;
				case "C" :
					stack.pop();
					break;
				case "D" :
					stack.push(stack.peek()*2);
					break;
				default:
					stack.push(Integer.valueOf(op));
			}
		}
		while(!stack.isEmpty()) {

			sum += stack.pop();
		}
		return sum;
	}
}
