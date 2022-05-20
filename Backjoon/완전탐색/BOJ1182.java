package Sequence;

import java.io.*;
import java.util.StringTokenizer;

// 부분수열의 합
// https://www.acmicpc.net/problem/1182
public class BOJ1182 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static Integer N,S,ans =0;
    static Integer[] nums;
    static void input(){
        N = scan.nextInt();
        S = scan.nextInt();
        nums = new Integer[N+1];
        for(int i=1;i<=N;i++){
            nums[i] = scan.nextInt();
        }
    }


    static void rec_func(int k,int value){
        if(k == N+1){
            // 부분 수열 완성된 경우
            if(S == value){
                ans++;
            }
        }else{
            rec_func(k+1,value+nums[k]);
            rec_func(k+1,value);
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1,0);
        if(S == 0){
            ans--;
        }
        System.out.println(ans);
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next(){
            while(st == null || !st.hasMoreElements()){
                try {
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
