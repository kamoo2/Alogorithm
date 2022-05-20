import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10816 {
    // 숫자카드2
    // https://www.acmicpc.net/problem/10816

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();

    static void input(){
        N = sc.nextInt();
        A = new int[N+1];
        for(int i=1;i<=N;i++){
            A[i] = sc.nextInt();
        }
    }

    static int N,M;
    static int[] A;

    static int upper_search(int[] A,int L,int R,int X){
        int res = R+1;
        while(L <= R){
            int mid = (L+R)/2;

            if(A[mid] > X){
                res = mid;
                R = mid -1;
            }else{
                L = mid +1;
            }
        }

        return res;
    }

    static int lower_search(int[] A,int L,int R,int X){
        int res = R+1;
        while(L <= R){
            int mid = (L+R)/2;

            if(A[mid] >= X){
                res = mid;
                R = mid -1;
            }else{
                L = mid +1;
            }
        }
        return res;
    }

    static void pro(){
        Arrays.sort(A,1,N+1);

        M = sc.nextInt();
        for(int i=1;i<=M;i++){
            int X = sc.nextInt();
            int upper = upper_search(A,1,N,X);
            int lower = lower_search(A,1,N,X);
            sb.append(upper-lower).append(' ');
        }

        System.out.println(sb.toString());
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
