import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {
    // 숨바꼭질
    // https://www.acmicpc.net/problem/1697

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,K;
    static boolean[] visit;
    static int[] dist;
    static void input(){
        N = sc.nextInt();
        K = sc.nextInt();
        visit = new boolean[100001];
        dist = new int[100001];
    }

    static void bfs(){
        Queue<Integer> Q = new LinkedList<>();
        Q.add(N);
        visit[N] = true;
        dist[N] = 0;

        while(!Q.isEmpty()){
            int x = Q.poll();

            if(x -1 >= 0 && !visit[x-1]){
                Q.add(x-1);
                visit[x-1] = true;
                dist[x-1] = dist[x] +1;
            }

            if(x + 1 <= 100000 && !visit[x+1]){
                Q.add(x+1);
                visit[x+1] = true;
                dist[x+1] = dist[x] +1;
            }

            if(x * 2 <= 100000 && !visit[x*2]){
                Q.add(x*2);
                visit[x*2] = true;
                dist[x*2] = dist[x] +1;
            }
        }
    }

    static void pro(){
        bfs();

        System.out.println(dist[K]);
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
