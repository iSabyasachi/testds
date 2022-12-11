package testds.imp;
class Node<E>{
    E ele;
    Node<E> next;
    public Node(E ele){
        this.ele = ele;
    }
}
public class ReverseLinkedList{
    /**
    Time Complexity : O(N)
    Space Complexity : O(1)
     */
    public <E> Node<E> reverse(Node<E> head){
        Node<E> prev = null;
        Node<E> curr = head;
        while(curr != null){
            Node<E> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    /**
    Time Complexity : O(N)
    Space Complexity : O(N) to maintain the stack
     */
    public <E> Node<E> reverseRec(Node<E> head){
        return reverseRec(head, null);
    }
    private <E> Node<E> reverseRec(Node<E> head, Node<E> prev){
        if(head == null) return prev;

        Node<E> next = head.next;
        head.next = prev;

        return reverseRec(next, head);
    }
    public <E> void print(Node<E> head){
        if(head == null) return;

        System.out.print(head.ele+"->");
        print(head.next);
    }  
    public static void main(String[] args){
        ReverseLinkedList obj = new ReverseLinkedList();

        Node<Integer> head = new Node<>(1);
        head.next = new Node<>(2);
        head.next.next = new Node<>(3);
        head.next.next.next = new Node<>(4);
        head.next.next.next.next = new Node<>(5);

        obj.print(head);
        System.out.println("");
        System.out.println("Reverse --> ");
        //head = obj.reverse(head);
        head = obj.reverseRec(head);
        obj.print(head);
    }

}