import java.io.*;
import java.util.StringTokenizer;

public class BOJ10819 {
    // 차이를 최대로
    // https://www.acmicpc.net/problem/10819

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();

    static int N;
    static int ans = Integer.MIN_VALUE;
    static int[] nums,selected;
    static boolean[] visit;
    static void input(){
        N = sc.nextInt();
        nums = new int[N+1];
        selected = new int[N+1];
        visit = new boolean[N+1];
        for(int i=1;i<=N;i++){
            nums[i] = sc.nextInt();
        }
    }

    static void rec_func(int k){
        if(k == N+1){
            int sum = 0;
            // 배열 완성
            for(int i=1;i<N;i++){
                sum += Math.abs(selected[i] - selected[i+1]);
            }
            ans = Math.max(ans,sum);
        }else{
            // 배열 배치
            for(int i=1;i<=N;i++){
                if(visit[i]) continue;
                selected[k] = nums[i];
                visit[i] = true;
                rec_func(k+1);
                visit[i] = false;
                selected[k] = 0;
            }
        }
    }

    static void pro(){
        rec_func(1);
        System.out.println(ans);
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
