import java.io.*;
import java.util.StringTokenizer;

public class BOJ2805 {
    // 나무 자르기
    // https://www.acmicpc.net/problem/2805
    // 원하는 길이 M만큼을 얻을 수 있는 최대 높이는 얼마 인가 ?
    // 결정문제로 변환 -> 어떤 높이로 잘라야지 M의 길이를 얻을 수 있는가 ? -> yes,or로 표현 가능

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();

    // 나무 높이 H : 0 <= H <= 1000000000(10억) : int형
    // 나무의 수 N : 1 <= N <= 1000000 (100만) : int형
    // 필요한 나무길이 M : 1 <= M <= 2000000000 (20억) : int형
    // 자른 나무의 합 : 0 <= sum <= 100만 x 10억(10^15) : long형
    static int N,M;
    static int[] T; // (크기 N + 1)
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        T = new int[N+1];
        for(int i=1;i<=N;i++){
            T[i] = sc.nextInt();
        }
    }

    static boolean determination(int H){
        long sum =0;
        for(int i=1;i<=N;i++){
            if(T[i] > H){
                sum += T[i]-H;
            }
        }

        return sum >= M;
    }

    static void pro(){
        int L =0,R = 1000000000,ans= 0;

        while(L <= R){
            int mid = (L + R)/2;

            if(determination(mid)){
                ans = mid;
                L = mid +1;
            }else{
                R = mid-1;
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

