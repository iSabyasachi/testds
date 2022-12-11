package testds.imp;
import java.util.*;

class ListNode<E>{
    E ele;
    ListNode<E> next;
    public ListNode(){}
    public ListNode(E ele){
        this.ele = ele;
    }
}
public class MergeList{
    public static void print(ListNode<Integer> res){
        if(res == null) return;

        System.out.print(res.ele+" -> ");
        print(res.next);
    }
    /**
    Time Complexity : O(M Log M + N Log N)
    Space Complexity : O(M + N)
     */
    public ListNode<Integer> mergeTwoLists(ListNode<Integer> list1, ListNode<Integer> list2) {
       PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> Integer.compare(n1, n2));

       ListNode<Integer> res = new ListNode<>();
       ListNode<Integer> currRes = res;
       while(list1 != null){
        minHeap.offer(list1.ele);
        list1 = list1.next;
       }
       while(list2 != null){
        minHeap.offer(list2.ele);
        list2 = list2.next;
       }

       while(!minHeap.isEmpty()){
        ListNode<Integer> newNode = new ListNode<>(minHeap.poll());
        currRes.next = newNode;
        currRes = currRes.next;
       }
       return res.next;
    }
    /**
    Time Complexity : O(Min(M, N)), where M is the size of first List & N is the size of second List.
    Space Complexity : O(1)
     */
    public ListNode<Integer> mergeTwoListsItr(ListNode<Integer> list1, ListNode<Integer> list2) {
        ListNode<Integer> result = new ListNode<>();
        ListNode<Integer> curr = result;
        
        while(list1 != null && list2 != null){
            if(list1.ele < list2.ele){
                curr.next = list1;
                list1 = list1.next;
            }else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if(list1 == null && list2 != null) curr.next = list2;
        if(list1 != null && list2 == null) curr.next = list1;
        return result.next;
    }
    
     public static void main(String[] args){
        MergeList obj = new MergeList();

        ListNode<Integer> list1 = new ListNode<>(1);
        list1.next = new ListNode<>(2);
        list1.next.next = new ListNode<>(4);

        ListNode<Integer> list2 = new ListNode<>(1);
        list2.next = new ListNode<>(3);
        list2.next.next = new ListNode<>(4);

        ListNode<Integer> res = obj.mergeTwoListsRec(list1, list2);
        obj.print(res);
    }
}