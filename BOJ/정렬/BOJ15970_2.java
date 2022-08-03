import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 화살표 그리기
// https://www.acmicpc.net/problem/15970
// 각 기능을 하는 코드들을 함수화해서 더 깔끔하고 가독성 좋은 코드로 변경 
public class BOJ15970_2 {
    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();

    static void input(){
        N = sc.nextInt();
        a = new ArrayList[N+1];
        for(int color=1;color<=N;color++){
            a[color] = new ArrayList<Integer>();
        }

        for(int i=0;i<N;i++){
            int pos,color;
            pos = sc.nextInt();
            color = sc.nextInt();

            // TODO : color별로 각 점들을 해당 인덱스에 넣어준다.
            a[color].add(pos);
        }


    }
    static int N;
    static ArrayList<Integer>[] a;

    static int toLeft(int color,int idx){
        if(idx == 0) return Integer.MAX_VALUE;
        return a[color].get(idx) - a[color].get(idx-1);
    }


    static int toRight(int color,int idx){
        if(idx == a[color].size() -1) return Integer.MAX_VALUE;
        return a[color].get(idx+1) - a[color].get(idx);
    }

    static void pro(){
        // 각 컬러별로 정렬된 pos값을 가지고 있다.
        // 이 pos값들을 이용해서 총 거리를 구하자
        // CASE 1 : pos가 첫번째인 경우 -> 오른쪽 pos와의 거리를 측정
        // CASE 2 : pos가 마지막인 경우 -> 왼쪽 pos와의 거리 측정
        // CASE 3 : 그 외인 경우 -> 양쪽 pos와 거리 측정 후 짧은 거리 선택
        int distance =0;

        for(int color=1;color<=N;color++){
            Collections.sort(a[color]);
        }

        for(int color =1;color<=N;color++){
            for(int pos=0;pos<a[color].size();pos++){
                int left = toLeft(color,pos);
                int right = toRight(color,pos);
                distance += Math.min(left,right);
            }
        }
        System.out.println(distance);
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


