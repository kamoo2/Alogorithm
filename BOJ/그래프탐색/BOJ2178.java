import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {
    // 미로 탐색
    // https://www.acmicpc.net/problem/2178

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,M;
    static int[][] dist,map;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static String[] S;
    static boolean[][] visit;

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        S = new String[N];
        for(int i=0;i<N;i++){
            S[i] = sc.nextLine();
        }
        dist = new int[N][M];
        visit = new boolean[N][M];
    }

    static void bfs(int x,int y){
        Queue<Integer> Q = new LinkedList<>();

        // dist 배열 초기화 , visit 배열 초기화
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                dist[i][j] = -1;
                visit[i][j] = false;
            }
        }

        Q.add(x);
        Q.add(y);
        // 시작과 끝점도 칸 수에 추가 하기 때문에
        dist[x][y] = 1;
        visit[x][y] = true;

        while(!Q.isEmpty()){
            x= Q.poll(); y = Q.poll();
            for(int[] ac : dir){
                int nx = x + ac[0];
                int ny = y + ac[1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue; // 인접 칸이 범위를 벗어나는가 ?
                if(visit[nx][ny]) continue; // 인접 칸이 방문했던 곳인가 ?
                if(S[nx].charAt(ny) == '0') continue; // 인접 칸의 값이 0인가 ? -> 인접 칸으로 이동 불가능 한가 ?

                Q.add(nx);
                Q.add(ny);
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] +1;
            }
        }
    }

    static void pro(){
        // 시작 점 넣어줌
        bfs(0,0);

        System.out.println(dist[N-1][M-1]);
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
