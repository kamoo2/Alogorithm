import java.io.*;
import java.util.StringTokenizer;

public class BOJ2003 {
    // 수들의 합2
    // https://www.acmicpc.net/problem/2003

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,M;
    static int[] A;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N+1];
        for(int i=1;i<=N;i++){
            A[i] = sc.nextInt();
        }
    }

    static void pro(){
        int R = 0,sum = 0,cnt = 0;
        for(int L=1;L<=N;L++){
            sum -= A[L-1];
            // R을 옮길 수 있을 때까지 옮기기
            while(R<N && sum < M){
                R++;
                sum += A[R];
            }

            if(sum == M){
                cnt++;
            }
        }

        System.out.println(cnt);
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
