import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1181 {
    // 단어 정렬
    // https://www.acmicpc.net/problem/1181

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N;
    static String[] words;
    static void input(){
        N =sc.nextInt();
        words = new String[N+1];
        for(int i=1;i<=N;i++){
            words[i] = sc.nextLine();
        }
    }

    static Comparator<String> wordComparator = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            if(o1.length() == o2.length()) return o1.compareTo(o2);
            else return o1.length() - o2.length();
        }
    };

    static void pro(){
        Arrays.sort(words,1,N+1, wordComparator);
//        String last = "";
        for(int i=1;i<=N;i++){
//            if(last.equals(words[i]))continue;
//            last = words[i];
//            sb.append(words[i]).append('\n');
            if(i == 1 || !words[i].equals(words[i-1])){
                sb.append(words[i]).append('\n');
            }
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
