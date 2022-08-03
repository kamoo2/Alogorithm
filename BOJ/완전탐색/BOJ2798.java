import java.io.*;
import java.util.StringTokenizer;

public class BOJ2798 {
    // 블랙잭
    // https://www.acmicpc.net/problem/2798

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,M,ans = Integer.MIN_VALUE;
    static int[] A,selected;
    static boolean[] visit;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N+1];
        selected = new int[4];
        visit = new boolean[N+1];
        for(int i=1;i<=N;i++){
            A[i] = sc.nextInt();
        }
    }
    static void rec_func(int k,int sum){
        if(k == 4){
            // 3장의 카드를 고름
            // 3장의 카드 합이 M을 넘었을 때 함수 종료
            if(sum > M) return;
            ans = Math.max(ans,sum);

        }else{
            for(int i=1;i<=N;i++){
                if(visit[i])continue;
                selected[k] = A[i];
                visit[i] = true;
                rec_func(k+1,sum+A[i]);
                selected[k] = 0;
                visit[i] = false;
            }
        }
    }

    static void pro(){
        rec_func(1,0);
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
