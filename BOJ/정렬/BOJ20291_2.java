import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ20291_2 {
    // 파일 정리
    // https://www.acmicpc.net/problem/20291


    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N;
    static String[] words;
    static void input(){
        N = sc.nextInt();
        words = new String[N+1];
        for(int i=1;i<=N;i++){
            words[i] = sc.nextLine().split("\\.")[1];
        }
    }

    static void pro(){
        Arrays.sort(words,1,N+1);
        for(int i=1;i<=N;){
            int cnt = 1;
            int j = i+1;
            for(;j<=N;j++){
                if(words[i].equals(words[j])) cnt++;
                else break;
            }
            sb.append(words[i]).append(' ').append(cnt).append('\n');
            // j-1번째 까지는 이미 탐색한 부분이기 때문에 i를 j로 변경
            i = j;
        }
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb);
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
