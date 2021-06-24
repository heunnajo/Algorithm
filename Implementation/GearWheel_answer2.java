import java.io.*;
import java.util.*;
public class GearWheel_answer2 {
	static int[][] gears;
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        gears = new int[4][8];
        for(int i=0;i<4;i++) {
        	String gear = br.readLine();
        	for(int j=0;j<8;j++) {
            	gears[i][j] = gear.charAt(j)-'0';
            }
        }
        
        int k = Integer.parseInt(br.readLine());
        for(int i=0;i<k;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine()," ");
        	
        	int s = Integer.parseInt(st.nextToken())-1;
        	int turn = Integer.parseInt(st.nextToken());
        	
        	func(s,turn,0);
        }
        
        int ans = 0;
        if(gears[0][0]==1) ans+=1;
        if(gears[1][0]==1) ans+=2;
        if(gears[2][0]==1) ans+=4;
        if(gears[3][0]==1) ans+=8;
        System.out.println(ans);
	}
	static void func(int idx,int turn,int d) {
		if(d==0) {
			if(idx-1>=0 && gears[idx][6] != gears[idx-1][2]) {
				func(idx-1,-turn,1);
			}
			if(idx+1<4 && gears[idx][2] != gears[idx+1][6]) {
				func(idx+1,-turn,2);
			}
		}
		else if(d==1) {
			if(idx-1>=0 && gears[idx][6] != gears[idx-1][2]) {
				func(idx-1,-turn,1);
			}
		} else if(d==2) {
			if(idx+1<4 && gears[idx][2] != gears[idx+1][6]) {
				func(idx+1,-turn,2);
			}
		}
		
		if(turn==-1) {//반시계.
			int tmp = gears[idx][0];
			for(int i=0;i<7;i++){
				gears[idx][i] = gears[idx][i+1];
			}
			gears[idx][7] = tmp;
		} else if(turn==1) {//시계방향!
			int tmp = gears[idx][7];
			for(int i=7;i>=1;i--) {
				gears[idx][i] = gears[idx][i-1];
			}
			gears[idx][0] = tmp;
		}
	}
}
