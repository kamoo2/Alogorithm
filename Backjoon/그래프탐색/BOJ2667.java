import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2667 {
    // 단지번호 붙이기
    // https://www.acmicpc.net/problem/2667

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,group_cnt;
    static String[] a;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static boolean[][] visit;
    static ArrayList<Integer> group;
    static void input(){
        N = sc.nextInt();
        a = new String[N+1];
        for(int i= 1;i<=N;i++){
            a[i] = sc.nextLine();
        }
        visit = new boolean[N+1][N+1];
    }

    static void dfs(int x,int y){
        visit[x][y] = true;
        group_cnt++;
        for(int[] adjCondition : dir){
            int nx = x + adjCondition[0];
            int ny = y + adjCondition[1];
            if(nx < 1 || ny < 1 || nx > N || ny > N ) continue;
            if(a[nx].charAt(ny-1) == '0') continue;
            if(visit[nx][ny]) continue;
            dfs(nx,ny);
        }
    }

    static void pro(){
        group = new ArrayList<Integer>();
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(!visit[i][j] && a[i].charAt(j-1) == '1'){
                    // 아직 방문한 단지가 아니고 해당 집이 존재하는 경우
                    group_cnt = 0;
                    dfs(i,j);
                    group.add(group_cnt);
                }
            }
        }

        Collections.sort(group);
        sb.append(group.size()).append('\n');
        for(int i=0;i<group.size();i++){
            sb.append(group.get(i)).append('\n');
        }

        System.out.println(sb.toString());
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
