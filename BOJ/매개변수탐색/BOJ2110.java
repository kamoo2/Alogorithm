import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {
    // 공유기 설치
    // https://www.acmicpc.net/problem/2110

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,C;
    static int[] A;
    static void input(){
        N = sc.nextInt();
        C = sc.nextInt();
        A = new int[N+1];
        for(int i=1;i<=N;i++){
            A[i] = sc.nextInt();
        }
    }

    static boolean determination(int D){
        int cnt = 1,last = A[1];
        for(int i=2;i<=N;i++){
            if(A[i] - last >= D){
                cnt++;
                last = A[i];
            }
        }

        return cnt >= C;
    }

    static void pro(){
        Arrays.sort(A,1,N+1);
        int L = 1,R = A[N],ans = 0;
        while(L <= R){
            int mid = (L+R)/2;
            if(determination(mid)){
                ans = mid;
                L = mid +1;
            }else{
                R = mid-1;
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
