import java.io.*;
import java.util.StringTokenizer;

public class BOJ3584 {
    // 가장 가까운 공통 조상
    // https://www.acmicpc.net/problem/3584

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,root;
    static int[] parents,check;
    static void input(){
        N = sc.nextInt();
        parents = new int[N+1];
        check = new int[N+1];
        for(int i =1;i<N;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            // y의 부모는 x
            parents[y] = x;
        }
    }


    static void pro(){
        // x와 y의 공통 조상 중 가까운 노드 번호를 출력해야함
        int x = sc.nextInt();
        int y = sc.nextInt();

        while(x > 0){
            check[x] = 1;
            x = parents[x];
        }

        while(y > 0 && check[y] == 0){
            y = parents[y];
        }

        System.out.println(y);
    }

    public static void main(String[] args) {
        int T = sc.nextInt();
        while(T-- >0){
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
