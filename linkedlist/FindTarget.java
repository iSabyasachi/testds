package testds;
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
    public boolean isPresent(E e){
        return isPresent(e, this.head);
    }
    private boolean isPresentRec(E e, Node<E> head){
        if(head == null) return false;
        else if(head.ele == e) return true;

        return isPresentRec(e, head.next);
    }

    private boolean isPresent(E e, Node<E> head){
        Node<E> curr = head;
        while(curr != null){
            if(curr.ele == e) return true;
            curr = curr.next;
        }
        return false;
    }

}
public class FindTarget{
    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.isPresent(4));
        System.out.println(list.isPresent(2));
    }
}