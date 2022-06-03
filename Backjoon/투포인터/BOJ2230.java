import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2230 {
    // 수 고르기
    // https://www.acmicpc.net/problem/2230

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
        Arrays.sort(A,1,N+1);
        int R = 1,ans =Integer.MAX_VALUE;
        for(int L = 1;L<=N;L++){
            while(R+1 <= N && A[R]-A[L] < M){
                R++;
            }
            if(A[R] - A[L] >= M)ans = Math.min(ans,A[R]-A[L]);
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
