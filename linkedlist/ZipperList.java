package testds.linkedlist;
class LinkedList<E>{
    private static class Node<E>{
        E ele;
        Node<E> next;
        private Node(){}
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
        System.out.println("Result "+res); 
    }
    private String print(Node<E> head){
        if(head == null) return "";

        return head.ele+" -> "+print(head.next);
    }
    // A -> B -> C
    // Q -> R -> S
    public void zipperList(LinkedList<E> firstList, LinkedList<E> secondList){
        Node<E> head = zipperListRec(firstList.head, secondList.head);
        String res = print(head);
        System.out.println("Res Rec "+res);
        /*head = new Node<>();
        Node<E> headRes = head;
        zipperListRec(headRes, firstList.head, secondList.head);
        */
    }
    private Node<E> zipperListRec(Node<E> headFirst, Node<E> headSecond){
         if(headFirst == null && headSecond == null) return null;
         if(headFirst == null) return headSecond;
         if(headSecond == null) return headFirst;

         Node<E> nextFirst = headFirst.next;
         Node<E> nextSecond = headSecond.next;

         headFirst.next = headSecond;
         headSecond.next = zipperListRec(nextFirst, nextSecond);

        return headFirst;
    }
    private void zipperListRecTemp(Node<E> tail, Node<E> headFirst, Node<E> headSecond){
        if(headFirst == null && headSecond == null) return;
        if(headFirst == null && headSecond != null) {
            tail.next = headSecond;
            headSecond = null;
            return;
        }
        if(headFirst != null && headSecond == null) {
            tail.next = headFirst;
            headFirst = null;
            return;
        }

        tail.next = headFirst;
        headFirst = headFirst.next;
        tail = tail.next;

        tail.next = headSecond;
        headSecond = headSecond.next;
        tail = tail.next;

        zipperListRecTemp(tail, headFirst, headSecond);
    }
    private void zipperList(Node<E> headFirst, Node<E> headSecond){        
        Node<E> headRes = null;
        Node<E> tail = null;
        int i = 1;     
        while(headFirst != null && headSecond != null){
            Node<E> inputHead = i % 2 != 0 ? headFirst : headSecond;

            Node<E> t = tail;

            tail = inputHead;

            if(headRes == null){
                headRes = tail;
            }else{
                t.next = tail;
            }
            
            if(i % 2 != 0) headFirst = headFirst.next;
            else headSecond = headSecond.next;

            i++;
        }
        if(headFirst == null && headSecond != null) tail.next = headSecond;
        else if(headFirst != null && headSecond == null) tail.next = headFirst;

        String res = print(headRes);
        System.out.println("Res "+print(headRes));
    }
    private void zipperListSim(Node<E> headFirst, Node<E> headSecond){  
        Node<E> currFirst = headFirst;
        Node<E> currSecond = headSecond;

        Node<E> head = currFirst;
        currFirst = currFirst.next;
        Node<E> tail = head;
        int i = 0;
        while(currSecond != null && currSecond != null){
            if(i % 2 != 0){
                tail.next = currFirst;
                currFirst = currFirst.next;
            }else{
                tail.next = currSecond;
                currSecond = currSecond.next;
            }
            tail = tail.next;
            i++;
        }
        if(currFirst != null) tail.next = currFirst;
        if(currSecond != null) tail.next = currSecond;

        String res = print(head);
        System.out.println("Res "+res);
    }
}
public class ZipperList{
    public static void main(String[] args){
        LinkedList<Character> firstList = new LinkedList<>();
        firstList.add('A');
        firstList.add('B');
        firstList.add('C');
        firstList.add('D');
        firstList.add('E');
        firstList.add('F');
        
        LinkedList<Character> secondList = new LinkedList<>();
        secondList.add('Q');
        secondList.add('R');
        

        LinkedList<Character> resList = new LinkedList<>();
        resList.zipperList(firstList, secondList);
    }
}