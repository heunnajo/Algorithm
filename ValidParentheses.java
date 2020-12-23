package stack;

import java.util.*;
public class ValidParentheses {
	static Map<Character,Character> map = new HashMap<>();
	static {
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String s = "([}}])";
		//String s = "([])";
		String s = "()";
		System.out.println(isValid(s));
	}
	public static boolean isValid(String s) {
		if(s.length()%2 != 0) return false;
		
		System.out.println(s);
		Stack<Character> stack = new Stack<>();
		for(int i=0; i<s.length();i++) {
			char c = s.charAt(i);
			if(map.containsKey(c)) {//stack에 닫힌 괄호를 넣는다!
				stack.push(map.get(c));
			} else if(map.containsValue(c)) {
				if(stack.isEmpty() || stack.peek() != c ) {
					return false;
				} else if(!stack.isEmpty() || stack.pop() == c) {return false;}
			}
		}
		return stack.isEmpty();
	}

}
