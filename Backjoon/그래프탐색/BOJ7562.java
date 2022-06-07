import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7562 {
    // 나이트의 이동
    // https://www.acmicpc.net/problem/7562

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,cur_x,cur_y,target_x,target_y;
    static boolean[][] visit;
    static int[][] dist, dir ={{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
    static void input(){
        N = sc.nextInt();
        cur_x = sc.nextInt();
        cur_y = sc.nextInt();
        target_x = sc.nextInt();
        target_y = sc.nextInt();
        visit = new boolean[N][N];
        dist = new int[N][N];
    }

    static void bfs(int pos_x,int pos_y){
        Queue<Integer> Q = new LinkedList<>();
        Q.add(pos_x);
        Q.add(pos_y);
        visit[pos_x][pos_y] = true;
        dist[pos_x][pos_y] = 0;

        while(!Q.isEmpty()){
            int x = Q.poll();
            int y = Q.poll();
            for(int[] ar : dir){
                int nx = x + ar[0];
                int ny = y + ar[1];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N)continue;
                if(visit[nx][ny])continue;
                Q.add(nx);
                Q.add(ny);
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }

    static void pro(){
        bfs(cur_x,cur_y);
        sb.append(dist[target_x][target_y]).append('\n');
    }

    public static void main(String[] args) {
        int T = sc.nextInt();
        for(int tt = 0;tt<T;tt++){
            input();
            pro();
        }
        System.out.println(sb);
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
