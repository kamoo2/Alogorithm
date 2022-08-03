import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18404 {
    // 현명한 나이트
    // https://www.acmicpc.net/problem/18404

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,M,cX,cY;
    static int[][] dist,dir = {{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
    static boolean[][] visit;
    static Enemy[] enemy;

    static class Enemy {
        int x;
        int y;
        public Enemy(int x ,int y){
            this.x = x;
            this.y = y;
        }
    }
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        cX = sc.nextInt();
        cY = sc.nextInt();
        enemy = new Enemy[M+1];
        visit = new boolean[N+1][N+1];
        dist = new int[N+1][N+1];
        for(int i=1;i<=M;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            enemy[i] = new Enemy(x,y);
        }
    }

    static void bfs(int s1,int s2){
        Queue<Integer> Q = new LinkedList<>();
        Q.add(s1);
        Q.add(s2);
        visit[s1][s2] = true;
        dist[s1][s2] = 0;

        while(!Q.isEmpty()){
            int x = Q.poll();
            int y = Q.poll();

            for(int[] ar : dir){
                int nx = x + ar[0];
                int ny = y + ar[1];

                if(nx < 1 || ny < 1 || nx > N || ny > N)continue;
                if(visit[nx][ny])continue;
                Q.add(nx);
                Q.add(ny);
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] +1;
            }
        }
    }

    static void pro(){
        bfs(cX,cY);

        for(int i=1;i<=M;i++){
            int x = enemy[i].x;
            int y = enemy[i].y;
            sb.append(dist[x][y]).append(' ');
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
