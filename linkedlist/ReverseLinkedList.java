package testds.linkedlist;
class LinkedList<E>{
    private static class Node<E>{
        E ele;
        Node<E> next;
        private Node(E ele){
            this.ele = ele;
            this.next = null;
        }
    }
    Node<E> head;
    Node<E> tail;

    public void add(E ele){
        Node<E> t = tail;
        tail = new Node<>(ele);
        if(head == null){
            head = tail;
        }else{
            t.next = tail;
        }
    }
    public void print(){
        String res = print(head);
        System.out.println(res);
    }    
    private String print(Node<E> curr){
        if(curr == null) return "";

        return curr.ele +" "+print(curr.next);
    }
    public E getFirst(){
        return head != null ? head.ele : null;
    }
    public void reverse(){
        //Node<E> curr= reverse(this.head);
        Node<E> curr= reverse(this.head, null);
        System.out.println(print(curr));
    }
    // 1 2 3 4
    public Node<E> reverse(Node<E> curr){
        Node<E> next = null;
        Node<E> prev = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    private Node<E> reverse(Node<E> head, Node<E> prev){
        if(head == null) return prev;

        Node<E> next = head.next;
        head.next = prev;

        return reverse(next, head);
    }
   
}
public class ReverseLinkedList{
    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.print();
        
        list.reverse();
        
    }
}