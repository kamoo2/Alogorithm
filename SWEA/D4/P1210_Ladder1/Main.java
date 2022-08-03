package swea.p1210;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static FastReader sc = new FastReader("src/swea/p1210/input.txt");
	static StringBuilder sb = new StringBuilder();
	static int T, endY, endX;
	static final int SIZE = 100;
	static int[][] dir = { { 0, -1 }, { 0, 1 } }; // 좌,우
	static int[][] map;

	static void input() {
		T = sc.nextInt();
		map = new int[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				map[i][j] = sc.nextInt();
			}
		}
	}

	static void pro() {
		for (int i = 0; i < SIZE; i++) {
			if (map[99][i] == 2) {
				endX = i;
				endY = 99;
			}
		}
		
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			input();
			pro();
		}
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public FastReader(String s) {
			try {
				br = new BufferedReader(new FileReader(new File(s)));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		String next() {
			if (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		Integer nextInt() {
			return Integer.parseInt(next());
		}
	}
}
