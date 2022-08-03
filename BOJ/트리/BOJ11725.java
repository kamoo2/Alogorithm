import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11725 {
    // 트리의 부모 찾기
    // https://www.acmicpc.net/problem/11725

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N;
    static ArrayList<Integer>[] adj;
    static int[] parent;
    static void input(){
        N = sc.nextInt();
        adj = new ArrayList[N+1];
        parent = new int[N+1];
        for(int i=1;i<=N;i++){
            adj[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<N-1;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    static void dfs(int x,int par){
        for(int y : adj[x]){
            if(y == par) continue;
            parent[y] = x;
            dfs(y,x);
        }
    }
    static void pro(){
        dfs(1,-1);

        // 2번 노드 부터 순서대로 부모 노드를 출력
        for(int i=2;i<=N;i++){
            sb.append(parent[i]).append('\n');
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
            if(st == null || !st.hasMoreTokens()){
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
