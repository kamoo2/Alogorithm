import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3273 {
    // 두수의 합
    // https://www.acmicpc.net/problem/3273

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();

    static void input(){
        N = sc.nextInt();
        A = new int[N+1];
        for(int i=1;i<=N;i++){
            A[i] = sc.nextInt();
        }
        X = sc.nextInt();
    }

    static int N,X,L,R,ans = 0;
    static int[] A;

    static boolean bin_search(int[] A,int L,int R,int X){
        while(L<=R){
            int mid = (L+R)/2;
            if(A[mid] == X) return true;

            if(A[mid] < X){
                L = mid+1;
            }else{
                R = mid -1;
            }
        }

        return false;
    }

    static void pro(){
        // A 오름차순 정렬
        Arrays.sort(A,1,N+1);
        // 1<= i <= N-1
        for(int i=1;i<=N-1;i++){
            if(bin_search(A,i+1,N,X-A[i])) ans++;
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
