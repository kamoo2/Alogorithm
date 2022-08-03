import java.io.*;
import java.util.StringTokenizer;

public class BOJ15651 {

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,M;
    static int[] selected;

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        selected = new int[M+1];
    }

    static void rec_func(int k){
        if(k == M+1){
            for(int i=1;i<=M;i++){
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }else{
            for(int i=1;i<=N;i++){
                selected[k] = i;
                rec_func(k+1);
                selected[k] = 0;
            }
        }
    }

    static void pro(){
        rec_func(1);
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
