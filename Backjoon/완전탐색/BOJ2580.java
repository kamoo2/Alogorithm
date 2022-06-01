import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2580 {
    // 스도쿠
    // https://www.acmicpc.net/problem/2580

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int[][] map;
    static ArrayList<Pos> zeros;
    static class Pos {
        int x;
        int y;
        public Pos(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    static void input(){
        map = new int[9][9];
        zeros = new ArrayList<Pos>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                map[i][j] = sc.nextInt();
            }
        }
    }

    static void dfs(int depth){
        if(depth == zeros.size()){
            // 스도쿠 완성
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    sb.append(map[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            System.exit(0);
        }else{
            // 1 ~ 9 까지의 숫자 중 유효한 숫자 넣어주기
            for(int i=1;i<=9;i++){
                if(isChecked(depth,i)){
                    // 유효한 숫자 찾았다 !!
                    map[zeros.get(depth).x][zeros.get(depth).y] = i;
                    dfs(depth + 1);
                    map[zeros.get(depth).x][zeros.get(depth).y] = 0;
                }
            }
        }
    }

    static boolean isChecked(int idx,int value){
        // 행 고정 , 열 순회 비교
        for(int i=0;i<9;i++){
            if(map[zeros.get(idx).x][i] == value)return false;
        }

        // 열 고정, 행 순회 비교
        for(int i=0;i<9;i++){
            if(map[i][zeros.get(idx).y] == value) return false;
        }

        // 3 x 3을 돌면서 비교
        int nRow = (zeros.get(idx).x /3) * 3;
        int nCol = (zeros.get(idx).y/3) * 3;

        for(int i =nRow;i<nRow + 3;i++){
            for(int j=nCol;j<nCol + 3;j++){
                if(map[i][j] == value) return false;
            }
        }
        return true;


    }

    static void pro(){
        // 0인 좌표를 ArrayList에 추가
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(map[i][j] == 0){
                    zeros.add(new Pos(i,j));
                }
            }
        }

        dfs(0);
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
