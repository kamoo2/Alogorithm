import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11725 {
    // 트리의 부모 찾
    // https://www.acmicpc.net/problem/11725

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N;
    static ArrayList<Integer>[] adj;
    static int[] parents;
    static boolean[] visit;
    static void input(){
        N = sc.nextInt();
        adj = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            adj[i] = new ArrayList<Integer>();
        }

        for(int i=1;i<N;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }

    }
    static void bfs(int v){
        Queue<Integer> Q = new LinkedList<>();
        Q.add(v);
        visit[v] = true;
        while(!Q.isEmpty()){
            int x = Q.poll();

            for(int y : adj[x]){
                if(visit[y])continue;
                Q.add(y);
                visit[y] = true;
                parents[y] = x;
            }
        }
    }
    static void pro(){
        parents = new int[N+1];
        visit = new boolean[N+1];
        bfs(1);

        for(int i=2;i<=N;i++){
            sb.append(parents[i]).append('\n');
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
