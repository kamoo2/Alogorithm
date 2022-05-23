import java.io.*;
import java.util.StringTokenizer;

public class BOJ2512 {
    // 예산
    // https://www.acmicpc.net/problem/2512

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,M; // N : 지방의 수 , M : 총 예산
    static int[] A; // 각 지방의 요구 예산

    static boolean determination(int Limit){
        int sum = 0;
        for(int i=1;i<=N;i++){
            if(Limit <= A[i]) sum += Limit;
            else sum += A[i];
        }

        return sum <= M;
    }

    static void pro(){
        int L = 1,R = 0,ans=0;
        for(int i=1;i<=N;i++) R = Math.max(R,A[i]);
        while(L<=R){
            int mid = (L+R)/2;
            if(determination(mid)){
                // true이면 각 지방에 돌릴 예산 충분한 것이므로 상한가를 더 올려도 될 듯 하다
                // 따라서 L = mid +1
                ans = mid;
                L = mid+1;
            }else{
                R = mid -1;
            }
        }

        System.out.println(ans);
    }
    static void input(){
        N = sc.nextInt();
        A = new int[N+1];
        for(int i=1;i<=N;i++){
            A[i] = sc.nextInt();
        }
        M = sc.nextInt();
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

