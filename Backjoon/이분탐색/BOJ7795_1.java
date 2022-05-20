import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7795_1 {
    // 먹을 것인가 먹힐 것인가
    // https://www.acmicpc.net/problem/7795
    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N+1];
        B = new int[M+1];
        for(int i=1;i<=N;i++) A[i] = sc.nextInt();
        for(int i=1;i<=M;i++) B[i] = sc.nextInt();
    }

    // A의 개수 N
    // B의 개수 M
    static int N,M,T;
    static int[] A,B;

    static void pro(){
        // L,R,Result,M 정의 하기
        int left,right,mid,result,searchNum,ans = 0;
        // B를 오름차순 정렬
        Arrays.sort(B);
        // result : searchNum이하인 숫자 찾기

        for(int i=1;i<=N;i++){
            left = 1;
            right = B.length-1;
            mid = (left+right)/2;
            result = 0;
            for(int j=1;j<=M;j++){
                // CASE 1 : left > right인 경우에는 더이상 탐색할 아이템이 없기 때문에 break
                if(left > right) break;
                // CASE 2 : A[i] < B[mid] 이면 왼쪽 배열 선택 -> right = right -1;
                if(A[i] <= B[mid]){
                    right = mid-1;
                }else{
                    left = mid +1;
                    result = mid;
                }
                mid = (left+right)/2;
            }
            ans += result;
        }

        System.out.println(ans);
    }
    public static void main(String[] args) {
        T = sc.nextInt();
        int runTime = 0;
        do{
            runTime++;
            input();
            pro();
        }while(runTime != T);
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
