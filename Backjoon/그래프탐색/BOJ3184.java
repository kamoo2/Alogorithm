import java.io.*;
import java.util.StringTokenizer;

public class BOJ3184 {
    // 양
    // https://www.acmicpc.net/problem/3184

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int R,C,o_cnt=0,v_cnt=0;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static String[] S;
    static boolean[][] visit;
    static void input(){
        R = sc.nextInt();
        C = sc.nextInt();
        S = new String[R];
        visit = new boolean[R][C];
        for(int i=0;i<R;i++){
            S[i] = sc.nextLine();
        }
    }

    static void dfs(int x,int y){
        visit[x][y] = true;
        if(S[x].charAt(y) == 'o')o_cnt++;
        if(S[x].charAt(y) == 'v')v_cnt++;
        for(int[] ar:dir){
            int nx = x + ar[0];
            int ny = y + ar[1];
            if(nx < 0 || ny < 0 || nx >= R || ny >= C)continue;
            if(S[nx].charAt(ny) == '#')continue;
            if(visit[nx][ny])continue;
            dfs(nx,ny);
        }
    }

    static void pro(){
        int total_vCnt =0,total_oCnt=0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(S[i].charAt(j) != '#' && S[i].charAt(j) != '.' && !visit[i][j]){
                    v_cnt =0;
                    o_cnt =0;
                    dfs(i,j);
                    if(o_cnt > v_cnt){
                        v_cnt = 0;
                    }else{
                        o_cnt =0;
                    }
                    total_oCnt += o_cnt;
                    total_vCnt += v_cnt;
                }
            }
        }
        sb.append(total_oCnt).append(' ').append(total_vCnt);
        System.out.println(sb);
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
