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
public class TreeMin{  
    public static int treeMinRec(Node<Integer> root){
        if(root == null) return Integer.MAX_VALUE;

        int smallestLeft = treeMinRec(root.left);        
        int smallestRight = treeMinRec(root.right);       

        smallestLeft = Math.min(smallestLeft, root.ele);
        smallestRight = Math.min(smallestRight, root.ele);
        return Math.min(smallestLeft, smallestRight);
    }
    public static int treeMin(Node<Integer> root){
        Stack<Node<Integer>> stack = new Stack<>();
        stack.push(root);
        int minVal = Integer.MAX_VALUE;
        while(!stack.isEmpty()){
            Node<Integer> curr = stack.pop();
            minVal = Math.min(curr.ele, minVal);

            if(curr.left != null) stack.push(curr.left);
            if(curr.right != null) stack.push(curr.right);
        }
        return minVal;
    }
    public static void main(String[] args){
        Node<Integer> root = new Node<>(5);
        root.left = new Node<>(11);
        root.right = new Node<>(3);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(15);
        root.right.right = new Node<>(12);

        int result = treeMinRec(root);
        System.out.println(result);
    }
}