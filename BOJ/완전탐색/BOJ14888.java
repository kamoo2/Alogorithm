import java.io.*;
import java.util.StringTokenizer;

public class BOJ14888 {
    // 연산자 끼워넣기
    // https://www.acmicpc.net/problem/14888

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();

    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] operators;
    static int[] nums,selected;
    static void input(){
        N = sc.nextInt();
        operators = new int[5];
        nums = new int[N+1];
        selected = new int[N];
        for(int i=1;i<=N;i++){
            nums[i] = sc.nextInt();
        }

        for(int i=1;i<=4;i++){
            operators[i] = sc.nextInt();
        }
    }

    static int calc(int curr,int value,int operator){
        switch(operator){
            case 1:
                return curr + value;
            case 2:
                return curr - value;
            case 3:
                return curr * value;
            case 4:
                return curr / value;
            default:
                return 0;
        }
    }

    static void rec_func(int k,int value){
        if(k == N){
            max = Math.max(max,value);
            min = Math.min(min,value);
        }else{
            // 연산자 배치 시작
            for(int i=1;i<5;i++){
                if(operators[i] == 0)continue;
                selected[k] = i;
                operators[i]--;
                rec_func(k+1,calc(value,nums[k+1],i));
                selected[k] = 0;
                operators[i]++;
            }
        }
    }

    static void pro(){
        // 재귀 함수 호출
        rec_func(1,nums[1]);
        sb.append(max).append('\n').append(min);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        pro();

    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s)throws FileNotFoundException{
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next(){
            if(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        Integer nextInt(){
            return Integer.parseInt(next());
        }

        Long nextLong(){
            return Long.parseLong(next());
        }

        Double nextDouble(){
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
