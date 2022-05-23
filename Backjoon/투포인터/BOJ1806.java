import java.io.*;
import java.util.StringTokenizer;

public class BOJ1806 {
    // 부분합
    // https://www.acmicpc.net/problem/1806

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,S;
    static int[] A;
    static void input(){
        N = sc.nextInt();
        S = sc.nextInt();
        A = new int[N+1];
        for(int i=1;i<=N;i++){
            A[i] = sc.nextInt();
        }
    }

    static void pro(){
        // ans는 전체 길이를 넘을 수 없기 때문에 최대값은 N+1
        int R = 0, sum = 0, ans = N+1;
        for(int L = 1;L<=N;L++){
            // L을 한칸씩 이동하기 때문에 sum에서 빼준다.
            sum-= A[L-1];

            // R++를 수행하기 위해서는 R + 1 <=N라는 범위를 설정해줘야한다.
            while(R + 1 <= N && sum < S){
                R++;
                sum += A[R];
            }

            if(sum >= S){
                ans = Math.min(ans,R-L+1);
            }
        }
        // ans == N+1이라는 말은 한번도 갱신이 되지 않았다는 뜻으로 S이상의 부분수열을 찾지 못했다는 의미
        // 때문에 이 경우에는 0을 출력
        if(ans == N+1) ans = 0;
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
