package data_structures;
import java.util.*;

public class HidenSeek_GCD {
    /*
    알고리즘
    동생의 수가 N으로 많으면 생각하기 힘드니까 아래와 같이 생각하고 확장해나간다!
    수빈의 위치를 X라고 하고 X에서 Y, Z로 이동한다고 할 때(X<Y, X<Z)
    Y-X는 D의 배수여야하고, Z-X도 D의 배수여야한다.
    =>D는 Y-X, Z-X의 공통되는 약수여야한다.
    이 중 최댓값을 구하는 것이기 때문에 결국 |X-A1|,|X-A1|,..|X-An|의 GCD를 묻는 문제이다!!!
    n개의 GCD는 어떻게 구할까? 2개씩 gcd를 구하면 된다!
    ans = a[i];
    for(int i=1;i<n;i++){
        ans = gcd(ans,a[i])
    }
    */
	public static int GCD(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return GCD(y, x%y);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] nums = new int[N];
		int S = sc.nextInt();
		for(int i=0;i<N;i++) {
			int x = sc.nextInt();
			int diff = Math.abs(S-x);
			nums[i] = diff;
		}
		int ans = nums[0];
		for(int i=1;i<N;i++) {
			ans = GCD(ans,nums[i]);
		}
		System.out.println(ans);
	}

}
