import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502 {
    // 연구소
    // https://www.acmicpc.net/problem/14502

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int[][] map,blank;
    static int[][] dir= {{1,0},{0,1},{-1,0},{0,-1}};
    static int N,M,B;
    static int ans = Integer.MIN_VALUE;
    static boolean[][] visit;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N+1][M+1];
        blank = new int[N*M+1][2];
        visit = new boolean[N+1][M+1];
        // 상하 좌우
        dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                map[i][j] = sc.nextInt();
            }
        }
    }

    static void bfs(){
        // 바이러스 퍼뜨리고 안전구역 찾기
        Queue<Integer> Q = new LinkedList<>();

        // 2인 지점 모두 찾아서 Q에 넣어준다.
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                // 모든 방 방문 판단 false로 초기화
                visit[i][j] = false;
                if(map[i][j] == 2){
                    Q.add(i);
                    Q.add(j);
                    visit[i][j] = true;
                }
            }
        }

        while(!Q.isEmpty()){
            // x,y는 바이러스가 있는 방의 x,y 좌표
            int x = Q.poll(); int y = Q.poll();

            for(int[] action : dir){
                int nx = x+ action[0];
                int ny = y+ action[1];

                if(nx < 1 || ny < 1 || nx > N || ny > M) continue;
                if(map[nx][ny] != 0) continue;
                if(visit[nx][ny]) continue;

                visit[nx][ny] = true;
                Q.add(nx);
                Q.add(ny);
            }
        }

        int cnt = 0;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(map[i][j] == 0 && visit[i][j] == false){
                    cnt++;
                }
            }
        }
        ans = Math.max(ans,cnt);
    }

    // idx 위치에 벽을 세워야 할지 말아야 할지 결정해야 하고, wallCount는 현재 까지 세운 벽의 개수이다.
    static void dfs(int idx,int wallCount){
        if(wallCount == 3){
            bfs();
            return;
        }

        // 벽을 더이상 세울 수 없을 때
        if(idx > B) return;
        // 빈 공간에 벽을 세운다.
        map[blank[idx][0]][blank[idx][1]] = 1;
        dfs(idx+1,wallCount+1);
        // 빈 공간에 벽을 세우지 않는다.
        map[blank[idx][0]][blank[idx][1]] = 0;
        dfs(idx+1,wallCount);
    }

    static void pro(){
        B = 0;
        // 모든 빈 공간의 위치를 모아두자
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(map[i][j] == 0){
                    B++;
                    blank[B][0] = i;
                    blank[B][1] = j;
                }
            }
        }

        dfs(1,0);

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
