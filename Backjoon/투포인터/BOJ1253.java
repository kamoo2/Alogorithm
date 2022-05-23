import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1253 {
    // 좋다
    // https://www.acmicpc.net/problem /1253

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

    static boolean isGood(int target_idx){
        // target 원소 값을 만드는 2개의 수가 존재하는지 체크
        int L = 1,R = N;
        int target = A[target_idx];
        while(L < R){
            if(target_idx == L)L++;
            else if(target_idx == R)R--;
            else{
                int sum = A[L] + A[R];
                if(sum < target)L++;
                else if(sum == target) return true;
                else R--;
            }
        }
        return false;
    }

    static void pro(){
        int ans = 0;
        Arrays.sort(A,1,N+1);
        for(int i=1;i<=N;i++){
            if(isGood(i)) ans++;
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
