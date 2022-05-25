import java.io.*;
import java.util.*;

public class BOJ1260_2 {
    // DFS와 BFS (인접리스트를 이용한 풀이)
    // https://www.acmicpc.net/problem/1260
    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,M,V;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static void input(){
        N = sc.nextInt(); // 정점의 개수
        M = sc.nextInt(); // 간선의 개수
        V = sc.nextInt();
        adj = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            adj[i] = new ArrayList<Integer>();
        }
        for(int i=1;i<=M;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        for(int i=1;i<=N;i++){
            Collections.sort(adj[i]);
        }

    }

    static void dfs(int x){
        visit[x] = true;
        sb.append(x).append(' ');
        for(int y: adj[x]){
            if(visit[y])continue;
            dfs(y);
        }
    }

    static void bfs(int x){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visit[x] = true;

        while(!queue.isEmpty()){
            x = queue.poll();
            sb.append(x).append(' ');
            for(int y : adj[x]){
                if(visit[y])continue;
                queue.add(y);
                visit[y] = true;
            }
        }
    }

    static void pro(){
        visit = new boolean[N+1];
        dfs(V);
        sb.append('\n');
        for(int i=1;i<=N;i++) visit[i] = false;
        bfs(V);
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

        public FastReader(String s) throws FileNotFoundException {
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
