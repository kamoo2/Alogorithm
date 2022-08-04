package swea.p1218;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// Deque를 사용하여 다시 구현 
// Stack이든 Queue든 ArrayDeque를 사용하여 구현하자 
public class Main3_Dequq {
	static int N,ans;
	static Deque<Character> stack = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/swea/p1218/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		
		for(int t=1;t<=10;t++) {
			// 초기화 
			stack.clear();
			ans = 0;
			
			N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			
			// str을 순회하면서 체크 
			for(int i=0;i<N;i++) {
				char token = str.charAt(i);
				
				// 시작 문자 : (,<,{,[  
				if(token == '<' || token == '{' || token == '[' || token == '(') {
					stack.addFirst(token);	
				}else { // 닫는 문자인 경우 
					// 1. 처음부터 닫는 문자가 온 경우 
					// 2. stack이 empty인 경우 -> 짝이 맞아서 pop 됬는데 또 닫는 문자가 오면 유효하지 않음 
					if(stack.isEmpty()) {
						stack.addFirst(token);
						break;
					}
					
					// pop은 뽑아내고 stack에서 삭제하지만 peek은 값만 참조하고 제거하지 않음 
					char prev = stack.peekFirst(); 
					
					
					if(token == '>' && prev != '<')break;
					else if(token == '}' && prev != '{')break;
					else if(token == ')' && prev != '(')break;
					else if(token == ']' && prev != '[')break;
					else stack.removeFirst();
				}
				
			}
			
			// 최종적인 유효성 판단은 stack empty 해야 한다.
			if(stack.isEmpty()) {
				ans = 1;
			}else {
				ans = 0;
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb);
	}
}
