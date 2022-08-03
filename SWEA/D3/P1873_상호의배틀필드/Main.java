package swea.p1873;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T, H, W, N;
	static char[] commands;
	static char[][] map;
	static String line;
	static Tank tank;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/swea/p1873/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				line = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = line.charAt(j);
					if(map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
						tank = new Tank(i,j,map[i][j]);
					}
				}
			}

			N = Integer.parseInt(br.readLine());
			commands = new char[N];
			line = br.readLine();
			commands = line.toCharArray();
			

			// 명령어 수행 로직
			for (int i = 0; i < N; i++) {
				char c = commands[i];

				switch (c) {
					case 'U':
						moveUp();
						break;
					case 'D':
						moveDown();
						break;
					case 'R':
						moveRight();
						break;
					case 'L':
						moveLeft();
						break;
					case 'S':
						shoot();
						break;
				}
			}
			
			sb.append("#").append(t).append(" ");
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static void moveUp() {
		tank.dir = '^';
		map[tank.y][tank.x] = tank.dir;
		
		if(tank.y -1 < 0 || map[tank.y-1][tank.x] != '.' )return;
		map[tank.y][tank.x] = '.';
		tank.y += -1;
		map[tank.y][tank.x] = tank.dir;
	}
	
	static void moveDown() {
		tank.dir = 'v';
		map[tank.y][tank.x] = tank.dir;
		
		if(tank.y +1 >= H || map[tank.y+1][tank.x] != '.' )return;
		map[tank.y][tank.x] = '.';
		tank.y += 1;
		map[tank.y][tank.x] = tank.dir;
	}
	
	static void moveRight() {
		tank.dir = '>';
		map[tank.y][tank.x] = tank.dir;
		
		if(tank.x +1 >= W || map[tank.y][tank.x+1] != '.' )return;
		map[tank.y][tank.x] = '.';
		tank.x += 1;
		map[tank.y][tank.x] = tank.dir;
	}
	
	static void moveLeft() {
		tank.dir = '<';
		map[tank.y][tank.x] = tank.dir;
		
		if(tank.x - 1 < 0 || map[tank.y][tank.x-1] != '.' )return;
		map[tank.y][tank.x] = '.';
		tank.x += -1;
		map[tank.y][tank.x] = tank.dir;
	}
	
	static void shoot() {
		// 바라보고 있는 방향으로 shoot 
		// 벽에 맞으면 포탄 사라지고 , 강철벽에 맞으면 유지, 벽돌 벽은 평지로 변함
		// 만약 쏜 곳이 모두 평지이면 아무일 없음 -> 포탄이 맵 밖으로 나가면 
		// 범위 -> 전차의 위치에서 바라본 방향부터 맵 범위 끝까지 
		// 아무일 없는 조건 
		// 1. 쐈는데 벽돌 벽에 맞는 경우 
		// 2. 전부 체크 했는데 벽돌이 없는 경우 -> 맵 밖으로 포탄 나가는 경우 
		// 변하는 조건 
		// 1. 벽인데 벽돌 벽이면 평지로 변경 
		
		char dir = tank.dir;
		int y = tank.y;
		int x = tank.x;
		
		// dir이 상,하를 바라보고 있다면 x고정 
		// dir이 좌,우를 바라보고 있다면 y고정 
		if(dir == 'v') {
			for(int i = y;i < H;i++) {
				if(map[i][x] == '*') {
					map[i][x] = '.';
					break;
				}else if(map[i][x] == '#')break;
			}
		}else if(dir == '^') {
			for(int i = y;i >= 0;i--) {
				if(map[i][x] == '*') {
					map[i][x] = '.';
					break;
				}else if(map[i][x] == '#')break;
			}
		}else if(dir == '>') {
			for(int i = x;i < W;i++) {
				if(map[y][i] == '*') {
					map[y][i] = '.';
					break;
				}else if(map[y][i] == '#')break;
			}
		}else if(dir == '<') {
			for(int i = x;i >= 0;i--) {
				if(map[y][i] == '*') {
					map[y][i] = '.';
					break;
				}else if(map[y][i] == '#')break;
			}
		}
	}
	
	static class Tank{
		int y;
		int x;
		char dir; 
		
		public Tank(int y,int x,char dir) {
			this.y = y;
			this.x = x;
			this.dir = dir;
		}
	}
}
