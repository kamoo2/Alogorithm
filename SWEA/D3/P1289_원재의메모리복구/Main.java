package swea.p1289;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)throws FileNotFoundException {
		System.setIn(new FileInputStream("src/swea/p1289/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// nextInt()를 하면 개행 문자는 아직 남아 있기 때문에 헛돌 수 있음  
		sc.nextLine(); // 개행문자 해소 
		
		for(int t = 1;t<=T;t++) {
			// 테케 초기화
			int count = 0;
			String str = sc.nextLine(); // 개행 문자 까지 
			// 두개의 배열 
			// inputArray , memArray 
			int len = str.length();
			int[] inputArray = new int[len];
			int[] memArray = new int[len]; // 0으로 초기화 
			
			for(int i=0;i<len;i++) {
				inputArray[i] = str.charAt(i) - '0';
			}
			
			// 두 배열은 같은 index로 이동하면서 값을 비교 
			
			for(int i = 0;i<len;i++) {
				if(memArray[i] != inputArray[i]) {
					// memArray를 해당 idx부터 끝idx까지 변경
					for(int j=i;j<len;j++) {
						memArray[j] = inputArray[i];
					}
					count++;
				}
			}
			
			System.out.println("#" + t + " " + count);
		}
	}
}
