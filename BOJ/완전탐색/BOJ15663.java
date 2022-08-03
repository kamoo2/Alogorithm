import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15663 {
    // N과M(9)
    // https://www.acmicpc.net/problem/15663

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,M;
    static int[] nums,selected;
    static boolean[] visit;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[N+1];
        selected = new int[M+1];
        visit =new boolean[N+1];
        for(int i=1;i<=N;i++){
            nums[i] = sc.nextInt();
        }
    }

    static void rec_func(int k){
        if(k == M+1){
            for(int i=1;i<=M;i++){
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }else{
            int last_idx = 0;
            for(int i=1;i<=N;i++){
                if(visit[i])continue;
                if(nums[i] == last_idx)continue;
                last_idx = nums[i];
                visit[i] = true;
                selected[k] = nums[i];
                rec_func(k+1);
                visit[i] = false;
                selected[k] = 0;
            }
        }
    }

    static void pro(){
        Arrays.sort(nums);
        rec_func(1);
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb);
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
