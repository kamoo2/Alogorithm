import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11403_2{
    // 경로찾기
    // https://www.acmicpc.net/problem/11403
    // 전 풀이는 불필요한 작업이 많았던 것 같다.
    // 굳이 새로운 이차원 배열을 만들지 않아도 충분히 구현이 가능하다.

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N;
    static int[][] map;
    static boolean[] visit;
    static void input(){
        N = sc.nextInt();
        map = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                map[i][j]= sc.nextInt();
            }
        }
    }

    static void bfs(int v){
        Queue<Integer> Q = new LinkedList<>();
        Q.add(v);
        // visit 배열 초기화
        for(int i=1;i<=N;i++){
            visit[i] = false;
        }

        while(!Q.isEmpty()){
            int x = Q.poll();
            for(int i=1;i<=N;i++){
                if(map[x][i] == 0)continue;
                if(visit[i])continue;
                Q.add(i);
                visit[i] = true;
            }
        }

        for(int i=1;i<=N;i++){
            sb.append(visit[i] ? 1 : 0).append(' ');
        }
    }

    static void pro(){
        visit = new boolean[N+1];
        for(int i=1;i<=N;i++){
            bfs(i);
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
