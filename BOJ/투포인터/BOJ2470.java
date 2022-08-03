import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {
    // 두용액
    // https://www.acmicpc.net/problem/2470

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N;
    static int[] A;
    static void input(){
        N = sc.nextInt();
        A = new int[N+1];
        for(int i=1;i<=N;i++){
            A[i] = sc.nextInt();
        }
    }

    static void pro(){
        Arrays.sort(A,1,N+1);
        // L : 최소값 R : 최대값
        int L = 1,R = N,v1=0,v2=0;
        int bestSum = Integer.MAX_VALUE;
        // L = R 이면 용액이 하나 남은 것으로 비교할 수 없으므로 종료
        while(L < R){
            int sum = A[L] + A[R];
            if(Math.abs(sum) < bestSum){
                bestSum = Math.abs(sum);
                v1 = A[L];
                v2 = A[R];
            }

            if(sum < 0) L++;
            else R--;
        }

        sb.append(v1).append(' ').append(v2);
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
