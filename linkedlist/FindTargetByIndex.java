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
    
    public E get(int index){
        //return getRec(0, index, head);
        return get(index, head);
    }
    private E getRec(int currIndex, int resIndex, Node<E> curr){
        if(curr == null) return null;
        else if(currIndex == resIndex) return curr.ele; 
        
        return getRec(currIndex + 1, resIndex, curr.next);
    }
    private E get(int inpIndex, Node<E> curr){
        int i = 0;
        while(i <= inpIndex && curr != null){
            if(i == inpIndex) return curr.ele;
            curr = curr.next;
            i++;
        }
        return null;
    }
}
public class FindTargetByIndex{
    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.print();
        int val = list.get(2) != null ? list.get(2) : 0;
        System.out.println(val);

    }
}