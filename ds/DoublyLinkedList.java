package testds;
class LinkedList<E>{
    Node<E> head;
    Node<E> tail;
    class Node<E>{
        E ele;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E ele, Node<E> next){
            this.prev = prev;
            this.ele = ele;
            this.next = next;
        }
    }
    public void add(E e){
        Node<E> t = tail;
        tail = new Node<>(t, e, null);
        if(head == null){
            head = tail;
        }else{
            t.next = tail;
        }
    }
    public void printNext(){
        Node<E> curr = this.head;
        String res = printNext(curr);
        System.out.println(res);
    }
    private String printNext(Node<E> head){
        if(head == null) return "";
        
        return head.ele +" "+printNext(head.next);
    }
    public void printPrev(){
        String res = printPrev(this.tail);
        System.out.println(res);
    }
    private String printPrev(Node<E> tail){
        if(tail == null) return "";

        return tail.ele +" "+ printPrev(tail.prev);
    }
}
public class DoublyLinkedList<E>{
    public static void main(String[] args){
        System.out.println("Doubly LinkedList");
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.printNext();
        //System.out.println("");
        list.printPrev();
    }
}