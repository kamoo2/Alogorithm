import java.io.*;
import java.util.StringTokenizer;

public class BOJ6236 {
    // 용돈 관리
    // https://www.acmicpc.net/problem/6236

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,M;
    static int A[];

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N+1];
        for(int i=1;i<=N;i++){
            A[i] = sc.nextInt();
        }
    }
    static boolean determination(int K){
        // 무조건 한번은 인출해야하니 cnt = 1
        int cnt = 1,sum = 0,mine = K;
        for(int i=1;i<=N;i++){
            if(mine - A[i] < 0){
                cnt++;
                mine = K-A[i];
            }else{
                mine = mine - A[i];
            }
        }
        return cnt <= M;
    }
    static void pro(){
        int L = 0,R = 0,ans =0;
        for(int i=1;i<=N;i++) L = Math.max(L,A[i]);
        for(int i=1;i<=N;i++) R = Math.max(R,R+=A[i]);

        while(L<=R){
            int mid = (L+R)/2;

            if(determination(mid)){
                // yes인 것중 최소 값을 찾아야 함
                ans = mid;
                R = mid -1;
            }else{
                L = mid +1;
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
