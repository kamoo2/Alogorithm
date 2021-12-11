import java.util.ArrayList;

public class Stack<T> {
    private ArrayList<T> stack_list;

    public Stack(Integer num){
        this.stack_list = new ArrayList<T>(num);
    }

    void push (T item){
        stack_list.add(item);
    }

    T pop (){
        if(stack_list.isEmpty()){
            return null;
        }
        return stack_list.remove(stack_list.size()-1);
    }

    public static void main(String[] args) {
        Stack<Integer> ms = new Stack<Integer>(5);
        ms.push(1);
        ms.push(2);
        ms.push(3);
        ms.push(4);
        System.out.println(ms.pop());// 4
        System.out.println(ms.pop());// 3
        System.out.println(ms.pop());// 2
        System.out.println(ms.pop());// 1
        System.out.println(ms.pop());// null
        System.out.println(ms.pop());// null
    }
}