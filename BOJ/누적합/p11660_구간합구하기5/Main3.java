package boj.p11660;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {
	static int N,M,ans;
	static int[][] accu; // memoi <= 이전 수부터의 합을 미리 계산, 행별로 각각 누적 계산 
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		accu = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			// 행과 열을 모두 합한 누적 계산, 현재 좌표 기준으로 원점(시작점)과의 사각형내의 모든 합 
			for(int j=1;j<=N;j++) {
				accu[i][j] = accu[i-1][j] + accu[i][j-1] - accu[i-1][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<M;i++) {
			ans = 0;
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			
			ans = accu[y2][x2] - accu[y1-1][x2] - accu[y2][x1-1] + accu[y1-1][x1-1];
			
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb);
	}
}
