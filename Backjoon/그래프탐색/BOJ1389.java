import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1389 {
    // 케빈 베이컨의 6단계 법칙
    // https://www.acmicpc.net/problem/1389

    static StringBuilder sb = new StringBuilder();
    static BOJ5567.FastReader sc = new BOJ5567.FastReader();
    static int N,M,ans=Integer.MAX_VALUE,sol;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static int[] dist;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
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
        visit = new boolean[N+1];
        dist = new int[N+1];
    }

    static int bfs(int start){
        int sum = 0;
        Queue<Integer> Q = new LinkedList<>();
        // bfs를 여러번 반복하기 때문에 visit과 dist를 초기화 해줘야 한다.
        for(int i=1;i<=N;i++){
            visit[i] = false;
            dist[i] = -1;
        }

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

        for(int i=1;i<=N;i++){
            if(i == start)continue;
            sum += dist[i];
        }

        return sum;
    }

    static void pro(){
        // 각 사람마다 케빈 베이컨을 구해야 하기 때문에 bfs를 N번 반복 실행
        for(int i=1;i<=N;i++){
            int sum = bfs(i);
            if(ans > sum){
                ans = sum;
                sol = i;
            }else continue;
        }

        System.out.println(sol);
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
