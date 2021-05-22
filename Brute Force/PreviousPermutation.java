import java.util.Scanner;
public class PreviousPermutation {
	public static boolean np(int[] a) {
		int i=a.length-1;
		//i를 찾는다.(바꿀 i-1을 찾는 것이다.)
		while(i>0 && a[i-1]<a[i]) {i-=1;}
		if(i<=0) {//전체 순열이 오름차순으로 되어있어 전체 순열이 마지막 순열인경우!
			return false;
		}
		//i를 찾고나서 i-1과 바꿀 j를 찾는다.
		int j=a.length-1;
		while(a[i-1]<a[j]) {j-=1;}
		int temp = a[i-1];
		a[i-1] = a[j];
		a[j] = temp;
		//i와 n-1 재정렬해서 오름차순으로 만들어준다!
		j = a.length-1;
		while(i<j) {//i==j라면 해줄필요 없음!
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i+=1;j-=1;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		if(np(a)) {
			for(int i=0;i<n;i++) {
				System.out.print(a[i]+" ");
			}
			System.out.println();
		} else {System.out.println("-1");}
	}
}
