import java.io.*;
import java.util.StringTokenizer;

public class BOJ9663_2 {
    // N-Queen
    // https://www.acmicpc.net/problem/9663
    // 이전 코드는 처음부터 끝까지 모든 경우의 수를 찾고 비교하기 때문에 시간초과 발생
    // 그래서 배치 다하고 조건에 맞는지 검사하지 말고
    // 각 row에 퀸을 배치할 때 공격 가능한지 체크하고 공격 불가능 한 곳에만 퀸을 배치

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,ans =0;
    static int[] cols;
    static void input(){
        N = sc.nextInt();
        cols = new int[N+1];
    }
    static boolean attackable(int cur_row,int cur_col,int row,int col){
        if(cur_col == col){
            return true;
        }

        if(cur_row-cur_col == row - col){
            return true;
        }

        if(cur_row+cur_col == row + col){
            return true;
        }

        return false;
    }
    static void rec_func(int row){
        if(row == N+1){
            // 모두 배치 완료 했으면 문제없이 배치 한것이므로 경우의수 증가
            ans++;
        }else{
            for(int c = 1;c<=N;c++){
                boolean possible = true;
                for(int i = 1;i<=row-1;i++){
                    // 현재 row 이전 row들을 돌면서 공격 가능한 자리 인지 체크
                    if(attackable(row,c,i,cols[i])){
                        possible = false;
                    }
                }
                if(possible){
                    cols[row] = c;
                    rec_func(row+1);
                    cols[row] = 0;
                }
            }
        }
    }

    static void pro(){
        rec_func(1);
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
