package testds.ds;

import java.util.*;

public class LinkedList<E>{
    Node<E> first;
    Node<E> last;

    int size;
    class Node<E>{
        E ele;
        Node<E> prev;
        Node<E> next;

        public Node(){}
        public Node(Node<E> prev, E ele, Node<E> next){
            this.prev = prev;
            this.ele = ele;
            this.next = next;
        }
    }
    public void add(E e){
        size++;
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if(first == null)
            first = last;
        else           
            l.next = newNode;            
    }
    public void remove(){
        if(size == 0) throw new NullPointerException();
        size--;
        Node<E> l = last.prev;
        l.next = null;
        last = l;
    }
    public int size(){
        return size;
    }
    public void print(){
        Node<E> curr = first;
        while(curr != null){
            System.out.print(curr.ele+" ");
            curr = curr.next;
        }
    };
    
    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.size());
        list.print();
    }
}