import java.io.*;
import java.util.StringTokenizer;

public class BOJ1654 {
    // 랜선 자르기
    // https://www.acmicpc.net/problem/1654
    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();

    static int K,N;
    static int[] A;
    static void input(){
        K = sc.nextInt();
        N = sc.nextInt();
        A = new int[K+1];
        for(int i=1;i<=K;i++){
            A[i] = sc.nextInt();
        }
    }

    static boolean determination(long l){
        long sum = 0;
        for(int i=1;i<=K;i++){
            sum += A[i] / l;
        }

        return sum >= N;
    }

    static void pro(){
        long L = 1,R = (int)Math.pow(2,31) -1,ans = 0;

        // false가 들어오면 mid가 더 작아져야 하므로 R = mid -1;
        // true가 들어오면 mid가 더 커져야 하므로 L = mid +1;
        while(L<=R){
            long mid = (L+R)/2;
            if(determination(mid)){
                ans = mid;
                L = mid +1;
            }else{
                R = mid -1;
            }
        }

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

        public FastReader(String s) throws FileNotFoundException {
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
