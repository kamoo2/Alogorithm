import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1068 {
    // 트리
    // https://www.acmicpc.net/problem/1068

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,erased,root;
    static int[] leaf; // i번 노드가 root인 서브트리의 leaf노드 개수
    static ArrayList<Integer>[] child;
    static void input(){
        N = sc.nextInt();
        child = new ArrayList[N];
        leaf = new int[N];
        for(int i=0;i<N;i++) child[i] = new ArrayList<Integer>();

        for(int i=0;i<N;i++){
            int x = sc.nextInt();
            if(x == -1){
                root = i;
                continue;
            }
            child[x].add(i);
        }
        erased = sc.nextInt();
    }

    static void dfs(int x){
        // root의 자식 노드들을 root로 하는 서브트리를 탐색하면서 root가 리프 노드 일때 까지 탐색한다.
        if(child[x].isEmpty()){
            leaf[x] = 1;
            return;
        }
        for(int y : child[x]){
            dfs(y);
            leaf[x] += leaf[y];
        }
    }

    static void pro(){
        // 기존의 트리에서 erase 노드를 제거한 트리를 만들어야 한다.
        for(int i=0;i<N;i++){
            if(child[i].contains(erased)){
                child[i].remove(child[i].indexOf(erased));
            }
        }

        if(root != erased) dfs(root);

        System.out.println(leaf[root]);
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
