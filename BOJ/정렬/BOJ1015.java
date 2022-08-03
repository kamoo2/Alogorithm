import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1015 {
    static StringBuilder sb = new StringBuilder();

    static void input(){
        FastReader sc = new FastReader();
        N = sc.nextInt();
        P = new int[N];
        B = new Elem[N];
        for(int i=0;i<N;i++){
            B[i] = new Elem();
            B[i].idx = i;
            B[i].num = sc.nextInt();
        }
    }

    static int N;
    static int[] P;
    static Elem[] B;

    static class Elem implements Comparable<Elem>{
        public int num;
        public int idx;

        @Override
        public int compareTo(Elem elem){
            if(this.num != elem.num) return this.num - elem.num;
            return this.idx - elem.idx;
        }
    }

    static void getSol(){
        Arrays.sort(B);

        // 정렬된 B배열을 이용해 P배열 채우기
        for(int i=0;i<N;i++){
            P[B[i].idx] = i;
        }

        for(int i=0;i<N;i++){
            sb.append(P[i]).append(' ');
        }

        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        input();
        getSol();
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

