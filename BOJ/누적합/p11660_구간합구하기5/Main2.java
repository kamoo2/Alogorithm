package boj.p11660;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	static int N,M;
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
			// 행별 누적 계산 
			for(int j=1;j<=N;j++) {
				accu[i][j] = accu[i][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			
			// x가 행 
			int sum = 0;
			for(int y = y1; y<= y2; y++) { // 행별로 내려가면서 
				sum += accu[y][x2] - accu[y][x1-1];
			}
			
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
}
