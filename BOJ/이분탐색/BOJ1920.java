import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920 {
    // 수찾기
    // https://www.acmicpc.net/problem/1920

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

    static boolean isContain(int[] A,int L,int R,int X){
        while(L <= R){
            int mid = (L+R)/2;

            if(A[mid] == X) return true;

            if(A[mid] < X) L = mid+1;
            else R = mid-1;
        }

        return false;
    }

    static void pro(){
        Arrays.sort(A,1,N+1);

        M = sc.nextInt();
        for(int i=1;i<=M;i++){
            int num = sc.nextInt();
            if(isContain(A,1,N,num)) sb.append(1).append('\n');
            else sb.append(0).append('\n');
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
