import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1012 {
    // 유기농 배추
    // https://www.acmicpc.net/problem/1012

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int row,col,K;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static ArrayList<Integer> group;
    static void input(){
        col = sc.nextInt();
        row = sc.nextInt();
        K = sc.nextInt();
        map = new int[row][col];
        visit =new boolean[row][col];
        for(int i=0;i<K;i++){
            int y = sc.nextInt();
            int x = sc.nextInt();
            map[x][y] = 1;
        }
    }
    static void dfs(int x,int y){
        visit[x][y] = true;
        for(int[] ar : dir){
            int nx = x + ar[0];
            int ny = y + ar[1];
            if(nx < 0 || ny < 0 || nx >= row || ny >= col)continue;
            if(map[nx][ny] == 0)continue;
            if(visit[nx][ny])continue;
            dfs(nx,ny);
        }
    }

    static void pro(){
        int cnt =0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(map[i][j] == 1 && !visit[i][j]){
                    // 배추가 있고 해당 배추에 방문하지 않았다면 탐색 Start
                    dfs(i,j);
                    cnt++;
                }
            }
        }
        sb.append(cnt).append('\n');
    }

    public static void main(String[] args) {
        int T = sc.nextInt();
        for(int tt=0;tt<T;tt++){
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
