import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260_1 {
    // DFS와 BFS (인접행렬을 이용한 풀이)
    // https://www.acmicpc.net/problem/1260
    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,M,V;
    static int[][] adj;
    static boolean[] visit;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        adj = new int[N+1][N+1];
        for(int i=1;i<=M;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj[x][y] = 1;
            adj[y][x] = 1;
        }
    }

    static void dfs(int x){
        // 깊이 우선 탐색
        visit[x] = true;
        sb.append(x).append(' ');
        for(int y=1;y<=N;y++){
            if(adj[x][y] == 0)continue;
            if(visit[y]) continue;
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
            for(int y=1;y<=N;y++){
                if(adj[x][y] ==0)continue;
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
