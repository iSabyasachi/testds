package testds.imp;
import java.util.*;

class ListNode<E>{
    E ele;
    ListNode<E> next;
    public ListNode(E ele){
        this.ele = ele;
    }
}
public class LinkedListCycle{
    /**
    Time Complexity : O(N)
    Space Complexity : O(1)
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) return true;
        }
        return false;
    }
    /**
    Time Complexity : O(N)
    SPace Complexity : O(N)
     */
    public boolean hasCycleRec(ListNode head) {
        return head != null && head.next != null ? hasCycleRec(head.next, head.next.next) : true;
    }
    public boolean hasCycleRec(ListNode slow, ListNode fast) {
        if(slow == fast) return true;
        if(fast == null || fast.next == null) return false;

        return hasCycleRec(slow.next, fast.next.next);
    }
    /**
    Time Complexity : O(N)
    Space Complexity : O(N) to store data in HashSet
     */
    public <E> boolean hasCycleUsingHashTable(ListNode<E> head) {
        Set<E> visited = new HashSet<>();
        while(head != null){
            if(visited.contains(head.ele)) return true;
            visited.add(head.ele);
            head = head.next;
        }
        return false;
    }
    public static void main(String[] args){
        LinkedListCycle obj = new LinkedListCycle();

        ListNode<Integer> head = new ListNode<>(3);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(0);
        head.next.next.next = new ListNode<>(-4);
        head.next.next.next.next = head.next;

        //System.out.println(obj.hasCycle(head));
        System.out.println(obj.hasCycleUsingHashTable(head));
    }
}