import java.io.*;
import java.util.StringTokenizer;

public class BOJ2231 {
    // 분해합
    // https://www.acmicpc.net/problem/2231

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();

    static int N,ans;
    static int[] selected;
    static void input(){
        N = sc.nextInt();
    }

    static void pro(){
        for(int i=1;i<N;i++){
            int sum = 0;
            int number = i;
            sum += number;
            while(number != 0){
                sum += number % 10; // 각 자리수 더하기
                number /= 10;
            }

            if(sum == N){
                ans = i;
                break;
            }
        }

        System.out.println(ans);
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
