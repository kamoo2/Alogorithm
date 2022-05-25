import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2251 {
    // 물통
    // https://www.acmicpc.net/problem/2251

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int[] Limit;
    static boolean[] possible;
    static boolean[][][] visit;
    static void input(){
        Limit = new int[3];
        for(int i=0;i<3;i++){
            Limit[i] = sc.nextInt();
        }
        visit = new boolean[201][201][201];
        possible = new boolean[201];

    }

    static void bfs(int a,int b,int c){
        Queue<State> queue = new LinkedList<>();
        visit[a][b][c] = true;
        queue.add(new State(new int[]{a,b,c}));

        while(!queue.isEmpty()){
            State s = queue.poll();

            if(s.X[0] == 0) possible[s.X[2]] = true;
            for(int from=0;from<3;from++){
                for(int to=0;to<3;to++){
                    if(from == to) continue;
                    State nxt = s.move(from,to,Limit);

                    if(!visit[nxt.X[0]][nxt.X[1]][nxt.X[2]]){
                        visit[nxt.X[0]][nxt.X[1]][nxt.X[2]] = true;
                        queue.add(nxt);
                    }
                }
            }
        }
    }

    static void pro(){
        bfs(0,0,Limit[2]);
        // 정답 계산
        for(int i=0;i<=Limit[2];i++){
            if(possible[i]) sb.append(i).append(' ');
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class State{
        int[] X;
        public State(int[] _X){
            X = new int[3];
            for(int i=0;i<3;i++) X[i] = _X[i];
        }

        State move(int from,int to,int[] Limit){
            int[] nX = new int[]{X[0],X[1],X[2]};
            if(X[from] + X[to] >= Limit[to]){
                nX[from] -= Limit[to] - X[to];
                nX[to] = Limit[to];
            }else{
                // 더한값이 리밋 보다 작을 때
                nX[from] = 0;
                nX[to] = X[from] + X[to];
            }
            return new State(nX);
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
