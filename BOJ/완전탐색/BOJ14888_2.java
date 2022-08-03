package PushOperator;

import java.io.*;
import java.util.StringTokenizer;

// 연산자 끼워넣기
// https://www.acmicpc.net/problem/14888
public class BOJ14888_2 {
    static StringBuilder sb = new StringBuilder();

    static int N,max,min;
    static int[] nums,operators,order;

    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        nums = new int[N+1];
        operators = new int[5];
        order = new int[N];

        for(int i=1;i<=N;i++){
            nums[i] = scan.nextInt();
        };

        for(int i=1;i<=4;i++){
            operators[i] = scan.nextInt();
        }

        max= Integer.MIN_VALUE;
        min= Integer.MAX_VALUE;
    }

    static int calculator(int operand1,int operator,int operand2){
        if(operator == 1){
            return operand1 + operand2;
        }else if(operator == 2){
            return operand1 - operand2;
        }else if(operator == 3) {
            return operand1 * operand2;
        }else{
            return operand1 / operand2;
        }
    }

    static void rec_func(int k,int value){
        if(k == N){
            // 완성된 식에 맞게 정답을 갱신하는 작업
            max = Math.max(max,value);
            min = Math.min(min,value);
        }else{
            // 식의 순서를 완성하기 위해서 order[k]를 하나씩 채워간다.
            for(int cand =1; cand<=4;cand++){
                if(operators[cand] >=1){
                    // operators 배열에 cand번지 연산자가 존재하는지
                    operators[cand]--;
                    order[k] = cand;
                    rec_func(k+1,calculator(value,cand,nums[k+1]));
                    operators[cand]++;
                    order[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1,nums[1]);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
    }



    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException{
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

        long nextLong(){
            return Long.parseLong(next());
        }

        double nextDouble(){
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}

