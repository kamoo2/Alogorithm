import java.io.*;
import java.util.StringTokenizer;

public class BOJ1991 {
    // 트리 순회
    // https://www.acmicpc.net/problem/1991

    // 1번 노드부터 N번 노드 까지 있다고 하면 1번 = A번 , 2번 = B번으로 정의
    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N;
    static int[][] childs;
    static void input(){
        N = sc.nextInt();
        childs = new int[30][2];
        for(int i=0;i<N;i++){
            char curCh = sc.next().charAt(0);
            int cur = (int)(curCh - 'A');
            for(int k=0;k<2;k++){
                char ch = sc.next().charAt(0);
                if(ch!='.') childs[cur][k] = (int)(ch-'A');
                else childs[cur][k] = -1;
            }
        }
    }
    // 중위 순회
    static void in_order(int x){
        if(x == -1) return;
        in_order(childs[x][0]);
        sb.append((char)(x + 'A'));
        in_order(childs[x][1]);
    }
    // 전위 순회
    static void pre_order(int x){
        if(x == -1)return;
        sb.append((char)(x+'A'));
        pre_order(childs[x][0]);
        pre_order(childs[x][1]);
    }

    static void post_order(int x){
        if(x == -1)return;
        post_order(childs[x][0]);
        post_order(childs[x][1]);
        sb.append((char)(x+'A'));
    }

    static void pro(){
        // root는 항상 A(0)
        pre_order(0);
        sb.append('\n');
        in_order(0);
        sb.append('\n');
        post_order(0);
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
