import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3273 {
    // 두수의 합
    // https://www.acmicpc.net/problem/3273

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,X;
    static int[] A;
    static void input(){
        N = sc.nextInt();
        A = new int[N+1];
        for(int i=1;i<=N;i++){
            A[i] = sc.nextInt();
        }
        X = sc.nextInt();
    }

    static void pro(){
        Arrays.sort(A,1,N+1);
        int L = 1,R = N,ans =0,sum =0;

        while(L < R){
            sum = A[L] + A[R];
            if(sum >= X) R--;
            else L++;

            if(sum == X)ans++;
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
