package boj.p11659;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	static int N,M,ans;
	static int[] accu; // memoi <= 이전 수부터의 합을 미리 계산 
	// 0 1 2 3  4  5
	// 0 1 3 6 10 15 <= accu
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		accu = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			accu[i] = Integer.parseInt(st.nextToken()) + accu[i-1];
		}
		
		// M개의 구간합 
		for(int i=0;i<M;i++) {
			ans = 0;
			// 두개 
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			ans += accu[to] - accu[from-1];
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
