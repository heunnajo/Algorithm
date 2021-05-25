import java.util.*;
public class SignofInequality_BF {
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
	static void go(int index,String s) {
		//정답인 경우
		if(index == n+1) {
			if(ok(s)) {//조건 만족.
				ans.add(s);//조건만족하는 s를 ans에 추가하는데 왜?!추가가 제대로 안되서 ans길이가 0인 것 같은데!
			}
			return;
		}
		//다음 경우 호출.
		for(int i=0;i<=9;i++) {
			if(check[i]) continue;
			check[i] = true;
			go(index+1,s+Integer.toString(i));//순열에 현재 index 추가! 단, 중복제외!
			check[i] = false;
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
		System.out.println(ans.get(m-1));//ans의 길이가 0이라고?
		System.out.println(ans.get(0));
	}

}
