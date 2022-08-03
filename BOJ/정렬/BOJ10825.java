import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10825 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Elem[] a;
    static void input(){
        FastReader sc = new FastReader();
        N = sc.nextInt();
        a = new Elem[N];
        for(int i=0;i<N;i++){
            a[i] = new Elem();
            a[i].name = sc.next();
            a[i].kor = sc.nextInt();
            a[i].eng = sc.nextInt();
            a[i].math = sc.nextInt();
        }
    }

    static void pro(){
        // 기준 통해 정렬하기
        Arrays.sort(a);

        // 출력
        for(int i=0;i<a.length;i++){
            sb.append(a[i].name).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class Elem implements Comparable<Elem>{
        public String name;
        public Integer kor,eng,math;

        @Override
        public int compareTo(Elem other){
            // 국어 점수 내림차순
            if(this.kor != other.kor) return other.kor - this.kor;
            // 영어 점수 오름차순
            if(this.eng != other.eng) return this.eng - other.eng;
            // 수학 점수 내림차순
            if(this.math != other.math) return other.math - this.math;
            // 이름 사전 순으로 오름차순
            return this.name.compareTo(other.name);
        }
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
