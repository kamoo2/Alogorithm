import java.io.*;
import java.util.StringTokenizer;

public class BOJ6603 {
    // 로또
    // https://www.acmicpc.net/problem/6603

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N;
    static int[] nums;
    static int[] lotto;
    static void input(){
        N = sc.nextInt();
        nums = new int[N+1];
        lotto = new int[7];
        for(int i=1;i<=N;i++){
            nums[i] = sc.nextInt();
        }
    }

    static void rec_func(int depth,int start){
        if(depth == 7){
            for(int i=1;i<depth;i++){
                sb.append(lotto[i]).append(' ');
            }
            sb.append('\n');
        }else{
            for(int i=start;i<=N;i++){
                lotto[depth] = nums[i];
                rec_func(depth+1,i+1);
                lotto[depth] = 0;
            }
        }
    }

    static void pro(){
        rec_func(1,1);
        sb.append('\n');
    }

    public static void main(String[] args) {
        while(true){
            input();
            if(N == 0){
                System.out.println(sb.toString());
                break;
            }
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
