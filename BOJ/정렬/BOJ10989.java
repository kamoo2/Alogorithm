import java.io.*;
import java.util.StringTokenizer;

public class BOJ10989 {
    // 수 정렬하기 3
    // https://www.acmicpc.net/problem/10989
    // 시간 제한이 3초인데 데이터 수가 천만개 이므로 Arrays.sort()를 사용했을 때 최악의 경우 O(N^2)이고 평균 O(NlogN)이므로 간당간당하다.
    // 그래서 카운팅 정렬 방법 선택
    // 카운팅 정렬의 시간복잡도는 O(N+K)이지만 O(N)이라고 생각하면 된다.
    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N;
    static int[] cnt;
    static void input(){
        N = sc.nextInt();
        cnt = new int[10001];
        for(int i=1;i<=N;i++){
            cnt[sc.nextInt()]++;
        }
    }

    static void pro(){
        for(int i=1;i<=10000;i++){
            while(cnt[i] > 0){
                sb.append(i).append('\n');
                cnt[i]--;
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
