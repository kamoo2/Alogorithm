import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2751 {
    // 수 정렬하기 2
    // https://www.acmicpc.net/problem/2751
    // N의 개수가 백만개 이므로 Arrays.sort()는 Primitive 원소를 정렬하는 Dual-Pivot Quick Sort
    // 최악의 경우 O(N^2)의 시간복잡도를 가지므로 만약 저격 데이터를 가지고 있다면 시간 초과 발생
    // 첫번째 방법은 Collections.sort()사용하는 것
    // 이것은 TimSort이다. Tim Sort는 합병 정렬과 삽입 정렬을 합친 정렬 방법이다.
    // 합병 정렬은 최선,최악 모두 O(NlogN)을 보장하고, 삽입 정렬은 최선 O(N) 최악 O(N^2)이다.
    // TimSort는 합병 정렬의 최악과 삽입 정렬의 최선을 합친 정렬이라고 볼 수 있다.
    // 때문에 시간복잡도가 O(N) ~ O(NlogN)을 보장하는 장점이 있다.
    // List 계열의 자료구조를 사용해 데이터를 담아주자.
    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N; // 1 <= N <= 1000000
    static ArrayList<Integer> nums;
    static void input(){
        N = sc.nextInt();
        nums = new ArrayList<Integer>();
        for(int i=1;i<=N;i++){
            nums.add(sc.nextInt());
        }
    }

    static void pro(){
        Collections.sort(nums);
        for(int i=0;i<N;i++){
            if(i == 0 || nums.get(i) != nums.get(i-1)){
                sb.append(nums.get(i)).append('\n');
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
