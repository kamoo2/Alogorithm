import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1005 {
    // ATM Craft
    // https://www.acmicpc.net/problem/1005

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,M,target;
    static int[] indeg,T_done,T;
    static ArrayList<Integer>[] adj;
    static void input(){
        // TESTCASE가 존재하는 문제이므로 "배열 초기화"에 유의 하자
        N = sc.nextInt();
        M = sc.nextInt();
        adj = new ArrayList[N+1];
        indeg = new int[N+1];
        T_done = new int[N+1];
        T = new int[N+1];
        for(int i=1;i<=N;i++){
            adj[i] = new ArrayList<Integer>();
            T[i] = sc.nextInt();
        }

        for(int i=0;i<M;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj[x].add(y);
            indeg[y]++;
        }
        target = sc.nextInt();
    }

    static void pro(){
        Deque<Integer> Q = new LinkedList<>();
        // 제일 앞에 올 수 있는 정점 찾기
        for(int i=1;i<=N;i++){
            if(indeg[i] == 0){
                Q.add(i);
                T_done[i] = T[i];
            }
        }
        // 정렬될 수 있는 정점 있다면 ?
        // 1. 정렬 결과에 추가
        // 2. 정점과 연결된 간선 제거
        // 3. 새롭게 "정렬 될 수 있는" 정점 추가
        while(!Q.isEmpty()){
            int x = Q.poll();
            for(int y : adj[x]){
                indeg[y]--;
                if(indeg[y] == 0) Q.add(y);
                T_done[y] = Math.max(T_done[y],T_done[x] + T[y]);
            }
        }
        System.out.println(T_done[target]);
    }

    public static void main(String[] args) {
        int Q = sc.nextInt();
        while(Q > 0){
            Q--;
            input();
            pro();
        }
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
