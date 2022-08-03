import java.io.*;
import java.util.StringTokenizer;

public class BOJ7568 {
    // 덩치
    // https://www.acmicpc.net/problem/7568

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N;
    static Pos[] A;
    static void input(){
        N = sc.nextInt();
        A = new Pos[N+1];
        for(int i=1;i<=N;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            A[i] = new Pos(x,y);
        }
    }

    static void pro(){
        for(int i=1;i<=N;i++){
            int cnt = 0;
            for(int j=1;j<=N;j++){
                if(i == j) continue;
                if(A[i].x < A[j].x && A[i].y < A[j].y){
                    cnt++;
                }
            }
            sb.append(cnt+1).append(' ');
        }

        System.out.println(sb);
    }

    static class Pos{
        public int x;
        public int y;
        public Pos(int x,int y){
            this.x = x;
            this.y = y;
        }
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
