import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7795_2 {
    // 먹을 것인가 먹힐 것인가
    // https://www.acmicpc.net/problem/7795
    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N+1];
        B = new int[M+1];
        for(int i = 1;i<=N;i++) A[i] = sc.nextInt();
        for(int i = 1;i<=M;i++) B[i] = sc.nextInt();
    }

    static int N,M,T;
    static int[] A,B;

    static int lower_bound(int[] A,int L,int R,int X){
        // A[L...R] 에서 X 미만의 수 중 가장 오른쪽의 idx를 return 하는 함수
        // 그런게 없다면 L-1을 리턴
        int result = L-1;
        while(L <= R){
            int mid = (L + R)/2;
            if(A[mid] < X){
                result = mid;
                L = mid+1;
            }else{
                R = mid-1;
            }
        }

        return result;
    }

    static void pro(){
        // B 배열에 대한 이분탐색을 할 것이기 때문에 B 배열을 오름차순 정렬 해줘야함 !
        Arrays.sort(B,1,M+1);

        int ans = 0;
        for(int i=1;i<=N;i++){
            ans += lower_bound(B,1,M,A[i]);
        }

        System.out.println(ans);
    }
    public static void main(String[] args) {
        T = sc.nextInt();
        for(int tt = 1;tt<=T;tt++){
            input();
            pro();
        }
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
