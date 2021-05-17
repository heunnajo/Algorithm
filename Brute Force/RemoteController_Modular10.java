import java.util.*;
public class RemoteController_Modular10 {
	static boolean[] broken = new boolean[10];
	static int possible(int c) {
		if(c == 0) {
			if(broken[0]) {return 0;}
			else {return 1;}
		}
		int len = 0;
		while(c > 0) {
			if(broken[c%10]) {return 0;}
			len += 1;
			c /= 10;
		}
		return len;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ch = sc.nextInt();//이동해야하는 채널번호
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			int x = sc.nextInt(); broken[x] = true;
		}
		//100에서 시작하기 때문에 -100을 해준다!
		int ans = ch - 100;//ch=101->ans=101-100=1,ch=5457->ans=5457-100=5357
		if(ans < 0) {ans = -ans;}
		for(int i=0;i<=1000000;i++) {//처음에 누를 숫자i
			int c = i;
			int len = possible(c);//4
			if(len > 0) {
				int press = ch-c;
				if(press < 0) {press = -press;}//2
				if(ans > len + press) {
					ans = len + press;
				}
			}
		}
		System.out.println(ans);
	}

}
