import java.util.*;
public class SignofInequality_BackTracking {
	static int n;
	static char[] input = new char[20];
	static boolean[] check = new boolean[10];//중복 체크
	static ArrayList<String> ans = new ArrayList<String>();
	static boolean ok(String s) {
		for(int i=0;i<n;i++) {
			if(input[i] == '<') {
				if(s.charAt(i) > s.charAt(i+1)) {return false;}
			} else if(input[i] == '>') {
				if(s.charAt(i) < s.charAt(i+1)) {return false;}
			}
		}
		return true;
	}
	static boolean bt_ok(char a,char b,char op) {
		 if(op == '<') { if(a>b) return false;}
		 if(op == '>') { if(a<b) return false;}
		return true;
	}
	static void go(int index,String s) {
		if(index == n+1) {
			if(ok(s)) {
				ans.add(s);
			}
			return;
		}
		for(int i=0;i<=9;i++) {
			if(check[i]) continue;
			//백트랙킹=>현재 수 넣을 때 조건체크를하면서 넣는다!
			if(index == 0||bt_ok(s.charAt(index-1),(char)(i+'0'),input[index-1])) {
				check[i] = true;
				go(index+1,s+Integer.toString(i));
				check[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0;i<n;i++) {
			input[i] = sc.next().toCharArray()[0];
		}
		go(0,"");
		Collections.sort(ans);
		int m = ans.size();
		System.out.println(ans.get(m-1));
		System.out.println(ans.get(0));
	}

}
