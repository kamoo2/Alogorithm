import java.io.*;
import java.util.StringTokenizer;

public class BOJ4963 {
    // 섬의 개수
    // https://www.acmicpc.net/problem/4963

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int W=1,H=1;
    static int[][] map,dir = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    static boolean[][] visit;
    static void input(){
        W = sc.nextInt();
        H = sc.nextInt();
        map = new int[H][W];
        visit = new boolean[H][W];
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                map[i][j] = sc.nextInt();
            }
        }
    }

    static void dfs(int x, int y){
        visit[x][y] = true;
        for(int[] ar : dir){
            int nx = x + ar[0];
            int ny = y + ar[1];

            if(nx < 0 || ny < 0 || nx >= H || ny >= W)continue;
            if(map[nx][ny] == 0)continue;
            if(visit[nx][ny])continue;
            dfs(nx,ny);
        }
    }

    static void pro(){
        int ans =0;
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                if(map[i][j] == 1 && !visit[i][j]){
                    // 땅이고 해당 땅을 방문 하지 않았다면 해당 섬 탐색 시작
                    ans++;
                    dfs(i,j);
                }
            }
        }
        sb.append(ans).append('\n');
    }

    public static void main(String[] args) {
        while(true){
            input();
            if(W == 0 && H == 0)break;
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
