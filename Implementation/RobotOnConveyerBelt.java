import java.io.*;
import java.util.StringTokenizer;

public class RobotOnConveyerBelt {
	public static int N,K;
	public static int A[] ;
	public static boolean[] robot;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	A = new int[2*N];//내구도값 저장.
    	robot = new boolean[N];//로봇의 유무? 로봇 이동 가능여부?
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i=0;i<A.length;i++) {
    		A[i] = Integer.parseInt(st.nextToken());
    	}
    	bw.write(simulation(0)+"\n");
    	
    	br.close();
    	bw.flush();
    	bw.close();
    }
    public static int simulation(int cnt) {
    	while(isOK()) {
    		int temp = A[A.length-1];//1.벨트 한칸 회전.(내구도값 이동)
    		for(int i=A.length-1;i>0;i--) {
    			A[i] = A[i-1];
    		}
    		A[0] = temp;
    		
    		for(int i=robot.length-1;i>0;i--) {//로봇도 벨트와 같이 회전.
    			robot[i] = robot[i-1];
    		}
    		robot[0] = false;
    		
    		robot[N-1] = false;
    		for(int i=N-1;i>0;i--) {//2.로봇 이동가능하면 이동.
    			if(robot[i-1] && !robot[i] && A[i]>=1) {
    				robot[i] = true;
    				robot[i-1] = false;
    				A[i]--;
    			}
    		}
    		if(A[0]>0) {
    			robot[0] = true;
    			A[0]--;
    		}
    		
    		cnt++;
    	}
    	return cnt;
    }
    public static boolean isOK() {//내구도값이 0인 칸의 갯수 센다.
    	int cnt = 0;
    	
    	for(int i=0;i<A.length;i++) {
    		if(A[i]==0) {
    			cnt++;
    		}
    		if(cnt >= K) {//내구도값이 K개이상이면 false를 리턴하여 컨베이어벨트 작동 중지!
    			return false;
    		}
    	}
    	return true;
    }
}