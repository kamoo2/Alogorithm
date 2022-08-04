package swea.p1218;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

// SWEA 1218번 괄호 짝짓기 문제 
// 10개의 테스트 케이스 
// 입력) 
// N : 테스트할 괄호의 길이 
// N개의 괄호들이 입력

public class Main {
	static int N,T,ans;
	static char[] brackets;
	static boolean validation;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/swea/p1218/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = 10;
		
		for(int t=1;t<=T;t++) {
			Stack<Character> S = new Stack<>();
			N = Integer.parseInt(br.readLine());
			brackets = new char[N];
			
			brackets = br.readLine().toCharArray();
			
			// 테스트케이스 마다 초기
			validation = true;
			
			for(int i=0;i<N;i++) {
				if(brackets[i] == '(' || brackets[i] == '{' || brackets[i] == '[' || brackets[i] == '<') {
					// 여는 괄호를 만났을 경우 Stack에 추가 
					S.add(brackets[i]);
				}else if(brackets[i] == ')' || brackets[i] == '}' || brackets[i] == ']' || brackets[i] == '>') {
					// 닫는 괄호를 만났을 경우 Stack에 pop하고 brackets[i]와 pop한 값이 같으면 유효함
					char openBracket = S.pop();
					
					if(validCheck(openBracket,brackets[i]))continue;
					else {
						validation = false;
						break;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(validation ? 1 : 0).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static boolean validCheck(char openBracket,char closeBracket) {
		switch(openBracket) {
			case '(':
				return closeBracket == ')';
			case '{':
				return closeBracket == '}';
			case '<':
				return closeBracket == '>';
			case '[':
				return closeBracket == ']';
			default:
				return false;
		}
	}
}
