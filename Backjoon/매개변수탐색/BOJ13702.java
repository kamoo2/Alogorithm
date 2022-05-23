import java.io.*;
import java.util.StringTokenizer;

public class BOJ13702 {
    // 이상한 술집
    // https://www.acmicpc.net/problem/13702

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

    static boolean determination(long L){
        int cnt = 0;
        for(int i=1;i<=N;i++){
            if(A[i] >= L){
                cnt += A[i]/L;
            }else{
                continue;
            }
        }

        return cnt >= K;
    }

    static void pro() {
        long L = 0,R = Integer.MAX_VALUE,ans=0;
        while(L<=R){
            long mid = (L+R)/2;
            if(determination(mid)){
                ans= mid;
                L = mid +1;
            }else{
                R = mid -1;
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

        public FastReader(String s) throws FileNotFoundException{
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
