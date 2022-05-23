import java.io.*;
import java.util.StringTokenizer;

public class BOJ2343 {
    // 기타 레슨
    // https://www.acmicpc.net/problem/2343

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,M;
    static int[] A;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N+1];

        for(int i=1;i<=N;i++){
            A[i] = sc.nextInt();
        }
    }

    static boolean determination(int size){
        int sum = 0,cnt = 1;
        // for문으로 A 배열 돌면서 순차적으로 값을 더해간다.
        // sum += A[i]를 했을 때 size를 초과 한다면 cnt ++하고 sum = A[i]로 변경
        for(int i=1;i<=N;i++){
            if(sum + A[i] <= size){
                sum += A[i];
            }else{
                sum = A[i];
                cnt++;
            }
        }
        return cnt <= M;
    }

    static void pro(){
        int L = 0, R = 999900000,ans = 0,sum=0;
        for(int i=1;i<=N;i++) L = Math.max(L,A[i]);
        // L의 시작 값을 설정해주지 않으면 답이 틀렸다고 나온다.
        // A[i]의 최대값으로 L을 설정해줘야 한다.
        // 왜냐하면 블루레이 하나에 최소 하나의 강의는 담아야 하기 때문
        while(L <= R){
            int mid  = (L+ R )/2;
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
