package swea.p1208;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static FastReader sc = new FastReader("src/swea/p1208/input.txt");
	static StringBuilder sb = new StringBuilder();
	static int T = 10,N,ans,max,min,maxIdx,minIdx;
	static int[] S;
	static final int SIZE = 100;
	
	static void input() {
		N = sc.nextInt();
		S = new int[SIZE];
		for(int i=0;i<SIZE;i++) {
			S[i] = sc.nextInt();
		}
	}
	
	static void recursive(int k) {
		if(k == N+1) {
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			for(int i=0;i<SIZE;i++) {
				max = Math.max(max, S[i]);
				min = Math.min(min, S[i]);
			}
			ans = max - min;
			return;
		}else {
			// 덤프 1회 실시 
			maxIdx = 0;
			minIdx = 0;
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			for(int i=0;i<SIZE;i++) {
				if(max < S[i]) {
					max = S[i];
					maxIdx = i;
				}
				if(min > S[i]) {
					min = S[i];
					minIdx = i;
				}
			}
			S[maxIdx]--;
			S[minIdx]++;
			recursive(k+1);
		}
	}
	
	static void pro(int t) {
		// 초기화 
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		ans = 0;
		
		// recursive function 
		recursive(1);
		
		sb.append("#").append(t).append(" ").append(ans).append("\n");
	}
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		for(int i=1;i<=T;i++) {
			input();
			pro(i);
		}
		long end = System.nanoTime();
		System.out.println(sb);
		System.out.println("duration : " + (end-start));
	}
	
	static class FastReader{
		StringTokenizer st;
		BufferedReader br;
		
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public FastReader(String s) {
			try {
				br = new BufferedReader(new FileReader(new File(s)));
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		String next() {
			if(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				}catch(IOException e) {
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
