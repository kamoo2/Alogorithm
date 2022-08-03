package swea.p2805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	static int N,T,blank,ans;
	static int[][] farm;
	static String line;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/swea/p2805/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			farm = new int[N][N];
			for(int i=0;i<N;i++) {
				line = br.readLine();
				for(int j=0;j<N;j++) {
					farm[i][j] = line.charAt(j)-'0';
				}
			}
			
			ans = 0;
			blank = N/2;
			int dir = 1; // 1 감소 , 0 증가
			for(int y=0;y<N;y++) {
				for(int x=blank;x<N-blank;x++) {
					ans+= farm[y][x];
				}	
				if(blank == 0) {
					dir = 0;
				}
				
				if(dir == 1) {
					blank--;
				}else if(dir == 0) {
					blank++;
				}
			}
			
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb);
		
	}
}
