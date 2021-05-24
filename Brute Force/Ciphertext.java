import java.util.*;
public class Ciphertext {
	static int l;
	static int c;
	static String[] s;
	public static boolean check(String pw) {
		int mo=0;
		int ja=0;
		for(char c : pw.toCharArray()) {
			if(c == 'a'|| c == 'e' || c=='i'||c=='o'||c=='u') {
				mo++;
			} else {
				ja++;
			}
		}
		if(mo>=1 && ja>=2) return true;
		else return false;
	}
	public static void go(String pw,int i) {
		if(pw.length() == l) {
			if(check(pw)) {
				System.out.println(pw);
			}
			return;
		}
		if(s.length <= i) return;
		go(pw+s[i],i+1);
		go(pw,i+1);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		l = sc.nextInt();
		c = sc.nextInt();
		
		s = new String[c];
		for(int i=0;i<c;i++) {
			s[i] = sc.next();
		}
		Arrays.sort(s);
		go("",0);
	}

}