import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class SecurityGuard {
	static int r,c;
	static class SG2{
		int x,y,dir;
		SG2(int dir,int dist){
			if(dir==1) {//북.
				this.x = dist;
				this.y = 0;
			} else if(dir==2) {//남.
				this.x = dist;
				this.y = c;
			} else if(dir==3) {//서.
				this.x = 0;
				this.y = dist;
			} else {//동.
				this.x = r;
				this.y = dist;
			}
			this.dir = dir;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		 r =Integer.parseInt(input[0]);
		 c =Integer.parseInt(input[1]);
		int[][] map = new int[r][c];
		ArrayList<SG2> Stores = new ArrayList<>();//상점 저장.
		int ans=0;
		//상점 수 n.
		int n = Integer.parseInt(br.readLine());
		//상점 수만큼 위치 정보 받는다.
		while(n-- >0) {
			input = br.readLine().split(" ");
			int dir =Integer.parseInt(input[0]);//동:4 서:3 남:2 북:1 
			int dist =Integer.parseInt(input[1]);
			SG2 store = new SG2(dir,dist);
			Stores.add(store);
		}
		input = br.readLine().split(" ");
		int dongdir = Integer.parseInt(input[0]);
		int dongdist = Integer.parseInt(input[1]);
		SG2 dong = new SG2(dongdir,dongdist);
		
		int temp=0;//방향 반전시켜서 마주보는 변 판별 용이.
		if(dongdir==1) {temp = 2;}
		else if(dongdir==2) {temp = 1;}
		else if(dongdir==3) {temp = 4;}
		else {temp = 3;}
		
		//본격적으로 2가지 경우 거리 계산!
		for(SG2 cur : Stores) {
			if(cur.dir == temp) {//마주보는 변인 경우!
				if(cur.dir == 1 || cur.dir == 2) {//남 북.
					ans+=Math.min(dong.x+cur.x+c, r-dong.x+r-cur.x+c);
				} else {//동 서.
					ans+=Math.min(dong.y+cur.y+r, c-dong.y+c-cur.y+r);
				}
			} else {//인접한 변인 경우!
				ans += Math.abs(cur.x-dong.x) + Math.abs(cur.y-dong.y);
			}
		}
		System.out.println(ans);
	}

}
