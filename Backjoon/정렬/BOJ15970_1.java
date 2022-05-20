import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ15970 {
    static StringBuilder sb = new StringBuilder();

    static void input(){
        FastReader sc = new FastReader();
        N = sc.nextInt();
        points = new Elem[N];
        for(int i=0;i<N;i++){
            points[i] = new Elem();
            points[i].pos = sc.nextInt();
            points[i].color = sc.nextInt();
        }
    }

    static int N; // 점의 개수
    static Elem[] points;

    static class Elem  {
        public int pos;
        public int color;
    }

   static Comparator<Elem> posComparator = new Comparator<Elem>() {
        @Override
        public int compare(Elem o1, Elem o2) {
            return o1.pos - o2.pos;
        }
    };

    static Comparator<Elem> colorComparator = new Comparator<Elem>() {
        @Override
        public int compare(Elem o1, Elem o2) {
            return o1.color - o2.color;
        }
    };

    static void getSol(){

        Arrays.sort(points,posComparator);
        Arrays.sort(points,colorComparator);
        int sum =0;

        for(int i=0;i<N;i++){
            if(i == 0){
                sum+= points[i+1].pos - points[i].pos;
                continue;
            }
            if(i == N-1 || points[i].color != points[i+1].color ){
                sum += points[i].pos - points[i-1].pos;
                continue;
            }
            if(points[i].color != points[i-1].color){
                sum+= points[i+1].pos - points[i].pos;
                continue;
            }
           sum += Math.min(points[i].pos - points[i-1].pos,points[i+1].pos - points[i].pos);
        }
        System.out.println(sum);
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


