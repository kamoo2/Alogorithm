package swea.p1289;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

// Scanner를 사용하니깐 개행문자 처리하는 부분이 번거롭다 , 그리고 입력이 많아졌을 때 속도가 느리다. 
// BufferedReader를 사용해보자 
// local 변수 중 주요 변수들을 static으로 변경해보자.
// int[] -> char[]
public class Main2 {
	static StringBuilder sb = new StringBuilder();
	static int T,ans;
	static char[] input,memory;
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("src/swea/p1289/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1;t<=T;t++) {
			// 테케 초기화
			ans = 0;
			
			input = br.readLine().toCharArray();
			int len = input.length;
			memory = new char[len];
			for(int i=0;i<len;i++) {
				memory[i] = '0';
			}
			
			for(int i=0;i<len;i++) {
				if(input[i] != memory[i]) {
					for(int j=i;j<len;j++) {
						memory[j] = input[i];
					}
					ans++;
				}
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb);
	}
}
