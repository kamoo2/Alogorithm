package MaxInterval;

import java.io.*;
import java.util.StringTokenizer;

// 차이를 최대로
// https://www.acmicpc.net/problem/10819
public class BOJ10819 {
    static StringBuilder sb = new StringBuilder();

    static int N,max,sum;
    static int[] nums,used,selected;

    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        nums = new int[N+1];
        used = new int[N+1];
        selected = new int[N+1];
        for(int i=1; i<=N;i++){
            nums[i] = scan.nextInt();
        }
        max = Integer.MIN_VALUE;
    }

    static void rec_func(int k){
        if(k == N+1){
            sum =0;
            for(int i=1;i<N;i++){
                sum += Math.abs(selected[i]-selected[i+1]);
            }
            max = Math.max(max,sum);
        }else{
            for(int i=1;i<=N;i++){
                if(used[i] == 1){
                    continue;
                }
                used[i] = 1;
                selected[k] = nums[i];
                rec_func(k+1);
                used[i] = 0;
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(max);
    }



    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException{
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

        long nextLong(){
            return Long.parseLong(next());
        }

        double nextDouble(){
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
