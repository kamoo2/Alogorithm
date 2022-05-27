import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1916 {
    // 최소비용 구하기
    // https://www.acmicpc.net/problem/1916

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();

    static class Info{
        public int vertex;
        public int distance;
        public Info(int vertex,int distance){
            this.distance = distance;
            this.vertex = vertex;
        }
    }

    static class Edge {
        public int to,weight;
        public Edge(int to,int weight){
            this.to = to;
            this.weight = weight;
        }
    }


    static int N,M,start,end;
    static int[] dist;
    static ArrayList<Edge>[] edges;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        dist = new int[N+1];
        edges = new ArrayList[N+1];
        for(int i=1;i<=N;i++) edges[i] = new ArrayList<Edge>();
        for(int i=1;i<=M;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();
            edges[x].add(new Edge(y,w));
        }
        start = sc.nextInt();
        end = sc.nextInt();
    }

    static void dijkstra(int start){
        // dist 배열 값 모두 초기화
        // 단 최대 거리 값을 계산해서 그 값보다 큰 값을 넣어줘야 한다.
        for(int i=1;i<=N;i++) dist[i] = Integer.MAX_VALUE;

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o->o.distance));
        pq.add(new Info(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Info info = pq.poll();
            if(info.distance > dist[info.vertex]) continue;

            for(Edge edge : edges[info.vertex]){
                if(dist[info.vertex] + edge.weight >= dist[edge.to]) continue;

                dist[edge.to] = dist[info.vertex] + edge.weight;
                pq.add(new Info(edge.to,dist[edge.to]));
            }
        }


    }

    static void pro(){
        dijkstra(start);
        System.out.println(dist[end]);
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
