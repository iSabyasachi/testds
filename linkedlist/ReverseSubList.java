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
   
    public void reverse(int from, int to){
        Node<E> head = reverseSubList(this.head, from, to);
        print();
    }
    // 1(LNF) -> 2 (FNS) -> 3 -> 4 -> 5 {2, 4}
    // 1 -> 4 -> 3 -> 2 -> 5
    // 1 -> 2 <- 3 <- 4 -> 5
    // 1 -> 2 -> 3 = 1 <- 2 <- 3
    private Node<E> reverseSubList(Node<E> head, int from, int to){
        Node<E> curr = head;
        int i = 1;
        while(curr != null && i < from){
            curr = curr.next;
        }
        Node<E> lastNodeOfFirstPart = curr;
        Node<E> firstNodeOfSecondPart = curr.next;
        int index = (to - from) + 1;

        Node<E> prev = null;       
        Node<E> next = null;
        curr = curr.next;
        while(curr != null && index > 0){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            index--;
        }
        firstNodeOfSecondPart.next = next;
        lastNodeOfFirstPart.next = prev; 

        return head;
    }
}
public class ReverseSubList{
    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.print();
        
        list.reverse(1, 3);
        
    }
}