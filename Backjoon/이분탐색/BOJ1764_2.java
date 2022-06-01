import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1764_2 {
    // 듣보잡
    // https://www.acmicpc.net/problem/1764
    // 첫번째 풀이에서 조금더 향상된 성능을 가진 알고리즘을 구현하고자 했다.
    // 첫번째 풀이에서는 N과M의 개수에 상관없이 N개의 배열이 이분탐색할 배열이됬고, M개의 배열이 탐색할 배열이 됬다.
    // 그러면 N개의 수가 1000이고 M개의 수가 50만이라고 하면 log1000 * 50만 , 대략 500만번의 탐색을 해야한다.
    // 만약 50만개의 수를 이분탐색으로 탐색하며 1000개의 수를 찾는다면 ?
    // log500000 * 1000은 대략 18000의 탐색만에 찾을 수 있다.
    // 그래서 N과M을 비교해서 searchNums와 resultNums를 정해주는 알고리즘을 구현해보고자 했다.
    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,M;
    static String[] A,B;
    static String[] ans;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        A = new String[N+1];
        B = new String[M+1];
        for(int i=1;i<=N;i++){
            A[i] = sc.nextLine();
        }
        for(int i=1;i<=M;i++){
            B[i] = sc.nextLine();
        }
    }

    static boolean isRepeated(String[] S,int L,int R,String X){
        while(L<=R){
            int mid =(L+R)/2;

            if(S[mid].compareTo(X) == 0) return true;

            if(S[mid].compareTo(X) > 0){
                // S[mid] > X
                R = mid -1;
            }else{
                L = mid+1;
            }
        }
        return false;
    }

    static void pro(String[] searchNums,String[] resultNums,int size){
        int cnt = 0;
        Arrays.sort(searchNums,1,N+1);
        ans = new String[size+1];
        for(int i=1;i<=size;i++){
            if(isRepeated(searchNums,1,searchNums.length-1,resultNums[i])){
                ans[++cnt] = resultNums[i];
            }
        }
        sb.append(cnt).append('\n');
        Arrays.sort(ans,1,cnt+1);
        for(int i=1;i<=cnt;i++){
            sb.append(ans[i]).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        if(N>=M) pro(A,B,M);
        else pro(B,A,N);
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
