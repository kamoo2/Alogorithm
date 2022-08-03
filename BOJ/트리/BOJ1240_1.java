import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1240_1 {
    // 노드 사이의 거리
    // https://www.acmicpc.net/problem/1240

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,M;
    static ArrayList<Edge>[] edges;
    static boolean[] visit;
    static int[] dists;
    static class Edge{
        int toIdx;
        int dist;
        public Edge(int toIdx,int dist){
            this.toIdx = toIdx;
            this.dist = dist;
        }
    }
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        edges = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            edges[i] = new ArrayList<Edge>();
        }

        for(int i=1;i<N;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int dist = sc.nextInt();
            edges[x].add(new Edge(y,dist));
            edges[y].add(new Edge(x,dist));
        }
        visit = new boolean[N+1];
        dists = new int[N+1];
    }

    static void dfs(int searchVertex,int targetVertex){
        visit[searchVertex] = true;
        for(Edge y : edges[searchVertex]){
            if(visit[y.toIdx])continue;
            if(targetVertex == y.toIdx) {
                dists[targetVertex] = dists[searchVertex] + y.dist;
                return;
            }
            dists[y.toIdx] = dists[searchVertex] + y.dist;
            dfs(y.toIdx,targetVertex);
        }
    }

    static void pro(){
        for(int i=1;i<=M;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            dfs(x,y);
            sb.append(dists[y]).append('\n');
            for(int j=1;j<=N;j++) {
                visit[j] = false;
                dists[j] = 0;
            }
        }
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
