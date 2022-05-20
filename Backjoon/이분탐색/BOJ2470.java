import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {
    // 두 용액
    // https://www.acmicpc.net/problem/2470

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();

    static void input(){
        N = sc.nextInt();
        A = new int[N+1];
        for(int i=1;i<=N;i++){
            A[i] = sc.nextInt();
        }
    }

    static int N;
    static int[] A;

    static int lower_bound(int A[],int L,int R,int X){
        // A[L...R]에서 X 이상의 수 중 가장 왼쪽 인덱스에 있는 인덱스를 return 하는 함수
        // X이상의 수가 없다면 R+1을 리턴
        int result = R+1;
        while(L <= R){
            int mid = (L+R)/2;
            if(A[mid] >=  X){
                result = mid;
                R = mid-1;
            }else {
                L = mid+1;
            }
        }
        return result;
    }

    static void pro(){
        // A 배열을 오름차순 정렬
        Arrays.sort(A,1,N+1);

        int best_sum = Integer.MAX_VALUE;
        int v1=0,v2=0;
        for(int left = 1;left<=N-1;left++){
            // A[left] 용액을 사용할 것이고 -A[left]와 가장 가까운 값을 자신의 오른쪽에서 찾아라
            int result = lower_bound(A,left+1,N,-A[left]);

            if(left  < result-1 && Math.abs(A[result - 1] + A[left]) < best_sum){
                best_sum = Math.abs(A[result-1] + A[left]);
                v1 = A[left];
                v2 = A[result-1];
            }

            if(result <= N &&  Math.abs(A[result] + A[left]) < best_sum){
                best_sum = Math.abs(A[result] + A[left]);
                v1 = A[left];
                v2 = A[result];
            }
        }

        sb.append(v1).append(' ').append(v2);
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
