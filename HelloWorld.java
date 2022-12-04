package testds;
import java.util.*;
import java.util.stream.*;
class LinkedList<E>{
    Node<E> head;
    Node<E> tail;
    class Node<E>{
        E ele;
        Node<E> next;
        public Node(E ele){
            this.ele = ele;
            this.next = null;
        }
    }
    public void add(E e){
        Node<E> t = tail;
        tail = new Node<>(e);
        if(head == null){
            head = tail;
        }else{
            t.next = tail;
        }
    }
    public void print(){
        String res = print(this.head);
        System.out.println(res);
    }
    private String print(Node head){
        if(head == null) return "";
        
        return head.ele+" "+print(head.next);
    }
    @Override
    public String toString(){
        return print(this.head);
    }
}
public class HelloWorld{
   
    public static void main(String[] args){
        System.out.println("Hello World");

        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.print();
	   	System.out.println(list);
		
    }
}
