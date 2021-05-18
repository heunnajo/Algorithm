import java.util.*;
public class SevenDwarfs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 9;
		int[] dwarf = new int[n];
		int sum = 0;
		for(int i=0;i<n;i++) {
			dwarf[i] = sc.nextInt();
			sum += dwarf[i];
		}
		Arrays.sort(dwarf);
		for(int i=0;i<n-1;i++) {
			int a = dwarf[i];
			for(int j=0;j<n;j++) {
				int b = dwarf[j];
				if(sum - a - b == 100) {
					for(int k=0;k<n;k++) {
						if(dwarf[k] == a || dwarf[k] == b) continue;
						System.out.println(dwarf[k]);//a,b를 제외하고 키들 출력!
					}
					System.exit(0);
				}
			}
		}
	}
	
}
