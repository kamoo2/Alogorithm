package boj.p17478;

import java.util.Scanner;

public class Main3 {
	static int N;
	static String[] MSG_ARR = { "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
			"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.", "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		chatbot(0,"");
	}
	
	static void chatbot(int k,String str) {
		// 해야할 일 
		System.out.println(str+"\"재귀함수가 뭔가요?\"");
		// 기저 조건
		if(k == N) {
			// complete code 
			System.out.println(str+"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			System.out.println(str+"라고 답변하였지.");
			return;
		}
		// 해야할 일
		for(int i=0;i<MSG_ARR.length;i++) {
			System.out.println(str+MSG_ARR[i]);	
		}
		// 재귀호출 
		chatbot(k+1,str+"____");
		// 해야할 일 
		System.out.println(str+"라고 답변하였지.");
	}
}
