package ss;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class FindPath {
	static int N,A[][],Dist[][];
	static void floyd() {
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++) {
//				Dist[i][j] = A[i][j];
//			}
//		}
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {//존재 유무만 판단한다!
					if(Dist[i][k] == 1 &&Dist[k][j] == 1) {
						Dist[i][j] = 1;
					}
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int [N][N];
		Dist = new int[N][N];
		
		String[] input;
		for(int i=0;i<N;i++) {
			input = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				Dist[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		floyd();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(Dist[i][j]+" ");
			}
			System.out.println();
		}
		br.close();
	}

}
