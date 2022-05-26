import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2252 {
    // 줄 세우기
    // https://www.acmicpc.net/problem/2252

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,M;
    static int[] indeg;
    static boolean[] visit;
    static ArrayList<Integer>[] adj;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        indeg = new int[N + 1]; // 1번부터 N번까지의 학생들 존재
        adj = new ArrayList[N+1];
        for(int i =1;i<=N;i++) adj[i] = new ArrayList<Integer>();
        for(int i=0;i<M;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a].add(b);
            indeg[b]++;
        }
    }
    static void topological_sort(){
        // indeg[1~N] 중 값이 0인 정점을 Queue에 넣어준다.
        Queue<Integer> Q = new LinkedList<>();
        for(int i=1;i<=N;i++){
            if(indeg[i] == 0){
                Q.add(i);
            }
        }

        while(!Q.isEmpty()){
            int x = Q.poll();
            sb.append(x).append(' ');
            for(int y : adj[x]){
                indeg[y]--;
                if(indeg[y] == 0) Q.add(y);
            }
        }
        System.out.println(sb.toString());
    }
    static void pro(){
        topological_sort();
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
