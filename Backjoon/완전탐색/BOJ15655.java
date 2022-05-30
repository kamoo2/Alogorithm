import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15655 {
    // N과M(6)
    // https://www.acmicpc.net/problem/15655

    // N개의 자연수 중 M개를 고를 수열
    // 단 고른 수열은 오름차순

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();

    static int N,M;
    static int[] selected,nums;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[N+1];
        selected = new int[M+1];
        for(int i=1;i<=N;i++){
            nums[i] = sc.nextInt();
        }
    }

    static void rec_func(int k,int start){
        if(k == M+1){
            // 수열 고르기 완료
            for(int i=1;i<=M;i++){
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }else{
            // 수열 고르기
            for(int i=start;i<=N;i++){
                selected[k] = nums[i];
                rec_func(k + 1, i + 1);
                selected[k] = 0;
            }
        }
    }

    static void pro(){
        Arrays.sort(nums);
        rec_func(1,1);
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
