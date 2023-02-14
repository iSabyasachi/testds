package testds.imp;
class ListNode<E>{
    E ele;
    ListNode<E> next;
    public ListNode(E ele){
        this.ele = ele;
    }
}
public class RemoveNthNodeLinkedList{
    public static <E> void print(ListNode<E> curr){
        if(curr == null) return;
        System.out.print(curr.ele+" ");

        print(curr.next);
    }
    public static void main(String[] args){
        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        head.next.next.next = new ListNode<>(4);
        head.next.next.next.next = new ListNode<>(5);
        print(head);
        RemoveNthNodeLinkedList obj = new RemoveNthNodeLinkedList();
        int n = 2;
        head = obj.removeNthFromEnd(head, n);
        System.out.println("After removal!!!");
        print(head);
    }
    /**
    Time Complexity : O(N)
    Space Complexity : O(1)
     */
    public ListNode<Integer> removeNthFromEnd(ListNode<Integer> head, int n) {
        // Find the length of the linkedlist
        int len = length(head);
        //Base Conditions
        if(n > len) return null;
        else if(n == len){
            head = head.next;
            return head;
        }
        // Iterare the list till we reach len - n node.        
        // Remove len - n + 1 node
        ListNode<Integer> curr = head;
        int i = 1;
        while(i < (len - n)){
            curr = curr.next;
            i++;
        }
        if(curr != null && curr.next != null){
            curr.next = curr.next.next;
            return head;
        } 

        return null;
    }    
    public <E> int length(ListNode<E> head){
        if(head == null) return 0;

        return 1 + length(head.next);
    }
}