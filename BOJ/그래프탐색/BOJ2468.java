import java.io.*;
import java.util.StringTokenizer;

public class BOJ2468 {
    // 안전 영역
    // https://www.acmicpc.net/problem/2468

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,max_H = 0,ans = 0;
    static int[][] map,dir={{1,0},{0,1},{-1,0},{0,-1}};
    static boolean[][] visit;
    static void input(){
        N = sc.nextInt();
        map = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                map[i][j] = sc.nextInt();
                max_H = Math.max(max_H,map[i][j]);
            }
        }

    }

    static void dfs(int x,int y,int height){
        visit[x][y] = true;
        for(int[] ar : dir){
            int nx = x + ar[0];
            int ny = y + ar[1];

            if(nx <1 || ny <1 || nx >N || ny > N)continue;
            if(map[nx][ny] <= height)continue;
            if(visit[nx][ny])continue;
            dfs(nx,ny,height);
        }
    }

    static void pro(){
        for(int i=0;i<=max_H;i++){
            int cnt = 0;
            visit = new boolean[N+1][N+1];
            for(int j=1;j<=N;j++){
                for(int k=1;k<=N;k++){
                    if(map[j][k] > i && !visit[j][k]){
                        dfs(j,k,i);
                        cnt++;
                    }
                }
            }
            ans = Math.max(ans,cnt);
        }
        System.out.println(ans);
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
