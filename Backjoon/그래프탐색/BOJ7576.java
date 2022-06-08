import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {
    // 토마토 (2차원)
    // https://www.acmicpc.net/problem/7576

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,M;
    static int[][] dist,map,dir={{1,0},{-1,0},{0,1},{0,-1}};
    static void input(){
        M = sc.nextInt(); // 가로
        N = sc.nextInt(); // 세로
        dist = new int[N+1][M+1];
        map = new int[N+1][M+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                map[i][j] = sc.nextInt();
            }
        }
    }
    static int bfs(){
        Queue<Integer> Q = new LinkedList<>();
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                dist[i][j] = -1;
                if(map[i][j] == 1){
                    Q.add(i);
                    Q.add(j);
                    dist[i][j] = 0;
                }
            }
        }

        while(!Q.isEmpty()){
            int x = Q.poll();
            int y = Q.poll();
            for(int[] ar:dir){
                int nx = x + ar[0];
                int ny = y + ar[1];

                if(nx < 1 || ny < 1 || nx > N || ny > M)continue;
                if(map[nx][ny] != 0)continue;
                if(dist[nx][ny] != -1)continue;
                Q.add(nx);
                Q.add(ny);
                dist[nx][ny] = dist[x][y] + 1;
            }
        }

        int ans = 0;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(map[i][j] == -1)continue;
                if(dist[i][j] == -1) return -1;
                ans = Math.max(ans,dist[i][j]);
            }
        }
        return ans;
    }

    static void pro(){
        int result = bfs();
        System.out.println(result);
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
