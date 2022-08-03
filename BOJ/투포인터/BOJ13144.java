import java.io.*;
import java.util.StringTokenizer;

public class BOJ13144 {
    // List of Unique Numbers
    // https://www.acmicpc.net/problem/13144

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N;
    static int[] A,count;

    static void input(){
        N = sc.nextInt();
        A = new int[N+1];
        for(int i=1;i<=N;i++){
            A[i] = sc.nextInt();
        }
        count = new int[100000+1];
    }

    static void pro(){
        // count라는 배열 생성
        long ans = 0;
        int R = 0;

        for(int L = 1;L<=N;L++){
            while(R + 1 <= N && count[A[R+1]] == 0){
                R++;
                count[A[R]]++;
            }
            // 정답 갱신
            ans += R-L+1;

            // L이 옮겨 질테니 count 배열 수정
            count[A[L]]--;
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
