import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1753 {
    // 최단 경로
    // https://www.acmicpc.net/problem/1753

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();

    static class Edge {
        public int to,weight;
        public Edge(int to,int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    static class Info {
        public int v,dist;
        public Info(int v,int dist){
            this.v = v;
            this.dist =dist;
        }
    }
    static int V,E,start;
    static int[] dist;
    static ArrayList<Edge>[] edges;
    static void input(){
        V = sc.nextInt();
        E = sc.nextInt();
        dist = new int[V+1];
        edges = new ArrayList[V+1];
        start = sc.nextInt();
        for(int i=1;i<=V;i++) edges[i] = new ArrayList<Edge>();
        for(int i=1;i<=E;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();
            edges[x].add(new Edge(y,w));
        }
    }

    static void dijkstra(int start){
        // dist 배열 초기화
        for(int i=1;i<=V;i++) dist[i] = Integer.MAX_VALUE;

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o->o.dist));
        pq.add(new Info(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Info info = pq.poll();
            if(dist[info.v] != info.dist) continue;

            for(Edge e : edges[info.v]){
                if(dist[info.v] + e.weight >= dist[e.to]) continue;

                dist[e.to] = dist[info.v] + e.weight;
                pq.add(new Info(e.to,dist[e.to]));
            }
        }
        for(int i=1;i<=V;i++){
            if(dist[i] == Integer.MAX_VALUE){
                sb.append("INF").append('\n');
                continue;
            }
            sb.append(dist[i]).append('\n');
        }
    }

    static void pro(){
        dijkstra(start);

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
