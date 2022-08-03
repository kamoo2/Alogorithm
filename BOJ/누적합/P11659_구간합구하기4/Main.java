package boj.p11659;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 구간 합 구하기 4 
// N : 숫자개수 
// M : 숫자 합 구해야 하는 개수 
public class Main {
	static int N, M, sIdx, eIdx, ans;
	static int[] A;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken()) + A[i - 1];
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			sIdx = Integer.parseInt(st.nextToken());
			eIdx = Integer.parseInt(st.nextToken());
			ans = A[eIdx] - A[sIdx - 1];
			sb.append(ans).append("\n");
		}

		System.out.println(sb);
	}

}
