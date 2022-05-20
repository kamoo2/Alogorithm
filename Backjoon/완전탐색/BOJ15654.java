package NandM5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// N과M (5)
// https://www.acmicpc.net/problem/15654
public class BOJ15654 {
    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static int[] nums,selected,used;
    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M+1];
        nums = new int[N+1];
        used = new int[N+1];
        for(int i=1;i<=N;i++){
            nums[i] = scan.nextInt();
        }
    }

    static void rec_func(int k){
        if(k == M+1){
            // 수열 완성
            for(int i =1; i<=M;i++){
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }else{
            // 수열에 원소 추가
            // k = 1 인 경우
            for(int cand = 1; cand <= N;cand++){

                if(used[cand] == 1){
                    continue;
                }

                used[cand] = 1;
                selected[k] = nums[cand];
                rec_func(k+1);
                used[cand] = 0;
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        Arrays.sort(nums);
        rec_func(1);
        System.out.println(sb.toString());
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
            String str ="";
            try{
                str = br.readLine();
            }catch(IOException e){
                e.printStackTrace();
            }

            return str;
        }

    }
}
