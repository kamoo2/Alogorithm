package Queen;

import java.io.*;
import java.util.StringTokenizer;

// N-Queen
// https://www.acmicpc.net/problem/9663
public class BOJ9663_1 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static Integer N,count =0;
    static Integer[] cols;

    static void input(){
        N = scan.nextInt();
        cols = new Integer[N+1];
    }

    static boolean attackable(int row1,int col1,int row2,int col2){
        if(col1 == col2){
            return true;
        }

        if(row1-col1 == row2-col2){
            return true;
        }

        if(row1+col1 == row2+col2){
            return true;
        }

        return false;
    }

    static boolean validate_check(){
        for(int i=1;i<=N;i++){
            // (i,cols[i])
            for(int j=1;j<i;j++){
                if(attackable(i,cols[i],j,cols[j])){
                    return false;
                }
            }
        }
        return true;
    }

    static void rec_func(int row){
        // 각 행(row)마다 한개의 Queen만 들어갈 수 있기 때문에 퀸을 다 넣은 후에 해당 배열을 판단해 서로 공격하지 않는 위치에 있는지 확인해야 한다.
        if(row == N + 1){
            // 모든 행에 퀸을 한개씩 넣은 경우
            if(validate_check()){
                count++;
            }
        }else{
            // cols[i]는 i번째 row의 몇 번째 col에 퀸이 있는지를 나타내는 배열이다.
            for(int i=1;i<=N;i++){
                cols[row] = i;
                rec_func(row+1);
                cols[row] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(count);
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
            while(st == null || !st.hasMoreElements()){
                try {
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
