import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {
    // 토마토
    // https://www.acmicpc.net/problem/7569

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,M,H;
    static int[][][] A;
    static boolean[][][] visit;
    static int[][][] dist;
    static int[][] dir={{1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};
    static void input(){
        M = sc.nextInt(); // 가로
        N = sc.nextInt(); // 세로
        H = sc.nextInt(); // 높이
        A = new int[N+1][M+1][H+1];
        for(int k = 1;k<=H;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=M;j++){
                    A[i][j][k] = sc.nextInt();
                }
            }
        }

        visit = new boolean[N+1][M+1][H+1];
        dist = new int[N+1][M+1][H+1];
    }

    static int bfs(){
        Queue<Integer> Q = new LinkedList<>();
        for(int i=1;i<=H;i++){
            for(int j=1;j<=N;j++){
                for(int k=1;k<=M;k++){
                    visit[j][k][i] = false;
                    dist[j][k][i] = -1;
                    if(A[j][k][i] == 1){
                        Q.add(j); // 세로
                        Q.add(k); // 가로
                        Q.add(i); // 높이
                        visit[j][k][i] = true;
                        dist[j][k][i] = 0;
                    }
                }
            }
        }

        while(!Q.isEmpty()){
            int x = Q.poll();
            int y = Q.poll();
            int h = Q.poll();

            for(int[] ar : dir){
                int nx = x +  ar[0];
                int ny = y + ar[1];
                int nh = h + ar[2];

                if(nx < 1 || ny < 1 || nh < 1 || nx > N || ny > M || nh > H)continue;
                if(A[nx][ny][nh] == -1) continue;
                if(visit[nx][ny][nh])continue;
                Q.add(nx);
                Q.add(ny);
                Q.add(nh);
                visit[nx][ny][nh] = true;
                dist[nx][ny][nh] = dist[x][y][h] + 1;
            }
        }
        int ans = 0;
        for(int h = 1;h<=H;h++){
            for(int x = 1;x<=N;x++){
                for(int y = 1;y<=M;y++){
                    if(A[x][y][h] == -1)continue;
                    if(dist[x][y][h] == -1)return -1;
                    ans = Math.max(ans,dist[x][y][h]);
                }
            }
        }
        return ans;
    }

    static void pro(){
        System.out.println(bfs());
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
