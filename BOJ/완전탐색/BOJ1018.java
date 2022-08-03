import java.io.*;
import java.util.StringTokenizer;

public class BOJ1018 {
    // 체스판 다시 칠하기
    // https://www.acmicpc.net/problem/1018

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,M,ans =Integer.MAX_VALUE,cnt = 0;
    static int SIZE = 8;
    static boolean[][] map; // White면 true Black이면 false
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        map = new boolean[N+1][M+1];
        for(int i=1;i<=N;i++){
            String str = sc.nextLine();
            for(int j=1;j<=M;j++){
                if(str.charAt(j-1) == 'W') {
                    map[i][j] = true;
                }else{
                    map[i][j] = false;
                }
            }
        }
    }

    static void check(int x,int y){
        cnt = 0;
        boolean FirstPos = map[x][y];
        for(int i=x;i<x+SIZE;i++){
            for(int j=y;j<y+SIZE;j++){
                if(FirstPos != map[i][j])cnt++;
                FirstPos = !FirstPos;
            }
            FirstPos = !FirstPos;
        }

        cnt = Math.min(cnt,64-cnt);

        ans = Math.min(ans,cnt);

    }

    static void pro(){
        for(int i=1;i<=N-7;i++){
            for(int j=1;j<=M-7;j++){
                check(i,j);
            }
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
