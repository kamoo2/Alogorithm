import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1764 {
    // 듣보잡
    // https://www.acmicpc.net/problem/1764

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();

    static void input(){
        N = sc.nextInt();

        A = new String[N+1];
        for(int i=1;i<=N;i++){
            A[i] = sc.nextLine();
        }

    }

    static int N,M;
    static String[] A,ans;

    static boolean bin_search(String[] A,int L,int R,String X){
        while(L <= R){
            int mid = (L+R)/2;
            if(A[mid].equals(X)){
                return true;
            }

            if(A[mid].compareTo(X) < 0){
                // 음수라는 소리는 A[mid] < X 라는 소리
                L = mid+1;
            }else{
                R = mid-1;
            }
        }
        return false;
    }
    static void pro(){
        int M = sc.nextInt(),ansCnt = 0;
        Arrays.sort(A,1,N+1);
        ans = new String[M+1];
        for(int i=1;i<=M;i++){
            String X = sc.nextLine();
            if(bin_search(A,1,N,X)){
                // 중복된 값을 찾았다 !!
                // ansCnt++ 올리고 ans 배열에 해당 문자열 추가
                ansCnt++;
                ans[ansCnt] = X;
            }
        }
        Arrays.sort(ans,1,ansCnt+1);
        sb.append(ansCnt).append('\n');
        for(int i=1;i<=ansCnt;i++){
            sb.append(ans[i]).append('\n');
        }

        System.out.println(sb.toString());
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
