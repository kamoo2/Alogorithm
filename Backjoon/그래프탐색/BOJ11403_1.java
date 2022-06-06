import java.io.*;
import java.util.StringTokenizer;

public class BOJ11403_1 {
    // 경로찾기
    // https://www.acmicpc.net/problem/11403

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N;
    static int map[][],ans[][];
    static boolean[] visit;
    static void input(){
        N = sc.nextInt();
        map = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                map[i][j] = sc.nextInt();
            }
        }
        visit = new boolean[N];
    }
    static void dfs(int firstValue,int curValue){
        for(int i=0;i<N;i++){
            if(map[curValue][i] == 1 && !visit[i]){
                visit[i] = true;
                ans[firstValue][i] = 1;
                dfs(firstValue,i);
            }
        }
    }
    static void pro(){
        ans = new int[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++)visit[j] = false;
            dfs(i,i);
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(ans[i][j]).append(' ');
            }
            sb.append('\n');
        }

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
