import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3055 {
    // 탈출
    // https://www.acmicpc.net/problem/3055
    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();

    static int R,C;
    static String[] S;
    static int[][] dist_water,dist_hedgehog;
    static boolean[][] visit;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static void input(){
        R = sc.nextInt();
        C = sc.nextInt();
        S = new String[R];
        for(int i=0;i<R;i++){
            S[i] = sc.nextLine();
        }
        dist_hedgehog = new int[R][C];
        dist_water = new int[R][C];
        visit = new boolean[R][C];
    }

    static void dfs_water(){
        Queue<Integer> Q = new LinkedList<>();
        // 초기화
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                visit[i][j] = false;
                dist_water[i][j] = -1;
                if(S[i].charAt(j) == '*'){
                    // 만약에 물이면 큐에 추가
                    Q.add(i);
                    Q.add(j);
                    visit[i][j] = true;
                    dist_water[i][j] = 0;
                }
            }
        }

        // BFS 시작
        while(!Q.isEmpty()){
            int x = Q.poll();
            int y = Q.poll();

            for(int[] ac : dir){
                int nx = x + ac[0];
                int ny = y + ac[1];

                // 1<= x <=50
                if(nx < 0 || ny < 0 || nx >= R || ny >= C)continue;
                if(S[nx].charAt(ny) != '.')continue;
                if(visit[nx][ny]) continue;

                Q.add(nx);
                Q.add(ny);
                visit[nx][ny] = true;
                dist_water[nx][ny] = dist_water[x][y] + 1;
            }
        }
    }

    static void dfs_hedgehog(){
        Queue<Integer> Q = new LinkedList<>();
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                visit[i][j] = false;
                dist_hedgehog[i][j] = -1;
                if(S[i].charAt(j) == 'S'){
                    Q.add(i);
                    Q.add(j);
                    visit[i][j] = true;
                    dist_hedgehog[i][j] = 0;
                }
            }
        }

        // BFS 시작
        while(!Q.isEmpty()){
            int x = Q.poll();
            int y = Q.poll();

            for(int[] ac : dir){
                int nx = x + ac[0];
                int ny = y + ac[1];

                if(nx < 0 || ny < 0 || nx >= R || ny >= C)continue; // 범위 벗어나면 continue
                if(S[nx].charAt(ny) != '.' && S[nx].charAt(ny) != 'D') continue;
                if(dist_water[nx][ny] != -1 && dist_hedgehog[x][y] +1 >= dist_water[nx][ny] ) continue;
                if(visit[nx][ny]) continue;

                Q.add(nx);
                Q.add(ny);
                visit[nx][ny] = true;
                dist_hedgehog[nx][ny] = dist_hedgehog[x][y] +1;

            }
        }
    }

    static void pro(){
        dfs_water();

        dfs_hedgehog();

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(S[i].charAt(j) == 'D'){
                    if(dist_hedgehog[i][j] == -1){
                        System.out.println("KAKTUS");
                    }else{
                        System.out.println(dist_hedgehog[i][j]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
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
