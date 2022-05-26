import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class BOJ1516 {
    // 게임개발
    // https://www.acmicpc.net/problem/1516

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N;
    static int[] T,T_done,indeg;
    static ArrayList<Integer>[] adj;
    static void input(){
        N = sc.nextInt();
        T = new int[N+1];
        T_done = new int[N+1];
        indeg = new int[N+1];
        adj = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            adj[i] = new ArrayList<Integer>();
        }

        for(int i=1;i<=N;i++){
            T[i] = sc.nextInt();
            while(true){
                int y = sc.nextInt();
                if(y == -1) break;
                adj[y].add(i);
                indeg[i]++;
            }
        }
    }

    static void pro(){
        // 처음에 Queue에 들어갈 정점 찾아서 넣기
        Queue<Integer> Q = new LinkedList<>();

        for(int i=1;i<=N;i++){
            if(indeg[i] == 0){
                Q.add(i);
                T_done[i] = T[i];
            }
        }

        while(!Q.isEmpty()){
            int x = Q.poll();

            for(int y : adj[x]){
                indeg[y]--;
                if(indeg[y] == 0) Q.add(y);
                T_done[y] = Math.max(T_done[y],T_done[x] + T[y]);
            }
        }
        for(int i=1;i<=N;i++){
            sb.append(T_done[i]).append('\n');
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
