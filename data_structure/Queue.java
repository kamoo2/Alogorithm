import java.util.ArrayList;

public class Queue<T> {
    private ArrayList<T> queueList;
    public Queue(){
        this.queueList = new ArrayList<T>();
    }
    public void add(T value){
        this.queueList.add(value);
    }

    public T poll(){
        if(this.queueList.isEmpty()){
            return null;
        }
        T first = this.queueList.remove(0);
        return first;
    }

    public boolean isEmpty() {
        if(this.queueList.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public T get(Integer index){
        return this.queueList.get(index);
    }
}

// Main.java

public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();
        System.out.println(queue.poll()); // null
        System.out.println(queue.isEmpty()); // true
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue.get(0)); // 1
        queue.poll();
        System.out.println(queue.get(0)); // 2
}
