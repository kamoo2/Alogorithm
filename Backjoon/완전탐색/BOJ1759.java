import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 {
    static StringBuilder sb = new StringBuilder();
    static int L,C;
    static char[] chars;
    static int[] password;
    static void input() {
        FastReader sc = new FastReader();
        L = sc.nextInt();
        C = sc.nextInt();
        chars = new char[C+1];
        password=  new int[L+1];
        String[] token = sc.nextLine().split(" ");
        for(int i=1;i<=C;i++){
            chars[i] = token[i-1].charAt(0);
        }
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c =='i' || c == 'o' || c == 'u';
    }

   static void rec_func(int k){
        if(k == L+1){
            int vowel = 0;
            int constant = 0;

            for(int i=1;i<=L;i++){
                if(isVowel(chars[password[i]])){
                    vowel++;
                }else{
                    constant++;
                }
            }

            if(vowel>=1 && constant >=2) {
                for (int i = 1; i <= L; i++) {
                    sb.append(chars[password[i]]);
                }
                sb.append('\n');
            }
        }else{
            for(int cand = password[k-1] +1;cand<=C;cand++){
                password[k] = cand;
                rec_func(k+1);
                password[k] =0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        Arrays.sort(chars);
        rec_func(1);

        System.out.println(sb.toString());
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
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
