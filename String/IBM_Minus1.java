import java.io.BufferedReader;
import java.io.InputStreamReader;
public class IBM_Minus1 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int  i=1;i<=n;i++) {
			System.out.println("String #"+i);
			String[] input = br.readLine().split("");//공백문자없이 이어쓴 각 문자열들을 문자열 배열로 저장!
			for(int j=0;j<input.length;j++) {
				char tmp = input[j].charAt(0);
				tmp += 1;
				if(tmp == 91) tmp = 65;
				System.out.print(tmp);
			}
			System.out.println();
			System.out.println();
		}
	}

}
