import java.io.*;
import java.util.StringTokenizer;

public class BOJ1182 {
    static StringBuilder sb= new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,S,ans;
    static int[] nums,selected;
    static boolean[] visit;
    static void input(){
        N = sc.nextInt();
        S = sc.nextInt();
        nums = new int[N+1];
        visit = new boolean[N+1];
        for(int i=1;i<=N;i++){
            nums[i] = sc.nextInt();
        }
    }

    static void rec_func(int depth,int sum){
        if(depth == N+1){
            // 부분 수열 완성
            if(sum == S) ans++;
        }else{

                // 해당 원소 선택
                rec_func(depth+1,sum+nums[depth]);
                // 해당 원소 선택 X
                rec_func(depth+1,sum);
        }
    }


    static void pro(){
        ans = 0;
        rec_func(1,0);
        if(S == 0) ans--;
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

        public FastReader(String s)throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next(){
            if(st == null || !st.hasMoreTokens()){
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
