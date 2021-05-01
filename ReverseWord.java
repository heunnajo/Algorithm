package data_structures;
import java.util.*;
public class ReverseWord {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
        Boolean tag = false;
		Stack<Character> st = new Stack<>();
        for(char ch:s.toCharArray()){
			if(c == '<') {
				while(!s.isEmpty()) {
					System.out.println(st.pop());
                    tag = true;
                    System.out.println(c);
				}
			}
			else if(c == '>') {//공백 문자거나 줄바꿈 문자이면 
                tag = false;
                System.out.println(c);
			}else if(tag){//공백 문자/ 줄바꿈 문자 아니면 
				System.out.println(c);
			} else{
                if(c == ' ') {
                    while(!s.isEmpty()) {
					System.out.println(st.pop());
                    
                    System.out.println(c);
				} else {
			        st.push(c);
                }
                }
		
	        }
        }
        while(!s.isEmpty()) {
			System.out.println(st.pop());
            System.out.println(c;
		}
        

}
