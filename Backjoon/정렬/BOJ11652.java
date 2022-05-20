import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11652 {
    static StringBuilder sb = new StringBuilder();

    static int N;
    static long[] cards;

    static void input(){
        FastReader sc = new FastReader();
        N = sc.nextInt();
        cards = new long[N];
        for(int i=0;i<N;i++){
            cards[i] = sc.nextLong();
        }
    }

    public static void solution(){
        long mode = cards[0];
        int modeCount = 1;
        int currentCount = 1;

        // TODO
        // for문으로 정렬된 배열을 순회하면서 이전 인덱스 값과 일치하면 currentCount++ , 이 currentCount가 modeCount보다 큰 순간이 온다면 modeCount를 currentCount로 바꿔주고
        // mode를 변경
        for(int i=1;i<cards.length;i++){
            if(cards[i-1] == cards[i]){
                currentCount++;

            }else{
                currentCount = 1;
            }
            if(modeCount < currentCount){
                modeCount = currentCount;
                mode = cards[i];
            }
        }

        sb.append(mode);
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        input();
        Arrays.sort(cards);
        solution();
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
