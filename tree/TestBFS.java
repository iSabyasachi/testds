package testds.tree;

import java.util.*;
class Node<E>{
    E ele;
    Node<E> left;
    Node<E> right;

    public Node(E ele){
        this.ele = ele;
        this.left = null;
        this.right = null;
    }
    
}
public class TestBFS{    
    public <E> List<E> findBFSValues(Node<E> root){
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        List<E> result = new ArrayList<>();
        while(!queue.isEmpty()){
            Node<E> curr = queue.poll();
            result.add(curr.ele);
            if(curr.left != null) queue.offer(curr.left);
            if(curr.right != null) queue.offer(curr.right);
        }
        return result;
    }
    public static void main(String[] args){
        TestBFS obj = new TestBFS();
        Node<Character> root = new Node<>('a');
        root.left = new Node<>('b');
        root.right = new Node<>('c');
        root.left.left = new Node<>('d');
        root.left.right = new Node<>('e');
        root.right.right = new Node<>('f');

        List<Character> result = obj.findBFSValues(root);
        System.out.println(result);
    }
}