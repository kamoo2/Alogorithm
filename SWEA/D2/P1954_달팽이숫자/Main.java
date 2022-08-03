package swea.p1954;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

// 시계방향으로 이동 
// delta를 활용
public class Main {
	static int T, N;
	static int[][] snail;
	// 시계 방향으로 이동 = delta : 순서가 있음
	// 우,하,좌,상
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/swea/p1954/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			snail = new int[N][N];

			// 시작좌표, 방향
			int y = 0;
			int x = 0;
			int dir = 0; // 시작 방향 :우 index

			int num = 1; // 시작 숫자
			// NxN 만큼 반복하면서 숫자를 저장
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					snail[y][x] = num++; // 숫자를 저장 
					
					// 이동 
					// 현재 방향으로 이동하다가 더이상 못가면 다음 방향으로 전환 
					if(dir == 0) { // 우
						if(x + dx[dir] >= N || snail[y][x+dx[dir]] != 0) {
							dir = 1;
						}
					}else if(dir == 1) { // 하
						if(y + dy[dir] >= N || snail[y+dy[dir]][x] != 0) {
							dir = 2;
						}
					}else if(dir == 2) { // 좌
						if(x + dx[dir] < 0 || snail[y][x+dx[dir]] != 0) {
							dir = 3;
						}
					}else if(dir == 3) { // 상
						if(y + dy[dir] < 0 || snail[y+dy[dir]][x] != 0) {
							dir = 0;
						}
					}
					
					// 위 조건에 해당하지 않으면 dir인 이전 dir 
					// 해당하면 dir 변경
					x = x + dx[dir];
					y = y + dy[dir];
				}
			}
			
			System.out.println("#" + t);
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					System.out.print(snail[i][j]+" ");
				}
				System.out.println();
			}

		}
	}
}
