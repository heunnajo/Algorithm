import java.util.*;
public class Soda {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int e = sc.nextInt();
		int f = sc.nextInt();
		int c = sc.nextInt();
		int newDrink=0, another=0,ans=0;
		int emptyCnt = e+f;
		newDrink = emptyCnt/c;
		another = emptyCnt%c;
		ans = newDrink;
		while(newDrink+another>=c) {
			emptyCnt = newDrink+another;
			newDrink = emptyCnt/c;
			another = emptyCnt%c;
			ans += newDrink;
		}
		System.out.println(ans);
	}

}
