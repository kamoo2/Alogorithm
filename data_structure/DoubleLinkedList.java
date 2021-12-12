package data_structure;

interface LinkedList<T> {
  abstract void addNode(T data);
  abstract void printAll();
  abstract T searchFromHead(T isData);
  abstract T searchFromTail(T isData);
  abstract boolean insertToFront(T existedData, T addData);
}

public class DoubleLinkedList<T> implements  LinkedList<T>{
  public Node<T> head = null;
  public Node<T> tail = null;

  public class Node<T> {
      T data;
      Node<T> prev = null;
      Node<T> next = null;
      public Node(T data){
          this.data = data;
      }
  }

  public void addNode(T data){
      if(this.head == null){
           this.head = new Node<T>(data);
           this.tail = this.head;
      }else{
          Node<T> node = this.head;
          while(node.next!=null){
              // node.next가 있는 경우
              node = node.next;
          }
          Node<T> newNode = new Node<T>(data);
          node.next = newNode;
          newNode.prev = node;
          this.tail = newNode;
      }
  }

  public void printAll(){
      if(this.head != null){
          // head data 출력
          Node<T> node = this.head;
          System.out.println(node.data);
          while(node.next!=null){
              System.out.println(node.next.data);
              node = node.next;
          }
      }
  }

  public T searchFromHead(T isData){
      if(this.head == null){
          return null;
      }else{
          Node<T> node = this.head;
          while(node!=null){
              if(node.data == isData){
                  return node.data;
              }
              node = node.next;
          }
          return null;
      }
  }

  public T searchFromTail(T isData){
      if(this.head == null){
          return null;
      }else{
          Node<T> node = this.tail;
          while(node!=null){
              if(node.data == isData){
                  return node.data;
              }
              node = node.prev;
          }
          return null;
      }

  }

  public boolean insertToFront(T existedData,T addData){
      if(this.head == null) {
          this.head = new Node<T>(addData);
          this.tail = this.head;
          return true;
      }else if (this.head.data == existedData){
          Node<T> newNode = new Node<T>(addData);
          newNode.next = this.head;
          this.head.prev = newNode;
          this.head = newNode;
          return true;
      }else{
          Node<T> node = this.head;
          while(node!=null){
              if(node.data == existedData){
                  Node<T> nodePrev = node.prev;
                  Node<T> newNode = new Node<T>(addData);
                  nodePrev.next = newNode;
                  newNode.prev= nodePrev;
                  newNode.next = node;
                  node.prev = newNode;
                  return true;
              }
              node = node.next;
          }
          return false;
      }
  }

  public static void main(String[] args) {
      DoubleLinkedList<Integer> MyLinkedList = new DoubleLinkedList<Integer>();

      MyLinkedList.addNode(1);
      MyLinkedList.addNode(2);
      MyLinkedList.addNode(3);
      MyLinkedList.addNode(4);
      MyLinkedList.addNode(5);
      MyLinkedList.printAll();
      System.out.println("----------------");

      MyLinkedList.insertToFront(3, 2);
      MyLinkedList.printAll();
      System.out.println("----------------");

      MyLinkedList.insertToFront(6, 2);
      MyLinkedList.insertToFront(1, 0);
      MyLinkedList.printAll();
      System.out.println("----------------");

      MyLinkedList.addNode(6);
      MyLinkedList.printAll();
  }
}

