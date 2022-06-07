import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2644 {
    // 촌수 계산
    // https://www.acmicpc.net/problem/2644

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,x1,x2,M;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static int[] dist;
    static void input(){
        N = sc.nextInt();
        x1 = sc.nextInt();
        x2 = sc.nextInt();
        M = sc.nextInt();
        adj = new ArrayList[N+1];
        visit = new boolean[N+1];
        dist = new int[N+1];
        for(int i=1;i<=N;i++){
            adj[i] = new ArrayList<Integer>();
            dist[i] = -1;
        }

        for(int i=1;i<=M;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }

    }

    static void bfs(int start){
        Queue<Integer> Q = new LinkedList<>();
        Q.add(start);
        visit[start] = true;
        dist[start] = 0;

        while(!Q.isEmpty()){
            int x = Q.poll();

            for(int y : adj[x]){
                if(visit[y])continue;
                Q.add(y);
                visit[y] = true;
                dist[y] = dist[x] + 1;
            }
        }
    }

    static void pro(){
        bfs(x1);

        System.out.println(dist[x2]);
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
