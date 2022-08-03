import java.io.*;
import java.util.StringTokenizer;

public class BOJ15650 {
    // N과M(2)
    // https://www.acmicpc.net/problem/15650

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,M;
    static int[] selected;
    static boolean[] visit;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        selected = new int[M+1];
        visit = new boolean[N+1];
    }

    static void rec_func(int k,int start){
        if(k == M+1){
            // M개 고른 수열 완성
            for(int i=1;i<=M;i++){
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }else{
            for(int i=start;i<=N;i++){
                if(visit[i]) continue;
                selected[k] = i;
                visit[i] = true;
                rec_func(k+1,i+1);
                selected[k] = 0;
                visit[i] = false;
            }
        }
    }

    static void pro(){
        rec_func(1,1);
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
