import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2606 {
    // 바이러스
    // https://www.acmicpc.net/problem/2606

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,M,ans=0;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        adj = new ArrayList[N+1];
        for(int i=1;i<=N;i++) adj[i] = new ArrayList<Integer>();
        for(int i=1;i<=M;i++){
            int x= sc.nextInt();
            int y= sc.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        visit = new boolean[N+1];
    }

    static void dfs(int V){
        // 1번 컴퓨터 감염시 감염되는 컴퓨터 수 출력
        visit[V] = true;
        for(int to : adj[V]){
            if(visit[to])continue;
            ans++;
            dfs(to);
        }
    }

    static void pro(){
        dfs(1);
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
