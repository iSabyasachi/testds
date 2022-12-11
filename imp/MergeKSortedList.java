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
public class MergeKSortedList{
    public static void print(ListNode<Integer> res){
        if(res == null) return;

        System.out.print(res.ele+" -> ");
        print(res.next);
    }
    /**
    Time Complexity : O(N Log K), where k is the number of linked lists, there are N nodes in the final linked list.
    Space Complexity : O(N)
     */
    public ListNode<Integer> mergeKLists(ListNode<Integer>[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((l1, l2) -> Integer.compare(l1, l2));
        for(ListNode<Integer> list : lists){
            while(list != null){
                minHeap.offer(list.ele);
                list = list.next;
            }
        }
        ListNode<Integer> res = null;
        ListNode<Integer> curr = null;
        while(!minHeap.isEmpty()){
            ListNode c = curr;
            curr = new ListNode<>(minHeap.poll());
            if(res == null){
                res = curr;
            }else{
                c.next = curr;
            }
        }
        return res;
    }
    public static void main(String[] args){
        MergeKSortedList obj = new MergeKSortedList();

        ListNode<Integer> list1 = new ListNode<>(1);
        list1.next = new ListNode<>(4);
        list1.next.next = new ListNode<>(5);

        ListNode<Integer> list2 = new ListNode<>(1);
        list2.next = new ListNode<>(3);
        list2.next.next = new ListNode<>(4);

        ListNode<Integer> list3 = new ListNode<>(2);
        list3.next = new ListNode<>(6);

        ListNode[] lists = {list1, list2, list3};
        ListNode<Integer> res = obj.mergeKLists(lists);
        obj.print(res);
    }
}