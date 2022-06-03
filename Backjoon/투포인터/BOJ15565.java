import java.io.*;
import java.util.StringTokenizer;

public class BOJ15565 {
    // 귀여운 라이언
    // https://www.acmicpc.net/problem/15565

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,K;
    static int[] A;
    static void input(){
        N = sc.nextInt();
        K = sc.nextInt();
        A = new int[N+1];
        for(int i=1;i<=N;i++){
            A[i] = sc.nextInt();
        }
    }

    static void pro(){
        int R = 0,cnt = 0,ans = -1;
        for(int L=1;L<=N;L++){
            if(A[L-1] == 1) cnt--;
            while(R+1<=N && cnt < K){
                R++;
                if(A[R] == 1){
                    cnt++;
                }
            }

            if(cnt >= K){
                if(ans == -1) ans = R-L+1;
                ans = Math.min(R-L+1,ans);
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
