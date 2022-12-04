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
    
    public E remove(int index){
        return remove(0, index, head);
    }
    // 1 -> 2 -> 3[R] -> 4
    // 1 -> 2 -> 4
    private E remove(int currIndex, int index, Node<E> curr){
        if(curr == null || curr.next == null) return null;

        if(currIndex + 1 == index){
            Node<E> nodeToBeDeleted = curr.next;
            E deletedElement = nodeToBeDeleted.ele;
            curr.next = curr.next.next;

            nodeToBeDeleted = null;
            return deletedElement;
        }
        return remove(currIndex + 1, index, curr.next);
    }
}
public class RemoveTargetByIndex{
    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.print();
        Integer valInt = list.remove(2);        
        System.out.println(valInt+" After removal");
        list.print();

    }
}