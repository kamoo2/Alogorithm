import java.io.*;
import java.util.StringTokenizer;

public class BOJ16472 {
    // 고냥이
    // https://www.acmicpc.net/problem/16472

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N, kind;
    static String A;
    static int[] cnt;

    static void input() {
        N = sc.nextInt();
        A = sc.nextLine();
        cnt = new int[26];
    }

    static void add(char x) {  // x 라는 알파벳 추가
        cnt[x - 'a']++;
        if (cnt[x - 'a'] == 1)  // 새롭게 나타난 알파벳이라는 뜻
            kind++;
    }

    static void erase(char x) {  // x 라는 알파벳 제거
        cnt[x - 'a']--;
        if (cnt[x - 'a'] == 0)  // 인식해야 하는 알파벳에서 빠지는 순간
            kind--;
    }

    static void pro() {
        int len = A.length(), ans = 0;
        for (int R = 0, L = 0; R < len; R++) {
            // R 번째 문자를 오른쪽에 추가
            add(A.charAt(R));

            // 불가능하면, 가능할 때까지 L을 이동
            while (kind > N) {
                erase(A.charAt(L++));
            }

            // 정답 갱신
            ans = Math.max(ans, R - L + 1);
        }
        System.out.println(ans);
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
