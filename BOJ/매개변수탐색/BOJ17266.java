import java.io.*;
import java.util.StringTokenizer;

public class BOJ17266 {
    // 어두운 굴다리
    // https://www.acmicpc.net/problem/17266

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,M;
    static int[] A;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[M+1];
        for(int i=1;i<=M;i++){
            A[i] = sc.nextInt();
        }
    }

    static boolean determination(int H){
        // 빛을 비추는 굴다리 위치
        int last = 0;
        for(int i=1;i<=M;i++){
            if(A[i] - last <= H){
                last = A[i] + H;
            }else{
                return false;
            }
        }
        // N = 5 , xpos = 2,4 인 경우를 예를 들면
        // mid = 3, H = 3, last = 5, last = 7
        // H가 3인 가로등은 0~7까지의 굴다리를 커버 가능
        // 주어진 굴다리 길이인 N은 5이므로 이 경우는 Yes인 경우
        return last >= N;
    }

    static void pro(){
        int L = 1,R = N,ans = 0;
        while(L <=R){
            int mid = (L+R)/2;
            if(determination(mid)){
                ans = mid;
                R = mid -1;
            }else{
                L = mid +1;
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

        public FastReader(String s) throws FileNotFoundException{
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
