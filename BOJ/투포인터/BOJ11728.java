import java.io.*;
import java.util.StringTokenizer;

public class BOJ11728 {
    // 배열 합치기
    // https://www.acmicpc.net/problem/11728

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,M;
    static int[] A,B;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N+1];
        B = new int[M+1];
        for(int i=1;i<=N;i++){
            A[i] = sc.nextInt();
        }

        for(int i=1;i<=M;i++){
            B[i] = sc.nextInt();
        }
    }

    static void pro(){
        // L은 A배열을 순회
        // R은 B배열을 순회
        int L = 1,R = 1;
        while(L <= N && R <= M){
            if(A[L] <= B[R])sb.append(A[L++]).append(' ');
            else sb.append(B[R++]).append(' ');
        }

        // N < M 인경우 -> R은 끝에 다다르지 못했다.
        while(R <= M)sb.append(B[R++]).append(' ');

        // N > M 인경우 -> L은 끝에 다다르지 못했다.
        while(L <= N)sb.append(A[L++]).append(' ');

        System.out.println(sb);
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
