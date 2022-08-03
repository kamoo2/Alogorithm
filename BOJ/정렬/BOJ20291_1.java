import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ20291 {
    // 파일 정리
    // https://www.acmicpc.net/problem/20291

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N;
    static String[] files;
    static void input(){
        N =sc.nextInt();
        files = new String[N+1];
        for(int i=1;i<=N;i++){
            files[i] = sc.nextLine().split("\\.")[1];
        }
    }

    static Comparator<String> MyComparater = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    };

    static void pro(){
        HashMap<String,Integer> hm = new HashMap<String,Integer>();
        Arrays.sort(files,1,N+1,MyComparater);
        String last=files[1];
        int cnt = 1;
        for(int i=2;i<=N;i++){
            if(last.equals(files[i])){
                cnt++;
                if(i == N){
                    sb.append(last).append(' ').append(cnt).append('\n');
                }
            }else{
                sb.append(last).append(' ').append(cnt).append('\n');
                last = files[i];
                cnt =1;
                if(i == N){
                    sb.append(last).append(' ').append(cnt).append('\n');
                }
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
