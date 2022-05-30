import java.io.*;
import java.util.StringTokenizer;

public class BOJ14889 {
    // 스타트와 링
    // https://www.acmicpc.net/problem/14889

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,min=Integer.MAX_VALUE;
    static int[][] map;
    static int[] selected;
    static void input(){
        N= sc.nextInt();
        map = new int[N+1][N+1];
        selected = new int[N+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                map[i][j] = sc.nextInt();
            }
        }
    }

    static void rec_func(int k,int start){
        if(k == N/2 +1){
            int startTeam = 0;
            int linkTeam = 0;
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(selected[i] == 1 && selected[j] == 1){
                        startTeam+= map[i][j];
                    }else if(selected[i] == 0 && selected[j] == 0){
                        linkTeam+=map[i][j];
                    }
                }
            }
            min = Math.min(min,Math.abs(startTeam - linkTeam));
        }else{
            for(int i=start;i<=N;i++){
                selected[i] = 1;
                rec_func(k+1,i+1);
                selected[i] = 0;
            }
        }
    }

    static void pro(){
        rec_func(1,1);
        System.out.println(min);
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
