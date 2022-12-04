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
public class TreeIncludes{  
    public static <E> boolean treeIncludesDFS(Node<E> root, E val){
        if(root == null) return false;
        if(root.ele == val) return true;

        if(treeIncludesDFS(root.left, val) || 
            treeIncludesDFS(root.right, val)) return true;

        return false;
    }
    public static <E> boolean treeIncludesBFS(Node<E> root, E val){
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            Node<E> curr = queue.poll();
            if(curr.ele == val) return true;

            if(curr.left != null) queue.offer(curr.left);
            if(curr.right != null) queue.offer(curr.right);
        }

        return false;
    }
    public static void main(String[] args){
        Node<Character> root = new Node<>('a');
        root.left = new Node<>('b');
        root.right = new Node<>('c');
        root.left.left = new Node<>('d');
        root.left.right = new Node<>('e');
        root.right.right = new Node<>('f');

        boolean result = treeIncludesBFS(root, 'g');
        System.out.println(result);
    }
}