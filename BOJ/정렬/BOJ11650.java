import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11650 {
    // 좌표 정렬하기
    // https://www.acmicpc.net/problem/11650

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();

    static class Elem implements Comparable<Elem>{
        public int x;
        public int y;
        public Elem(int x,int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Elem e){
            if(this.x != e.x) return this.x - e.x;
            else return this.y - e.y;
        }
    }
    static int N;
    static Elem[] elems;
    static void input(){
        N = sc.nextInt();
        elems = new Elem[N+1];
        for(int i=1;i<=N;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            elems[i] = new Elem(x,y);
        }
    }

    static void pro(){
        Arrays.sort(elems,1,N+1);
        for(int i=1;i<=N;i++){
            sb.append(elems[i].x).append(' ').append(elems[i].y).append('\n');
        }

        System.out.println(sb);
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
