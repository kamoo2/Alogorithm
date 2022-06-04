import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 {
    // 암호 만들기
    // https://www.acmicpc.net/problem/1759

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,M;
    static char[] c,code;
    static boolean[] visit;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        c = new char[M+1];
        code= new char[N+1];
        visit = new boolean[M+1];
        for(int i=1;i<=M;i++){
            c[i] = sc.next().charAt(0);
        }
    }

    static boolean isVowel(char x){
        return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u';
    }

    static void rec_func(int depth,int idx){
        if(depth == N + 1){
            // 암호 완성
            // 1. 암호가 오름차순인지 체크
            // 2. 1개 이상의 모음과 두개 이상의 자음으로 구성되어져 있는지 체크
            // 이 두가지 만족하면 해당 암호 추가
            int mo = 0;
            int ja = 0;
            for(int i=1;i<=N;i++){
                if(isVowel(code[i])){
                    mo++;
                }else{
                    ja++;
                }
            }

            if(mo >= 1 && ja >=2){
                for(int i=1;i<=N;i++){
                    sb.append(code[i]);
                }
                sb.append('\n');
            }
        }else{
            for(int i=idx;i<=M;i++){
                code[depth] = c[i];
                rec_func(depth+1,i+1);
                code[depth] = 0;
            }
        }
    }

    static void pro(){
        Arrays.sort(c);
        rec_func(1,1);
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
